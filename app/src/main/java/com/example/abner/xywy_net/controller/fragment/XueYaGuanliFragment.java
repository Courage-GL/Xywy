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
    private RadioButton textBtn1,textBtn2,textBtn3,textBtn4,askDoctorBtn,messageBtn,alarmBtn,bluetoothBtn;
//
    private int gaoya,diya,xinlv;
    private static LineView mSkinLineView;
    private ArrayList<Integer> colorList = new ArrayList<>();//折线的颜色列表
    private ArrayList<String> XLabel = new ArrayList<>(); //X轴上的标签数据列表
    private ArrayList<String> YLabel = new ArrayList<>(); //Y轴上的标签数据列表
    private ArrayList<ArrayList<Integer>> dataLists;//折线上的数据列表
    private ArrayList<Integer> dataList1;
    private ArrayList<Integer> dataList2;
    private int i;
    private int i1;
    @Override
    protected int layoutId() {
        return R.layout.fragmnet_xueyaguanli;
    }
    @Override
    protected void initView(View view) {
        EventBus.getDefault().register(this);
        mSkinLineView = (LineView) view.findViewById(R.id.mLineView);
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
        initHuaTu();
    }

    private void initHuaTu() {

        colorList.add(getResources().getColor(R.color.using_before));
        colorList.add(getResources().getColor(R.color.using_after));
        for (int i = 0; i < 10; i++) {
            XLabel.add(String.valueOf(i));
        }
        for (int i = 0; i < 11; i++) {
            YLabel.add(String.valueOf(i * 20));
        }


        mSkinLineView.setDataColorList(colorList);
        mSkinLineView.setXYLabel(XLabel, YLabel); //设置设置X,Y轴的数据
        mSkinLineView.setShowGrid(false);//true是展示表格,false是显示带箭头的X,Y轴
//        mSkinLineView.setDottedLine(true); // 表格展示微虚线
        mSkinLineView.setXYColor(Color.BLUE); // X,Y轴线与数据的颜色
        mSkinLineView.setGridColor(Color.GREEN);// 表格的颜色
       /* mSkinLineView.setScale(32);//表格中的正方形的单位,默认是32
        mSkinLineView.setXTextSize(30);  // X轴字体的颜色
        mSkinLineView.setYTextSize(30); // Y轴字体的颜色
        mSkinLineView.setXToXTextSpace(20);
        mSkinLineView.setYToYTextSpace(40);
        */
        mSkinLineView.setXTextColor(Color.RED);
        mSkinLineView.setYTextColor(Color.RED);
        mSkinLineView.setDataColor(Color.BLUE);
        dataLists = new ArrayList<>();
        dataList1= new ArrayList<Integer>();
        dataList2 = new ArrayList<Integer>();
//       randSet();


       // mSkinLineView.setDataList(dataLists);
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
     //   handler.sendEmptyMessage(0);
        android.os.Message mmsg=new android.os.Message();
        mmsg.arg1=gaoya;
        mmsg.arg2=diya;
        handler.sendMessage(mmsg);
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.updateData:
                startActivity(new Intent(getActivity(), UpDataActivity.class));
                break;
            case R.id.text_Button1:

                break;
            case R.id.text_Button2:

                break;
            case R.id.text_Button3:

                break;
            case R.id.text_Button4:

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
             i= msg.arg1;
             i1 = msg.arg2;
            Log.i("abcccc",i+"");
            Log.i("abcccc",i1+"");

            getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    randSet();
                }
            });

        }
    };

    private void randSet() {
        dataList1.add(i);
        dataList2.add(i1);
        dataLists.add(dataList1);
        dataLists.add(dataList2);
        mSkinLineView.setDataList(dataLists);
    }
}
