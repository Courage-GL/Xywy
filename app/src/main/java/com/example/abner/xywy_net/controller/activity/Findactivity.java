package com.example.abner.xywy_net.controller.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.base.FragmentBuilder;
import com.example.abner.xywy_net.controller.fragment.DoctorFragment;

/**
 * Created by think on 2017/6/13.
 */

public class Findactivity extends BaseActivity {

    private EditText editText;
    private TextView textView;
    private ImageView imageView;

    @Override
    protected int layoutId() {
        return R.layout.activity_find;
    }

    @Override
    protected void initView() {
        imageView = (ImageView) findViewById(R.id.update_back);
        editText = (EditText) findViewById(R.id.edittext_set);
        textView = (TextView) findViewById(R.id.ok);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editText.getText().toString().equals("")){
                    Toast.makeText(Findactivity.this, "关键字不能为空~", Toast.LENGTH_SHORT).show();
                }else{
                    String Key = editText.getText().toString();
                    SharedPreferences sp = getSharedPreferences("findkey",MODE_PRIVATE);
                    SharedPreferences.Editor edit = sp.edit();
                    edit.putString("content",editText.getText().toString());
                    edit.commit();
                    finish();
                }
            }
        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }
}
