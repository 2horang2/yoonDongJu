package horangya.jhm.begin.yoondongju;

import android.app.Activity;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import horangya.jhm.begin.yoondongju.dummy.Poem;


public class Utils {


    public static ArrayList<Drawable> backList = new ArrayList<Drawable>() ;
    public static int backInt =0;

    public static ArrayList<Poem> poemsList  = new ArrayList<>();


    public static Typeface typeface;
    public static void setGlobalFont(View view) {
        if(view != null) {
            if(view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup)view;
                int vgCnt = viewGroup.getChildCount();
                for(int i = 0; i<vgCnt; i++) {
                    View v = viewGroup.getChildAt(i);
                    if(v instanceof TextView) {
                        ((TextView) v).setTypeface(typeface);
                    }
                    setGlobalFont(v);
                }
            }
        }
    }

//
//    public static void changeToolbarFont(Toll toolbar, Activity context) {
//        for (int i = 0; i < toolbar.getChildCount(); i++) {
//            View view = toolbar.getChildAt(i);
//            if (view instanceof TextView) {
//                TextView tv = (TextView) view;
//                if (tv.getText().equals(toolbar.getTitle())) {
//                    applyFont(tv, context);
//                    break;
//                }
//            }
//        }
//    }
    public static void applyFont(TextView tv, Activity context) {
        tv.setTypeface(Typeface.createFromAsset(context.getAssets(), "Mohave.ttf"));
    }
}
