package horangya.jhm.begin.yoondongju;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.cleveroad.slidingtutorial.sample.sample.CustomTutorialFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import static horangya.jhm.begin.yoondongju.Utils.setGlobalFont;
import static horangya.jhm.begin.yoondongju.Utils.typeface;

public class Init extends AppCompatActivity {
    public static void start(Context context) {
        context.startActivity(new Intent(context, Init.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);



        SharedPreferences pref = getSharedPreferences("startingDate" , MODE_PRIVATE);
        String str = pref.getString("startingDate" ,  null);

        if(str != null){
            startActivity(new Intent(Init.this,IntroActivity.class));
            finish();
        }else{
            SharedPreferences.Editor editor = pref.edit();
            editor.putString("startingDate", new SimpleDateFormat("yyyy-MM-dd").format(new Date()).toString() );
            //editor.putString("startingDate","2018-11-01" );
            editor.commit();
        }


        if (savedInstanceState == null) {
            replaceTutorialFragment();
        }

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


    public void replaceTutorialFragment() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.container, CustomTutorialFragment.newInstance())
                .commit();
    }
}
