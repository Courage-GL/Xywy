package com.example.abner.xywy_net.controller.activity.zxm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

public class JiahaoActivity extends BaseActivity {
    ImageView  jiahao_back;


    @Override
    protected int layoutId() {
        return R.layout.activity_jiahao;
    }

    @Override
    protected void initView() {
        jiahao_back= (ImageView) findViewById(R.id.jiahao_back);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        jiahao_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
