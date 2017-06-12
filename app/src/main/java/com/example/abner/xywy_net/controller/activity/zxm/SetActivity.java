package com.example.abner.xywy_net.controller.activity.zxm;

import android.app.Application;
import android.content.Intent;
import android.os.Looper;
import android.view.View;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.example.abner.xywy_net.App;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.activity.zxm.clearcache.ClearCache;

import java.io.File;

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
//             Intent  intent=new Intent(SetActivity.this, ClearCache.class);
//             startActivity(intent);
         }
     });
    }





}
