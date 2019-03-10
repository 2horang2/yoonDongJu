package com.cleveroad.slidingtutorial.sample.sample;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;

import com.cleveroad.slidingtutorial.Direction;
import com.cleveroad.slidingtutorial.PageOptions;
import com.cleveroad.slidingtutorial.TransformItem;
import com.cleveroad.slidingtutorial.TutorialPageOptionsProvider;

import horangya.jhm.begin.yoondongju.R;


public class CustomTutorialOptionsProvider implements TutorialPageOptionsProvider {


    @NonNull
    @Override
    public PageOptions provide(int position) {
        @LayoutRes int pageLayoutResId;
        TransformItem[] tutorialItems;
        switch (position) {
            case 0: {
                pageLayoutResId = R.layout.fragment_page_first;
                tutorialItems = new TransformItem[]{
                        TransformItem.create(R.id.ivFirstImage, Direction.LEFT_TO_RIGHT, 0.2f)
                };
                break;
            }
            case 1: {
                pageLayoutResId = R.layout.fragment_page_first2;
                tutorialItems = new TransformItem[]{
                        TransformItem.create(R.id.ivFirstImage, Direction.LEFT_TO_RIGHT, 0.2f)
                };
                break;
            }
            case 2: {
                pageLayoutResId = R.layout.fragment_page_second;
                tutorialItems = new TransformItem[]{
                        TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
                };
                break;
            }
            case 3: {
                pageLayoutResId = R.layout.fragment_page_second2;
                tutorialItems = new TransformItem[]{
                        TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f),
                };
                break;
            }
            case 4: {
                pageLayoutResId = R.layout.fragment_page_third;
                tutorialItems = new TransformItem[]{
                        TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f)
                };
                break;
            }
            case 5: {
                pageLayoutResId = R.layout.fragment_page_third2;
                tutorialItems = new TransformItem[]{
                        TransformItem.create(R.id.ivFirstImage, Direction.RIGHT_TO_LEFT, 0.2f)
                };
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown position: " + position);

            }
        }

        return PageOptions.create(pageLayoutResId, position, tutorialItems);
    }
}
