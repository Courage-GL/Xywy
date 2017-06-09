package com.example.abner.xywy_net.controller;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.utils.netutils.ForNet;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private FrameLayout frameLayout;
    private RadioButton button1,button2,button3;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        frameLayout= (FrameLayout) findViewById(R.id.MainActivity_FrameLayout);
        button1= (RadioButton) findViewById(R.id.MainActivity_Button1);
        button2= (RadioButton) findViewById(R.id.MainActivity_Button2);
        button3= (RadioButton) findViewById(R.id.MainActivity_Button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {


    }
}
