package com.example.abner.xywy_net.controller.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.example.abner.xywy_net.App;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.adapter.DoctorAdapter;
import com.example.abner.xywy_net.base.BaseFragment;
import com.example.abner.xywy_net.controller.activity.DoctorActivity;
import com.example.abner.xywy_net.controller.activity.zxm.CityActivity;
import com.example.abner.xywy_net.controller.activity.zxm.Test;
import com.example.abner.xywy_net.controller.activity.zxm.baidumap.LocationActivity;
import com.example.abner.xywy_net.controller.activity.zxm.baidumap.LocationService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/9.
 */

public class DoctorFragment extends BaseFragment implements View.OnClickListener{
    //百度地图定位
    private LocationService locationService;
    private ImageView  mine_location;
    private TextView  main_loc_meaage;
    private LinearLayout mlinearLayout,choose_city;
    @Override
    protected int layoutId() {
        return R.layout.activity_sc_main;
    }

    @Override
    protected void initView(View view) {
        mlinearLayout  = (LinearLayout) view.findViewById(R.id.check_dc);
        mine_location= (ImageView) view.findViewById(R.id.mine_location);
        main_loc_meaage= (TextView) view.findViewById(R.id.main_loc_meaage);
        choose_city= (LinearLayout) view.findViewById(R.id.choose_city);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        mlinearLayout.setOnClickListener(this);
        mine_location.setOnClickListener(this);
        choose_city.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_dc:
                Intent intent_dc = new Intent(getActivity(), DoctorActivity.class);
                startActivity(intent_dc);
            break;
            case R.id.mine_location:
//
                showCustomizeDialog();
                break;
            case R.id.choose_city:
                 Intent  intent=new Intent(getActivity(), CityActivity.class);
                startActivityForResult(intent,200);
                break;
        }
    }
/***
 * 以下是百度地图定位以及城市选择省份,如果有冲突可以说明改正
 * 张晓萌
 */

    /**
     * 显示请求字符串
     *
     * @param str
     */
    public void logMsg(String str) {
        final String s = str;
        try {
            if (main_loc_meaage != null){
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        main_loc_meaage.post(new Runnable() {
                            @Override
                            public void run() {
                                main_loc_meaage.setText(s);
                            }
                        });

                    }
                }).start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /***
     * Stop location service
     */
    @Override
    public void onStop() {
        // TODO Auto-generated method stub
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }

    @Override
    public void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // -----------location config ------------
        locationService = ((App) getActivity().getApplication()).locationService;
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getActivity().getIntent().getIntExtra("from", 0);
        if (type == 0) {
            locationService.setLocationOption(locationService.getDefaultLocationClientOption());
        } else if (type == 1) {
            locationService.setLocationOption(locationService.getOption());
        }
    }


    /*****
     *
     * 定位结果回调，重写onReceiveLocation方法，可以直接拷贝如下代码到自己工程中修改
     *
     */
    private BDLocationListener mListener = new BDLocationListener() {

        @Override
        public void onReceiveLocation(BDLocation location) {
            // TODO Auto-generated method stub
            if (null != location && location.getLocType() != BDLocation.TypeServerError) {
                String city = location.getCity();
                logMsg(city);
            }
        }

        public void onConnectHotSpotMessage(String s, int i){
        }
    };



    //<----------是否选择定位,-------------------------------->

    private void showCustomizeDialog() {
    /* @setView 装入自定义View ==> R.layout.dialog_customize
     * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
     * dialog_customize.xml可自定义更复杂的View
     */
        final View dialogView = LayoutInflater.from(getActivity())
                .inflate(R.layout.isloc,null);
        final AlertDialog   customizeDialog =
                new AlertDialog.Builder(getActivity()).setView(dialogView).create();
       LinearLayout  ok= (LinearLayout) dialogView.findViewById(R.id.okloc);
        LinearLayout  cancelloc= (LinearLayout) dialogView.findViewById(R.id.cancelloc);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locationService.start();// 定位SDK
                customizeDialog.dismiss();
                Toast.makeText(getActivity(), "定位成功", Toast.LENGTH_SHORT).show();
            }
        });
        cancelloc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customizeDialog.dismiss();
                Toast.makeText(getActivity(), "取消定位", Toast.LENGTH_SHORT).show();
            }
        });

        customizeDialog.show();
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==200&&resultCode==100){
            String s = data.getStringExtra("s");
            main_loc_meaage.setText(s);
        }
    }
}
