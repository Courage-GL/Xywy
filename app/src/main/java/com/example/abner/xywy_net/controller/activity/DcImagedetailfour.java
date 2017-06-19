package com.example.abner.xywy_net.controller.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.fragment.Zhuanjiafragment;

/**
 * Created by think on 2017/6/12.
 */

public class DcImagedetailfour extends BaseActivity implements View.OnClickListener {

    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;

    private ImageView dc_image;
    private TextView dc_name,dc_hospital,dc_zhiwei,dc_jineng,dc_tail,title_name;
    private Button back_btn;
    @Override
    protected int layoutId() {
        return R.layout.image_detail;
    }

    @Override
    protected void initView() {
        back_btn = (Button) findViewById(R.id.btn_back_teacher);
        title_name = (TextView) findViewById(R.id.title_name);
        dc_image = (ImageView) findViewById(R.id.image_dc);
        dc_name = (TextView) findViewById(R.id.name_dc);
        dc_hospital = (TextView) findViewById(R.id.address_dc);
        dc_zhiwei = (TextView) findViewById(R.id.work_dc);
        dc_jineng = (TextView) findViewById(R.id.jineng_dc);
        dc_zhiwei = (TextView) findViewById(R.id.zhiwei_dc);
        dc_tail = (TextView) findViewById(R.id.text_dc);
        fragmentManager =  getFragmentManager();
    }

    @Override
    protected void initData() {
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
        Zhuanjiafragment zhuanjiafragment = new Zhuanjiafragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.framlayout, zhuanjiafragment);
        fragmentTransaction.commit();
    }

    @Override
    protected void initListener() {
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_teacher:
                onBackPressed();
                break;
        }
    }
}
