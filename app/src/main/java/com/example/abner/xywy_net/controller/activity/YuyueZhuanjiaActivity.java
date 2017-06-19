package com.example.abner.xywy_net.controller.activity;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

import static android.R.id.edit;

/**
 * Created by think on 2017/6/16.
 */

public class YuyueZhuanjiaActivity extends BaseActivity {
    private Button btn_back_teacher;
    private ImageView imageView;
    private TextView textView_name,textView_depart,textView_title,
            textView_teach,textView_hospital,textView_goodat;

    @Override
    protected int layoutId() {
        return R.layout.yuyue_zhuanjia;
    }

    @Override
    protected void initView() {
        btn_back_teacher = (Button) findViewById(R.id.btn_back_teacher);
        imageView = (ImageView) findViewById(R.id.image);
        textView_name = (TextView) findViewById(R.id.name);
        textView_depart = (TextView) findViewById(R.id.textView_depart);
        textView_title = (TextView) findViewById(R.id.dc);
        textView_teach = (TextView) findViewById(R.id.textView_teach);
        textView_hospital = (TextView) findViewById(R.id.hos);
        textView_goodat = (TextView) findViewById(R.id.text);

    }

    @Override
    protected void initData() {

        SharedPreferences sp = getSharedPreferences("dc_data",MODE_PRIVATE);
        String app_image = sp.getString("app_image", "");
        String name = sp.getString("name", "");
        String depart = sp.getString("depart", "");
        String title = sp.getString("title", "");
        String teach = sp.getString("teach", "");
        String hospital = sp.getString("hospital", "");
        String goodat = sp.getString("goodat", "");
        Log.i("title",title);
        Glide.with(this).load(app_image).into(imageView);
        textView_name.setText(name);
        textView_depart.setText(depart);
        textView_title.setText(title);
        textView_teach.setText(teach);
        textView_hospital.setText(hospital);
        textView_goodat.setText(goodat);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        btn_back_teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
