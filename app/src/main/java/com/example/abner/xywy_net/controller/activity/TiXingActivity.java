package com.example.abner.xywy_net.controller.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by Abner on 2017/6/12.
 */

public class TiXingActivity extends BaseActivity implements View.OnClickListener{
    private ImageView back;
    private TextView add;
    @Override
    protected int layoutId() {
        return R.layout.activity_tixing;
    }

    @Override
    protected void initView() {
        back= (ImageView) findViewById(R.id.tixing_back);
        add= (TextView) findViewById(R.id.tingxing_add);
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
            case R.id.tixing_back:
                finish();
                break;
            case R.id.tingxing_add:
                finish();
                break;

        }
    }
}
