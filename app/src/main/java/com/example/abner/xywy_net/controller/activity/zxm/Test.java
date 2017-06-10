package com.example.abner.xywy_net.controller.activity.zxm;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.Poi;
import com.example.abner.xywy_net.App;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.activity.zxm.baidumap.LocationService;

import static com.example.abner.xywy_net.R.id.btn;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class Test  extends BaseActivity {
    String addrStr;
    TextView  textViewloc;
    Button  button;
    private LocationService locationService;
    @Override
    protected int layoutId() {
        return R.layout.test;
    }

    @Override
    protected void initView() {
     textViewloc= (TextView) findViewById(R.id.test);
        button= (Button) findViewById(btn);
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
     button.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {

         }
     });
    }









}
