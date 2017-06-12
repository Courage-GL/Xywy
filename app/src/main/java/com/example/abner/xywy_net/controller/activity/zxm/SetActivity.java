package com.example.abner.xywy_net.controller.activity.zxm;

import android.widget.RelativeLayout;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class SetActivity   extends BaseActivity{
    RelativeLayout  clearcache;
    @Override
    protected int layoutId() {
        return R.layout.activity_set;
    }

    @Override
    protected void initView() {
    clearcache= (RelativeLayout) findViewById(R.id.clearcache);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        clearcache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataCleanManager.cleanSharedPreference(SetActivity.this);
                Toast.makeText(SetActivity.this, "清除完成", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
