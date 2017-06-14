package com.example.abner.xywy_net.controller.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseFragment;
import com.example.abner.xywy_net.bean.Message;
import com.example.abner.xywy_net.bluetooth.ClientActivity;
import com.example.abner.xywy_net.controller.activity.AlarmActivity;
import com.example.abner.xywy_net.controller.activity.AskDoctorActivity;
import com.example.abner.xywy_net.controller.activity.UpDataActivity;
import com.example.abner.xywy_net.controller.activity.XueYaZiXunActivity;
import com.example.abner.xywy_net.tongjitu.LineView;


import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by Abner on 2017/6/9.
 */

public class XueYaGuanliFragment extends BaseFragment implements View.OnClickListener{
    private ImageView updataImage;
    private RelativeLayout rlLinechart;
    private RadioButton textBtn1,textBtn2,textBtn3,textBtn4,askDoctorBtn,messageBtn,alarmBtn,bluetoothBtn;
//
    private String data,time,week,mounth;
    private int gaoya,diya,xinlv;
    private LineView lineView;
    List<Integer> twoInt;
    List<Integer> oneInt;
    List<Integer> lineTwoDate,lineOneDate;
    List<Integer> yLineDate;
    List<String> xLineDate;
    @Override
    protected int layoutId() {
        return R.layout.fragmnet_xueyaguanli;
    }
    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        rlLinechart= (RelativeLayout) view.findViewById(R.id.rl_linechart);
        updataImage= (ImageView) view.findViewById(R.id.updateData);
        textBtn1= (RadioButton) view.findViewById(R.id.text_Button1);
        textBtn2= (RadioButton) view.findViewById(R.id.text_Button2);
        textBtn3= (RadioButton) view.findViewById(R.id.text_Button3);
        textBtn4= (RadioButton) view.findViewById(R.id.text_Button4);
        askDoctorBtn= (RadioButton) view.findViewById(R.id.askDoctor_Btn);
        messageBtn= (RadioButton) view.findViewById(R.id.message_Btn);
        alarmBtn= (RadioButton) view.findViewById(R.id.alarm_Btn);
        bluetoothBtn= (RadioButton) view.findViewById(R.id.bluetooth_Btn);
        updataImage.setOnClickListener(this);
        textBtn1.setOnClickListener(this);
        textBtn2.setOnClickListener(this);
        textBtn3.setOnClickListener(this);
        textBtn4.setOnClickListener(this);
        askDoctorBtn.setOnClickListener(this);
        messageBtn.setOnClickListener(this);
        alarmBtn.setOnClickListener(this);
        bluetoothBtn.setOnClickListener(this);
        xLineDate = new ArrayList<>();
        yLineDate = new ArrayList<>();
        lineOneDate = new ArrayList<>();
        lineTwoDate = new ArrayList<>();
         oneInt = new ArrayList<>();
         twoInt = new ArrayList<>();
        int[] yInt = {0, 20, 40, 60, 80, 100, 120,140,160,180,200};
        String[] xString = {"0","周一", "周二", "周三", "周四", "周五", "周六", "周日"};

        for(int m= 0;m<xString.length;m++){

            xLineDate.add(xString[m]);
        }
        for(int n= 0;n<yInt.length;n++){

            yLineDate.add(yInt[n]);
        }

        huaTu();


    }

    @Override
    protected void loadData() {

    }
    @Override
    protected void initListener() {


    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void helloEventBus(Message message){
        gaoya=Integer.parseInt(message.getGaoya());
        diya= Integer.parseInt(message.getDiya());
        data= message.getData();
        time=message.getTime();
        mounth= message.getMouth();
        week=message.getWeek();
        Log.i("aaaaa","-------------------------------");
        Log.i("aaaaa",gaoya+"");
        Log.i("aaaaa",diya+"");
        Log.i("aaaaa","-------------------------------");

        Log.i("time",  System.currentTimeMillis()+"");
        handler.sendEmptyMessage(0);
        android.os.Message mmsg=new android.os.Message();
        mmsg.arg1=gaoya;
        mmsg.arg2=diya;
        handler.sendMessage(mmsg);
    }

    private void huaTu() {
        for (int i = 0; i < oneInt.size(); i++) {
            lineOneDate.add(oneInt.get(i));
            lineTwoDate.add(twoInt.get(i));
        }
        lineView= new LineView(getActivity(), lineOneDate, lineTwoDate, xLineDate, yLineDate);
        rlLinechart.addView(lineView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.updateData:
                startActivity(new Intent(getActivity(), UpDataActivity.class));
                break;
            case R.id.text_Button1:
                huaTu();
                break;
            case R.id.text_Button2:
                huaTu();
                break;
            case R.id.text_Button3:
                huaTu();
                break;
            case R.id.text_Button4:
                huaTu();
                break;
            case R.id.askDoctor_Btn:
                startActivity(new Intent(getActivity(), AskDoctorActivity.class));
                break;
            case R.id.message_Btn:
                startActivity(new Intent(getActivity(), XueYaZiXunActivity.class));
                break;
            case R.id.alarm_Btn:
                startActivity(new Intent(getActivity(), AlarmActivity.class));
                break;
            case R.id.bluetooth_Btn:
                startActivity(new Intent(getActivity(),ClientActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
   Handler handler=new Handler(){
        @Override
        public void handleMessage(android.os.Message msg) {
            super.handleMessage(msg);
            int i= msg.arg1;
            int i1 = msg.arg2;
            oneInt.add(i);
            twoInt.add(i1);
            oneInt.add(100);
            twoInt.add(200);
            Log.i("aaaaa",i+i1+"");
            lineView.getData(lineOneDate,lineTwoDate,xLineDate,yLineDate);
        }
    };
}
