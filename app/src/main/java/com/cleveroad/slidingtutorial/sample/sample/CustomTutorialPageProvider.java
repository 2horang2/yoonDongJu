package com.cleveroad.slidingtutorial.sample.sample;

import android.support.annotation.NonNull;
import android.app.Fragment;

import com.cleveroad.slidingtutorial.TutorialPageProvider;

public class CustomTutorialPageProvider implements TutorialPageProvider<Fragment> {

    @NonNull
    @Override
    public Fragment providePage(int position) {
        switch (position) {
            case 0:
                return new FirstCustomPageFragment();
            case 1:
                return new FirstCustomPageFragment2();
            case 2:
                return new SecondCustomPageFragment();
            case 3:
                return new SecondCustomPageFragment2();
            case 4:
                return new ThirdCustomPageFragment();
            case 5:
                return new ThirdCustomPageFragment3();
            default: {
                throw new IllegalArgumentException("Unknown position: " + position);
            }
        }
    }
}
