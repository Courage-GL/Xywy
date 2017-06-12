package com.example.abner.xywy_net.controller.activity.zxm.zixun;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.abner.xywy_net.App;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.bean.DetailBean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by 张萌 on 2017/6/12.
 */

public class DetailCommon  extends BaseActivity {
   TextView title;
    TextView body;
    TextView date;
    CheckBox  checkBox;
    @Override
    protected int layoutId() {
            return R.layout.item_zixun;
    }

    @Override
    protected void initView() {
        title= (TextView) findViewById(R.id.common_title222);
        body= (TextView) findViewById(R.id.common_body222);
        date= (TextView) findViewById(R.id.common_date222);
        checkBox= (CheckBox) findViewById(R.id.zixun_detail_shoucang);
    }

    @Override
    protected void initData() {
        Intent  intent=getIntent();
        String userid = intent.getStringExtra("userid");
        getNetDetail(userid);
        String body111 = intent.getStringExtra("body");
        String title111 = intent.getStringExtra("title");
        String date111 = intent.getStringExtra("date");
        title.setText(title111);
        date.setText(date111);

    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {


    }

    private void getNetDetail(String  id){
          String  baseurl="http://api.wws.xywy.com/index.php?act=zixun&fun=getHealthPlazeDetail&version=version2&tag=zj&sign=2e0d0887581be1c35794ee4c13b00cae&";
        StringBuffer  sb=new StringBuffer();
        sb.append(baseurl).append("id=").append(id).append("&dir=zhuanti_nk");
        OkHttpClient  okHttpClient=new OkHttpClient();
        Request  request=new Request.Builder().url(sb.toString()).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String  result=response.body().string();
                Gson  gson=new Gson();
                DetailBean detailBean = gson.fromJson(result, DetailBean.class);
                final String body111 = detailBean.getData().getBody();
                App.activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        body.setText(body111);
                    }
                });
            }
        });
    }


}
