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
             locationService.start();// 定位SDK
         }
     });
    }



    /***
     * Stop location service
     */
    @Override
    protected void onStop() {
        // TODO Auto-generated method stub
        locationService.unregisterListener(mListener); //注销掉监听
        locationService.stop(); //停止定位服务
        super.onStop();
    }



    @Override
    protected void onStart() {
        // TODO Auto-generated method stub
        super.onStart();
        // -----------location config ------------
        locationService = ((App) getApplication()).locationService;
        //获取locationservice实例，建议应用中只初始化1个location实例，然后使用，可以参考其他示例的activity，都是通过此种方式获取locationservice实例的
        locationService.registerListener(mListener);
        //注册监听
        int type = getIntent().getIntExtra("from", 0);
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
                addrStr = location.getCity();
                Toast.makeText(Test.this, addrStr, Toast.LENGTH_SHORT).show();
            }
        }

        public void onConnectHotSpotMessage(String s, int i){
        }
    };









}
