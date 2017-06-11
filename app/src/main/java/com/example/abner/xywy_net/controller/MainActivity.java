package com.example.abner.xywy_net.controller;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.base.FragmentBuilder;
import com.example.abner.xywy_net.controller.fragment.DoctorFragment;
import com.example.abner.xywy_net.controller.fragment.zxm.PersonaFragment;
import com.example.abner.xywy_net.controller.fragment.XueYaGuanliFragment;

import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener{
    private FrameLayout frameLayout;
    private RadioButton button1,button2,button3;
    //
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
        FragmentBuilder.getInstance(this).startFragment(DoctorFragment.class).addFragment(R.id.MainActivity_FrameLayout).builder();
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

        Intent intent=getIntent();
        String id = intent.getStringExtra("id");
        if("2".equals(id)){

            FragmentBuilder.getInstance(MainActivity.this).startFragment(XueYaGuanliFragment.class).addFragment(R.id.MainActivity_FrameLayout).builder();
        }
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
                FragmentBuilder.getInstance(this).startFragment(DoctorFragment.class).addFragment(R.id.MainActivity_FrameLayout).builder();
                break;
        }

    }


    private static boolean isExit = false;

    private final int BACK = 0;

    private Handler mHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                isExit = false;
            }
        }
    };

    public void exit() {
        if (!isExit) {
            isExit = true;
            Toast.makeText(MainActivity.this, "再次点击退出程序",
                    Toast.LENGTH_SHORT).show();
            // 利用handler延迟发送更改状态信息
            mHandler.sendEmptyMessageDelayed(BACK, 2000);
        } else {
            finish();
            System.exit(0);
        }
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        return super.onKeyDown(keyCode, event);
        if (keyCode == KeyEvent.KEYCODE_BACK) {
           exit();
            return false;

        }
        return super.onKeyDown(keyCode, event);
    }
    public void getParam(){



    }

}
