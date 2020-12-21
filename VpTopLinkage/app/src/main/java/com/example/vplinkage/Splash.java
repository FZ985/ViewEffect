package com.example.vplinkage;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.vplinkage.databinding.ActivitySplashBinding;
import com.example.vplinkage.ui.magicindicator.MaigcAcivity;

/**
 * Description:
 * Author: jfz
 * Date: 2020-12-21 9:37
 */
public class Splash extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(ActivitySplashBinding.inflate(getLayoutInflater()).getRoot());
    }


    public void viewpager(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }

    public void magicindicator(View view) {
        startActivity(new Intent(this, MaigcAcivity.class));
    }
}