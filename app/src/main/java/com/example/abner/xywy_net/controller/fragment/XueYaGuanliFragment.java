package com.example.abner.xywy_net.controller.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseFragment;

/**
 * Created by Abner on 2017/6/9.
 */

public class XueYaGuanliFragment extends BaseFragment implements View.OnClickListener{

    private ImageView updataImage;
    private RadioButton textBtn1,textBtn2,textBtn3,textBtn4,askDoctorBtn,messageBtn,alarmBtn;


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
        updataImage.setOnClickListener(this);
        textBtn1.setOnClickListener(this);
        textBtn2.setOnClickListener(this);
        textBtn3.setOnClickListener(this);
        textBtn4.setOnClickListener(this);
        askDoctorBtn.setOnClickListener(this);
        messageBtn.setOnClickListener(this);
        alarmBtn.setOnClickListener(this);
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
            case R.id.updateData:
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
                break;
            case R.id.message_Btn:
                break;
            case R.id.alarm_Btn:
                break;
            default:
                break;
        }
    }
}
