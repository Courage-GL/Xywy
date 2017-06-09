package com.example.abner.xywy_net.controller.activity;

import android.content.Intent;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.MainActivity;

/**
 * Created by Abner on 2017/6/9.
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected int layoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() throws InterruptedException {

        Thread.sleep(3000);
        startActivity(new Intent(this, MainActivity.class));

    }

    @Override
    protected void loadData() {


    }

    @Override
    protected void initListener() {

    }
}
