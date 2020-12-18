package com.example.vplinkage.transformer;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.ViewPager;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 12:29
 */
public abstract class BasePageTransformers implements ViewPager.PageTransformer {

    @Override
    public void transformPage(@NonNull View page, float position) {
        if (position == 0){
            currentPage(page,position);
        }
    }

    protected abstract void currentPage(View page, float position);
}