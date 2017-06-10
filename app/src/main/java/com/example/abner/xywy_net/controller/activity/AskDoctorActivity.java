package com.example.abner.xywy_net.controller.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by Abner on 2017/6/10.
 */

public class AskDoctorActivity extends BaseActivity {
    private TextView askDocotor_Data;
    private ImageView askDocotor_back;
    @Override
    protected int layoutId() {
        return R.layout.activity_askdoctor;
    }

    @Override
    protected void initView() {
        askDocotor_Data= (TextView) findViewById(R.id.askDocotor_Data);
        askDocotor_back= (ImageView) findViewById(R.id.askdoctor_back);

    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        askDocotor_Data.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(AskDoctorActivity.this, FreeAskActivity.class));
            }
        });
        askDocotor_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
