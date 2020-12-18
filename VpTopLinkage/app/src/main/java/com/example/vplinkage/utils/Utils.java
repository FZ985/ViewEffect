package com.example.vplinkage.utils;

import com.example.vplinkage.BaseApp;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 10:56
 */
public class Utils {
    public static int dip2px(float dpValue) {
        final float scale = BaseApp.getInstance().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int getScreenWidth() {
        return BaseApp.getInstance().getResources().getDisplayMetrics().widthPixels;
    }
}