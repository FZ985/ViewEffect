package com.example.vplinkage.transformer;

import android.util.Log;
import android.view.View;

import androidx.viewpager.widget.ViewPager;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 11:49
 */
public class ScaleTransformer implements ViewPager.PageTransformer {
    private static final float MAX_SCALE = 1.0f;
    private static final float MIN_SCALE = 0.5f;

    private void log(String m) {
        Log.e("ScaleTransformer", m);
    }

    private float leftOffest = 0f;

    @Override
    public void transformPage(View view, float position) {
//        if (position <= 1) {
//            //   0.5f + (1f-Math.abs(position))*(1.0f-0.5f)
//            float scaleFactor = MIN_SCALE + (1.0F - Math.abs(position)) * (MAX_SCALE - MIN_SCALE);
//            log("scaleFactor:" + scaleFactor);
//            view.setScaleX(scaleFactor);  //缩放效果
//            view.setScaleY(scaleFactor);
//        } else {
//            view.setScaleX(MIN_SCALE);
//            view.setScaleY(MIN_SCALE);
//        }

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
        } else if (position <= 1) { // [-1,1]
            // Modify the default slide transition to shrink the page as well
            if (position < 0) { //1-2:1[0,-1] ;2-1:1[-1,0]
                float scaleFactor = (1 + position) * (1 - MIN_SCALE) + MIN_SCALE;
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
                view.setAlpha(scaleFactor);
            } else { //1-2:2[1,0] ;2-1:2[0,1]
                float scaleFactor = (1 - position) * (1 - MIN_SCALE) + MIN_SCALE;
                view.setScaleX(scaleFactor);
                view.setScaleY(scaleFactor);
                view.setAlpha(scaleFactor);
            }
        } else { // (1,+Infinity]
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);

        }
    }


}