package com.example.abner.xywy_net.controller.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.MainActivity;

/**
 * Created by Abner on 2017/6/9.
 */

public class SplashActivity extends BaseActivity {

    private final int SPLASH_DISPLAY_LENGHT = 3000; //延迟三秒
    @Override
    protected int layoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView()  {
        new Handler().postDelayed(new Runnable(){

            public void run() {
            Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
            SplashActivity.this.startActivity(mainIntent);
            SplashActivity.this.finish();
        }

    }, SPLASH_DISPLAY_LENGHT);


}

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {


    }

    @Override
    protected void initListener() {

    }
}
