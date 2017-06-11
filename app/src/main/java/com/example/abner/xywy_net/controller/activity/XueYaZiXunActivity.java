package com.example.abner.xywy_net.controller.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.activity.zxm.zixun.CheckActivity;
import com.example.abner.xywy_net.controller.activity.zxm.zixun.CommonmsgActivity;
import com.example.abner.xywy_net.controller.activity.zxm.zixun.CureActivity;
import com.example.abner.xywy_net.controller.activity.zxm.zixun.FoodActivity;
import com.example.abner.xywy_net.controller.activity.zxm.zixun.PreActicvity;

/**
 * Created by Abner on 2017/6/10.
 */

public class XueYaZiXunActivity extends BaseActivity implements View.OnClickListener{
    private TextView commond,cookbook,prevent,treat,check;
    private ImageView back;
    @Override
    protected int layoutId() {
        return R.layout.activity_xueyazixun;
    }

    @Override
    protected void initView() {
        commond= (TextView) findViewById(R.id.commond);
        commond.setOnClickListener(this);
        cookbook= (TextView) findViewById(R.id.cookbook);
        cookbook.setOnClickListener(this);
        prevent= (TextView) findViewById(R.id.prevent);
        prevent.setOnClickListener(this);
        treat= (TextView) findViewById(R.id.treat);
        treat.setOnClickListener(this);
        cookbook= (TextView) findViewById(R.id.check);
        cookbook.setOnClickListener(this);
        back= (ImageView) findViewById(R.id.xueya_back);
        back.setOnClickListener(this);
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
            case R.id.commond:
                Intent  intent=new Intent(XueYaZiXunActivity.this, CommonmsgActivity.class);
                startActivity(intent);
                break;
            case R.id.cookbook:
                Intent  intent1=new Intent(XueYaZiXunActivity.this, FoodActivity.class);
                startActivity(intent1);
                break;
            case R.id.prevent:
                Intent  intent2=new Intent(XueYaZiXunActivity.this, PreActicvity.class);
                startActivity(intent2);
                break;
            case R.id.treat:
                Intent  intent3=new Intent(XueYaZiXunActivity.this, CureActivity.class);
                startActivity(intent3);
                break;
            case R.id.check:
                Intent  intent5=new Intent(XueYaZiXunActivity.this, CheckActivity.class);
                startActivity(intent5);
                break;
            case R.id.xueya_back:
                finish();
                break;
            default:
                break;
        }
    }
}
