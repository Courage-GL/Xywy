package com.example.abner.xywy_net.controller.activity;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.adapter.ViewpagerAdapter;
import com.example.abner.xywy_net.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/12.
 */

public class DcImagedetailOne extends BaseActivity implements View.OnClickListener{
    private ImageView dc_image;
    private TextView dc_name,dc_hospital,dc_zhiwei,dc_jineng,dc_tail,title_name;
    private Button back_btn;
    private ViewPager viewPager;
    private ViewpagerAdapter adapter;
    private List<Fragment> datas;
    private LinearLayout t1,t2,t3;
    @Override
    protected int layoutId() {
        return R.layout.image_detail;
    }

    @Override
    protected void initView() {
        t1 = (LinearLayout) findViewById(R.id.ta1);
        t2 = (LinearLayout) findViewById(R.id.ta2);
        t3 = (LinearLayout) findViewById(R.id.ta3);
        viewPager = (ViewPager) findViewById(R.id.mViewPage);
        back_btn = (Button) findViewById(R.id.btn_back_teacher);
        title_name = (TextView) findViewById(R.id.title_name);
        dc_image = (ImageView) findViewById(R.id.image_dc);
        dc_name = (TextView) findViewById(R.id.name_dc);
        dc_hospital = (TextView) findViewById(R.id.address_dc);
        dc_zhiwei = (TextView) findViewById(R.id.work_dc);
        dc_jineng = (TextView) findViewById(R.id.jineng_dc);
        dc_zhiwei = (TextView) findViewById(R.id.zhiwei_dc);
        dc_tail = (TextView) findViewById(R.id.text_dc);

    }

    @Override
    protected void initData() {
        datas = new ArrayList<>();
        adapter = new ViewpagerAdapter(getSupportFragmentManager(),datas);
        viewPager.setAdapter(adapter);
        String image = getIntent().getStringExtra("image");
        Glide.with(this).load(image).into(dc_image);
        String name = getIntent().getStringExtra("name");
        dc_name.setText(name);
        String hosptail = getIntent().getStringExtra("hosptail");
        dc_hospital.setText(hosptail);
        String title = getIntent().getStringExtra("title");
        dc_zhiwei.setText(title);
        String depart = getIntent().getStringExtra("depart");
        dc_jineng.setText(depart);
        String teach = getIntent().getStringExtra("teach");
        dc_zhiwei.setText(teach);
        String text = getIntent().getStringExtra("text");
        dc_tail.setText(text);
        title_name.setText(name);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        back_btn.setOnClickListener(this);
        t1.setOnClickListener(this);
        t2.setOnClickListener(this);
        t3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_teacher:
                onBackPressed();
                break;
            case R.id.ta1:
                break;
            case R.id.ta2:
                break;
            case R.id.ta3:
                break;
        }
    }
}
