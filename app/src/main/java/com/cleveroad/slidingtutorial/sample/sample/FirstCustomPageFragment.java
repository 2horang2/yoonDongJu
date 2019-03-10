package com.cleveroad.slidingtutorial.sample.sample;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.PageFragment;
import com.cleveroad.slidingtutorial.TransformItem;
import com.stone.transition.DragLayout;

import horangya.jhm.begin.yoondongju.R;

import static horangya.jhm.begin.yoondongju.Utils.poemsList;
import static horangya.jhm.begin.yoondongju.Utils.setGlobalFont;
import static horangya.jhm.begin.yoondongju.Utils.typeface;

public class FirstCustomPageFragment extends PageFragment {

    @Override
    protected int getLayoutResId() {
        return R.layout.fragment_page_first;
    }

    @NonNull
    @Override
    protected TransformItem[] getTransformItems() {
        return new TransformItem[]{
                TransformItem.create(R.id.ivFirstImage, Direction.LEFT_TO_RIGHT, 0.2f),
                TransformItem.create(R.id.ivSecondImage, Direction.RIGHT_TO_LEFT, 0.06f)
        };
    }
}