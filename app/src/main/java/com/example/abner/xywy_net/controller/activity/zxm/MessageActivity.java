package com.example.abner.xywy_net.controller.activity.zxm;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class MessageActivity  extends BaseActivity {
    ImageView  back;
    LinearLayout  ask;
    @Override
    protected int layoutId() {
        return R.layout.activity_message;
    }

    @Override
    protected void initView() {
    back= (ImageView) findViewById(R.id.message_back);
        ask= (LinearLayout) findViewById(R.id.ask_doctor);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
     back.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             finish();
         }
     });
        ask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
