package com.example.abner.xywy_net.controller.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseFragment;
import com.example.abner.xywy_net.bluetooth.ClientActivity;
import com.example.abner.xywy_net.controller.activity.AskDoctorActivity;
import com.example.abner.xywy_net.controller.activity.UpDataActivity;
import com.example.abner.xywy_net.controller.activity.XueYaZiXunActivity;
import com.example.abner.xywy_net.tongjitu.LineView;

import java.util.ArrayList;

/**
 * Created by Abner on 2017/6/9.
 */

public class XueYaGuanliFragment extends BaseFragment implements View.OnClickListener{
    private LineView mSkinLineView;
    private ArrayList<Integer> colorList = new ArrayList<>();//折线的颜色列表
    private ArrayList<String> XLabel = new ArrayList<>(); //X轴上的标签数据列表
    private ArrayList<String> YLabel = new ArrayList<>(); //Y轴上的标签数据列表
    private ArrayList<ArrayList<Integer>> dataLists;//折线上的数据列表
    private ImageView updataImage;
    private Button shuaXinBtn;
    private RadioButton textBtn1,textBtn2,textBtn3,textBtn4,askDoctorBtn,messageBtn,alarmBtn,bluetoothBtn;
//
    @Override
    protected int layoutId() {
        return R.layout.fragmnet_xueyaguanli;
    }
    @Override
    protected void initView(View view) {
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
        colorList.add(getResources().getColor(R.color.using_before));
        colorList.add(getResources().getColor(R.color.using_after));
        for (int i = 0; i < 10; i++) {
            XLabel.add(String.valueOf(i));
        }
        for (int i = 0; i < 11; i++) {
            YLabel.add(String.valueOf(i * 20));
        }
        mSkinLineView = (LineView) view.findViewById(R.id.LineView);
        mSkinLineView.setDataColorList(colorList);
        mSkinLineView.setXYLabel(XLabel, YLabel); //设置设置X,Y轴的数据
        mSkinLineView.setShowGrid(true);//true是展示表格,false是显示带箭头的X,Y轴
//      mSkinLineView.setDottedLine(true); // 表格展示微虚线
        mSkinLineView.setXYColor(Color.LTGRAY); // X,Y轴线与数据的颜色
        mSkinLineView.setGridColor(Color.LTGRAY);// 表格的颜色
        mSkinLineView.setXTextColor(Color.GREEN);
        mSkinLineView.setYTextColor(Color.BLUE);
       /* mSkinLineView.setScale(32);//表格中的正方形的单位,默认是32
        mSkinLineView.setXTextSize(30);  // X轴字体的颜色
        mSkinLineView.setYTextSize(30); // Y轴字体的颜色
        mSkinLineView.setXToXTextSpace(20);
        mSkinLineView.setYToYTextSpace(40);
        mSkinLineView.setDataColor(Color.BLUE);*/
    }

    @Override
    protected void loadData() {

    }
    @Override
    protected void initListener() {
        String data = getActivity().getIntent().getStringExtra("data");
        String time = getActivity().getIntent().getStringExtra("time");
        String gaoya = getActivity().getIntent().getStringExtra("gaoya");
        String diya = getActivity().getIntent().getStringExtra("diya");
        huaTu();
    }

    private void huaTu() {

        randSet();

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
                break;
            case R.id.bluetooth_Btn:
                startActivity(new Intent(getActivity(),ClientActivity.class));
                break;
            default:
                break;
        }
    }
    private void randSet() {
        dataLists = new ArrayList<>();
        ArrayList<Integer> dataList1 = new ArrayList<Integer>();
        int random1 = (int) (Math.random() * 99 + 1);
        for (int i = 0; i < XLabel.size(); i++) {
            dataList1.add((int) (Math.random() * random1));
        }

        ArrayList<Integer> dataList2 = new ArrayList<Integer>();
        int random2 = (int) (Math.random() * 99 + 1);
        for (int i = 0; i < XLabel.size(); i++) {
            dataList2.add((int) (Math.random() * random2));
        }
        dataLists.add(dataList1);
        dataLists.add(dataList2);
        mSkinLineView.setDataList(dataLists);
    }

}
