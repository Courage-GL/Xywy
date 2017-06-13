package com.example.abner.xywy_net.controller.activity;

import android.view.View;
import android.widget.ImageView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by Abner on 2017/6/10.
 */

public class FreeAskActivity extends BaseActivity implements View.OnClickListener{
    private ImageView imageView_back;
    @Override
    protected int layoutId() {
        return R.layout.activity_freeask;
    }

    @Override
    protected void initView() {
        imageView_back = (ImageView) findViewById(R.id.update_back);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        imageView_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.update_back:
                finish();
                break;
        }
    }
}
