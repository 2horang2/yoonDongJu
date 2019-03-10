package com.stone.transition;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v4.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import horangya.jhm.begin.yoondongju.R;
import horangya.jhm.begin.yoondongju.TextActivity;

import com.nostra13.universalimageloader.core.ImageLoader;

import static horangya.jhm.begin.yoondongju.Utils.poemsList;
import static horangya.jhm.begin.yoondongju.Utils.setGlobalFont;
import static horangya.jhm.begin.yoondongju.Utils.typeface;

/**
 * Created by xmuSistone on 2016/9/18.
 */
public class CommonFragment extends Fragment implements DragLayout.GotoDetailListener {


    public int position;
    public CommonFragment() {
        // Required empty public constructor
    }

    public static Fragment newInstance( int i )
    {
        Fragment fragment = new Fragment ();
        Bundle cBundle = new Bundle();
        cBundle.putInt( "position",i );
        fragment.setArguments(cBundle);
        return fragment;
    }
    TextView poemTitle,poemText,lastDate,ratio;
    RelativeLayout view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_common, null);
        DragLayout dragLayout = (DragLayout) rootView.findViewById(R.id.drag_layout);


        view = dragLayout.findViewById(R.id.view);

        poemTitle = dragLayout.findViewById(R.id.poemTitle);
        poemText = dragLayout.findViewById(R.id.poemText);
        poemTitle.setText(poemsList.get(position).getPoemTitle());
        if( poemsList.get(position).getUserText().length()==0){
            poemText.setText("작품 채우러 가기");
        }else {
            poemText.setText(poemsList.get(position).getUserText());
        }


        lastDate = dragLayout.findViewById(R.id.lastDate);
        ratio = dragLayout.findViewById(R.id.ratio);

        lastDate.setText( poemsList.get(position).getDate() );
        ratio.setText( poemsList.get(position).getUserText().length() + " / " + poemsList.get(position).getPoemText().length() +" 글자");

        dragLayout.setGotoDetailListener(this);

        try{
            if(typeface == null) {
                typeface = Typeface.createFromAsset(rootView.getContext().getAssets(),
                        "Mohave.ttf");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        setGlobalFont( rootView );

        return rootView;
    }

    @Override
    public void gotoDetail() {
        Activity activity = (Activity) getContext();
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                new Pair(poemTitle, TextActivity.TITLE_TRANSITION_NAME),
                new Pair(poemText, TextActivity.TEXT_TRANSITION_NAME)
        );
        Intent intent = new Intent(activity, TextActivity.class);
        intent.putExtra("title",poemsList.get(position).getPoemTitle());
        intent.putExtra("writer",poemsList.get(position).getPoemWriter());
        intent.putExtra("text",poemsList.get(position).getPoemText());
        intent.putExtra("userText",poemsList.get(position).getUserText());
        ActivityCompat.startActivity(activity, intent, options.toBundle());
    }

    public void bindData(int position) {
        this.position = position;
    }
}
