package com.example.abner.xywy_net.controller.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.bean.Message;
import com.example.abner.xywy_net.controller.MainActivity;
import com.example.abner.xywy_net.controller.fragment.XueYaGuanliFragment;

import org.greenrobot.eventbus.EventBus;

import java.util.Calendar;

/**
 * Created by Abner on 2017/6/10.
 */

public class UpDataActivity extends BaseActivity implements View.OnClickListener {
    private ImageView updata_back;
    private TextView updata_Data,updata_Time;
    private EditText updata_SheBei,updata_GaoYa,updata_DiYa;
    private Button updata_updata;
     private int year,month,date,hour,minute;
    @Override
    protected int layoutId() {
        return R.layout.activity_updata;
    }

    @Override
    protected void initView() {

        updata_updata= (Button) findViewById(R.id.update_update);
        updata_back= (ImageView) findViewById(R.id.update_back);
        updata_Data= (TextView) findViewById(R.id.update_Data);
        updata_Time= (TextView) findViewById(R.id.update_Time);
        updata_SheBei= (EditText) findViewById(R.id.update_SheBei);
        updata_GaoYa= (EditText) findViewById(R.id.update_GaoYa);
        updata_DiYa= (EditText) findViewById(R.id.update_DiYa);
        updata_back.setOnClickListener(this);
        updata_Data.setOnClickListener(this);
        updata_Time.setOnClickListener(this);
        updata_updata.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        //获取当前时间
        getSystemData();
        getSystemTime();
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
            case R.id.update_Data:
                showDataPicker();
                break;
            case R.id.update_back:
                this.finish();
                break;
            case R.id.update_Time:
                showTimePaicker();
                break;
            case R.id.update_update:
                if(isSheBei()){
                    if(isGaoYa()){
                        if(isDiYa()){
                            updata();
                        }else {

                            Toast.makeText(this, "请填写低压", Toast.LENGTH_SHORT).show();
                        }

                    }else {

                        Toast.makeText(this, "请填写高压", Toast.LENGTH_SHORT).show();
                    }

                }else {

                    Toast.makeText(this, "没有设备", Toast.LENGTH_SHORT).show();
                }

                break;
            default:
                break;
        }
    }

    private void updata() {
        Message msg=new Message();
        msg.setData(updata_Time.getText().toString().trim());
        msg.setDiya(updata_DiYa.getText().toString().trim());
        msg.setGaoya(updata_GaoYa.getText().toString().trim());
        EventBus.getDefault().post(msg);

        finish();

//        Intent intent=new Intent(this, MainActivity.class);
//        intent.putExtra("id","2");
//        startActivity(intent);

    }


    public void getSystemData() {
        Calendar c = Calendar.getInstance();
         year = c.get(Calendar.YEAR);
         month = c.get(Calendar.MONTH)+1;
         date = c.get(Calendar.DATE);
        updata_Data.setText(year+"-"+month+"-"+date);

    }
    public void getSystemTime() {
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);
        updata_Time.setText(hour+":"+minute);
    }
    private void showTimePaicker() {
        new TimePickerDialog(UpDataActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                hour=hourOfDay;
                UpDataActivity.this.minute=minute;
                updata_Time.setText(hour+":"+minute);
            }
            //0,0指的是时间，true表示是否为24小时，true为24小时制
        },0,0,true).show();
    }

    private void showDataPicker() {
        new DatePickerDialog(UpDataActivity.this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                UpDataActivity.this.year=year;
                UpDataActivity.this.month=monthOfYear+1;
                UpDataActivity.this.date=dayOfMonth;
                updata_Data.setText(year+"-"+month+"-"+date);
            }
        },year,month,date).show();
    }

    public boolean isSheBei() {
        String data = updata_SheBei.getText().toString().trim();
        if(data.equals("")){
            return false;
        }else {
            return true;
        }

    }

    public boolean isGaoYa() {

        String data = updata_GaoYa.getText().toString().trim();
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show();
        if(data.equals("")){

            return false;
        }else {

            return true;
        }
    }
    public boolean isDiYa() {

        String data = updata_DiYa.getText().toString().trim();
        Toast.makeText(this,data, Toast.LENGTH_SHORT).show();
        if(data.equals("")){

            return false;
        }else {

            return true;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}
