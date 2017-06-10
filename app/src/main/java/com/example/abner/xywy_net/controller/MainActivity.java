package com.example.abner.xywy_net.controller;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.base.FragmentBuilder;
import com.example.abner.xywy_net.controller.fragment.DoctorFragment;
import com.example.abner.xywy_net.controller.fragment.zxm.PersonaFragment;
import com.example.abner.xywy_net.controller.fragment.XueYaGuanliFragment;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private FrameLayout frameLayout;
    private RadioButton button1,button2,button3;

    @Override
    protected int layoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        frameLayout= (FrameLayout) findViewById(R.id.MainActivity_FrameLayout);
        button1= (RadioButton) findViewById(R.id.MainActivity_Button1);
        button2= (RadioButton) findViewById(R.id.MainActivity_Button2);
        button3= (RadioButton) findViewById(R.id.MainActivity_Button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
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
            case R.id.MainActivity_Button1:
                FragmentBuilder.getInstance(this).startFragment(DoctorFragment.class).addFragment(R.id.MainActivity_FrameLayout).builder();
                break;
            case R.id.MainActivity_Button2:
                FragmentBuilder.getInstance(MainActivity.this).startFragment(XueYaGuanliFragment.class).addFragment(R.id.MainActivity_FrameLayout).builder();
                break;
            case R.id.MainActivity_Button3:
             FragmentBuilder.getInstance(MainActivity.this).startFragment(PersonaFragment.class).addFragment(R.id.MainActivity_FrameLayout).builder();
                break;
            default:
                break;
        }

    }
}
