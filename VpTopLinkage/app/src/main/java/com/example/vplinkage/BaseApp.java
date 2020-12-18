package com.example.vplinkage;

import android.app.Application;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-18 10:56
 */
public class BaseApp extends Application {

    private static BaseApp app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }

    public static BaseApp getInstance(){
        return app;
    }
}