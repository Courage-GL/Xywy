package com.example.abner.xywy_net.controller.activity.zxm;

import android.view.View;
import android.widget.ImageView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

import static com.example.abner.xywy_net.R.id.shoucang_back;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class ShoucangActivity  extends BaseActivity {
    ImageView  back;
    @Override
    protected int layoutId() {
        return R.layout.activity_shoucang;
    }

    @Override
    protected void initView() {
     back= (ImageView) findViewById(shoucang_back);
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
    }
}
