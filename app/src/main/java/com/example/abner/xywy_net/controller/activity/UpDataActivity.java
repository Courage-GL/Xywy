package com.example.abner.xywy_net.controller.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

import java.util.Calendar;

/**
 * Created by Abner on 2017/6/10.
 */

public class UpDataActivity extends BaseActivity implements View.OnClickListener {
    private ImageView updata_back;
    private TextView updata_Data,updata_Time;
    private EditText updata_SheBei,updata_GaoYa,updata_DiYa;
     private int year,month,date,hour,minute;
    private boolean isFirst=true;
    @Override
    protected int layoutId() {
        return R.layout.activity_updata;
    }

    @Override
    protected void initView() {
        updata_back= (ImageView) findViewById(R.id.update_back);
        updata_Data= (TextView) findViewById(R.id.update_Data);
        updata_Time= (TextView) findViewById(R.id.update_Time);
        updata_SheBei= (EditText) findViewById(R.id.update_SheBei);
        updata_GaoYa= (EditText) findViewById(R.id.update_GaoYa);
        updata_DiYa= (EditText) findViewById(R.id.update_DiYa);
        updata_back.setOnClickListener(this);
        updata_Data.setOnClickListener(this);
        updata_Time.setOnClickListener(this);
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
            default:
                break;
        }
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
}
