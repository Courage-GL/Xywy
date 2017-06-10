package com.example.abner.xywy_net.controller.activity.zxm;

import android.view.View;
import android.widget.RelativeLayout;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class ZiliaoActivity  extends BaseActivity implements View.OnClickListener{
    RelativeLayout  name,sex,height,weight,birthday;
    @Override
    protected int layoutId() {
        return R.layout.activity_ziliao;
    }

    @Override
    protected void initView() {
     name= (RelativeLayout) findViewById(R.id.name);
        sex= (RelativeLayout) findViewById(R.id.sex);
        height= (RelativeLayout) findViewById(R.id.height);
        weight= (RelativeLayout) findViewById(R.id.weight);
        birthday= (RelativeLayout) findViewById(R.id.birthday);
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
            case R.id.name:

                break;
            case R.id.sex:

                break;
            case R.id.weight:

                break;
            case R.id.height:

                break;
            case R.id.birthday:

                break;
        }
    }
}
