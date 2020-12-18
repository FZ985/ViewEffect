package com.example.vplinkage.transformer;

import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 10:47
 */

public class NonPageTransformer implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        page.setScaleX(0.999f);//hack
    }

    public static final ViewPager.PageTransformer INSTANCE = new NonPageTransformer();
}