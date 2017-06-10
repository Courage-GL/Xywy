package com.example.abner.xywy_net.controller.activity;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by Abner on 2017/6/10.
 */

public class UpDataActivity extends BaseActivity implements View.OnClickListener {
    private ImageView updata_back;
    private TextView updata_Data,updata_Time;
    private EditText updata_SheBei,updata_GaoYa,updata_DiYa;
    @Override
    protected int layoutId() {
        return R.layout.activity_updata;
    }

    @Override
    protected void initView() {
        updata_back= (ImageView) findViewById(R.id.update_back);
        updata_Data= (TextView) findViewById(R.id.update_Data);
        updata_Time= (TextView) findViewById(R.id.update_Time);
        updata_SheBei= (EditText) findViewById(R.id.update_SheBei);
        updata_GaoYa= (EditText) findViewById(R.id.update_GaoYa);
        updata_DiYa= (EditText) findViewById(R.id.update_DiYa);
        updata_back.setOnClickListener(this);
        updata_Data.setOnClickListener(this);
        updata_Time.setOnClickListener(this);
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
            case R.id.update_Data:
                break;
            case R.id.update_back:
                this.finish();
                break;
            case R.id.update_Time:
                break;
            default:
                break;
        }
    }
}
