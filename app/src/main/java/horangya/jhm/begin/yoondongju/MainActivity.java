package horangya.jhm.begin.yoondongju;

import android.app.Activity;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.merhold.extensiblepageindicator.ExtensiblePageIndicator;
import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.stone.transition.CommonFragment;
import com.stone.transition.CustPagerTransformer;


import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;


import horangya.jhm.begin.yoondongju.R;
import horangya.jhm.begin.yoondongju.TextActivity;
import horangya.jhm.begin.yoondongju.db.DbOpenHelper;
import horangya.jhm.begin.yoondongju.dummy.Poem;

import static horangya.jhm.begin.yoondongju.Utils.backList;
import static horangya.jhm.begin.yoondongju.Utils.poemsList;
import static horangya.jhm.begin.yoondongju.Utils.setGlobalFont;
import static horangya.jhm.begin.yoondongju.Utils.typeface;
import static horangya.jhm.begin.yoondongju.Utils.backInt
        ;

/**
 * Created by xmuSistone on 2016/9/18.
 */
public class MainActivity extends AppCompatActivity{

    private TextView indicatorTv;
    private View positionView;
    private ViewPager viewPager;
    private List<CommonFragment> fragments = new ArrayList<>(); // 供ViewPager使用
    DrawerLayout drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        backList = new ArrayList<>();
        backList.add(getResources().getDrawable(R.drawable.yundongju_main2));
        backList.add(getResources().getDrawable(R.drawable.yundongju_main4));
        backList.add(getResources().getDrawable(R.drawable.yundongju_main5));
        Random random = new Random();
        backInt = random.nextInt(backList.size());
        drawer.setBackground(backList.get(backInt));

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(Color.TRANSPARENT);
                getWindow()
                        .getDecorView()
                        .setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            } else {
                getWindow()
                        .setFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS, WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }

        setPoem();

        initImageLoader();

        fillViewPager();
        init_nav();
        try{
            if(typeface == null) {
                typeface = Typeface.createFromAsset( getAssets(),
                        "Mohave.ttf");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        setGlobalFont( getWindow().getDecorView());


    }

    void setPoem(){


        DbOpenHelper mDbOpenHelper = new DbOpenHelper(this);
        mDbOpenHelper.open();
        mDbOpenHelper.create();
        poemsList= new ArrayList<>();

        //
        //
        // Cursor iCursor = mDbOpenHelper.selectColumns();
        Cursor iCursor = mDbOpenHelper.sortColumn("poemTitle");


        while(iCursor.moveToNext()){
            Poem item = new Poem();
            item.setId(iCursor.getLong(iCursor.getColumnIndex("id")));
            item.setPoemTitle(iCursor.getString(iCursor.getColumnIndex("poemTitle")));
            item.setPoemWriter(iCursor.getString(iCursor.getColumnIndex("poemWriter")));
            item.setPoemText(iCursor.getString(iCursor.getColumnIndex("poemText")));
            item.setUserTitle(iCursor.getString(iCursor.getColumnIndex("userTitle")));
            item.setUserWriter(iCursor.getString(iCursor.getColumnIndex("userWriter")));
            item.setUserText(iCursor.getString(iCursor.getColumnIndex("userText")));
            item.setDate(iCursor.getString(iCursor.getColumnIndex("lsDate")));
            poemsList.add(item);
        }


    }


    private void fillViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setPageTransformer(false, new CustPagerTransformer(this));

        for (int i = 0; i < poemsList.size(); i++) {
            CommonFragment commonFragment = new CommonFragment();
            commonFragment.newInstance(i);
            fragments.add(commonFragment);
        }

        viewPager.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                CommonFragment fragment = fragments.get(position );
                fragment.bindData(position);
                return fragment;
            }

            @Override
            public int getCount() {
                return poemsList.size();
            }
        });
        ExtensiblePageIndicator extensiblePageIndicator = (ExtensiblePageIndicator) findViewById(R.id.flexibleIndicator);
        extensiblePageIndicator.initViewPager(viewPager);
    }
    @NonNull

    private final ViewPager.OnPageChangeListener mOnPageChangeListener = new ViewPager.OnPageChangeListener()
    {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {/*empty*/
        }

        @Override
        public void onPageSelected(int position) {
        }

        @Override
        public void onPageScrollStateChanged(int state) {/*empty*/}
    };




    private int getStatusBarHeight() {
        Class<?> c = null;
        Object obj = null;
        Field field = null;
        int x = 0, statusBarHeight = 0;
        try {
            c = Class.forName("com.android.internal.R$dimen");
            obj = c.newInstance();
            field = c.getField("status_bar_height");
            x = Integer.parseInt(field.get(obj).toString());
            statusBarHeight = getResources().getDimensionPixelSize(x);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        return statusBarHeight;
    }

    @SuppressWarnings("deprecation")
    private void initImageLoader() {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                this)
                .memoryCacheExtraOptions(480, 800)
                // default = device screen dimensions
                .threadPoolSize(3)
                // default
                .threadPriority(Thread.NORM_PRIORITY - 1)
                // default
                .tasksProcessingOrder(QueueProcessingType.FIFO)
                // default
                .denyCacheImageMultipleSizesInMemory()
                .memoryCache(new LruMemoryCache(2 * 1024 * 1024))
                .memoryCacheSize(2 * 1024 * 1024).memoryCacheSizePercentage(13) // default
                .discCacheSize(50 * 1024 * 1024) // 缓冲大小
                .discCacheFileCount(100) // 缓冲文件数目
                .discCacheFileNameGenerator(new HashCodeFileNameGenerator()) // default
                .imageDownloader(new BaseImageDownloader(this)) // default
                .defaultDisplayImageOptions(DisplayImageOptions.createSimple()) // default
                .writeDebugLogs().build();

        // 2.单例ImageLoader类的初始化
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")

    ArrayList<Poem> mlist = new ArrayList<>();
    void init_nav(){

        ListView listTreasureRat = (ListView)findViewById(R.id.list_poem);

        Calendar cal = new GregorianCalendar(Locale.KOREA);
        cal.setTime(new Date());
        SimpleDateFormat fm = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat fmEndDate = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = fmEndDate.format(cal.getTime());

        int userComplete = 0;

        for (int i = 0; i < Utils.poemsList.size(); i++) {
            if (Utils.poemsList.get(i).getPoemText().length() == Utils.poemsList.get(i).getUserText().length()){
                userComplete++;
            }
            mlist.add(Utils.poemsList.get(i));
        }

        ItemAdapter adapter = new ItemAdapter(this,mlist);
        listTreasureRat.setAdapter(adapter);
        listTreasureRat.setClickable(true);

        TextView txtTreasureCnt,txtTreasureRat;
        txtTreasureCnt = findViewById(R.id.txt_v_poem_cnt);
        txtTreasureRat = findViewById(R.id.txt_v_poem_rat);

        txtTreasureCnt.setText(Utils.poemsList.size() +" 개 ");
        txtTreasureRat.setText(userComplete +" 개 ");
    }

    class ItemAdapter extends BaseAdapter {

        Activity context;
        public ItemAdapter(Activity context, ArrayList<Poem> items){
            this.context = context;
            mlist = items;
        }
        @Override
        public int getCount() {
            return mlist.size();
        }

        @Override
        public Object getItem(int position) {
            return mlist.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = LayoutInflater.from(getApplicationContext()).
                    inflate(R.layout.fragment_item,parent,false);
            TextView tv = (TextView)view.findViewById(R.id.title);
            tv.setText(mlist.get(position).getPoemTitle());
            if (mlist.get(position).getPoemText().length() <= mlist.get(position).getUserText().length()){
                view.findViewById(R.id.img).setVisibility(View.VISIBLE);
            }else{
                view.findViewById(R.id.img).setVisibility(View.GONE);
            }
            try{
                if(typeface == null) {
                    typeface = Typeface.createFromAsset(view.getContext().getAssets(),
                            "Mohave.ttf");
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            setGlobalFont(view);

            return view;
        }
    }
}
