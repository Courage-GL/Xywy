package com.example.abner.xywy_net.controller.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by Abner on 2017/6/12.
 */

public class AlarmActivity extends BaseActivity implements View.OnClickListener {
    private ImageView back,add;
    @Override
    protected int layoutId() {
        return R.layout.activity_alarm;
    }

    @Override
    protected void initView() {
        back= (ImageView) findViewById(R.id.alarm_back);
        add= (ImageView) findViewById(R.id.alarm_add);
        back.setOnClickListener(this);
        add.setOnClickListener(this);

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
        switch (v.getId()){
            case R.id.alarm_back:
                finish();
                break;
            case R.id.alarm_add:
                startActivity(new Intent(AlarmActivity.this,TiXingActivity.class));
                break;

        }
    }
}
