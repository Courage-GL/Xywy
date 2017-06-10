package com.example.abner.xywy_net.controller.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

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
        cookbook= (TextView) findViewById(R.id.cookbook);
        prevent= (TextView) findViewById(R.id.prevent);
        treat= (TextView) findViewById(R.id.treat);
        cookbook= (TextView) findViewById(R.id.check);
        back= (ImageView) findViewById(R.id.xueya_back);
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
                break;
            case R.id.cookbook:
                break;
            case R.id.prevent:
                break;
            case R.id.treat:
                break;
            case R.id.check:
                break;
            case R.id.xueya_back:
                finish();
                break;
            default:
                break;
        }
    }
}
