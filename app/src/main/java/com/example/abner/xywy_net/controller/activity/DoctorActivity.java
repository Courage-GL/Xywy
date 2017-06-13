package com.example.abner.xywy_net.controller.activity;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.adapter.DoctorAdapter;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.activity.zxm.baidumap.Utils;
import com.example.abner.xywy_net.entity.DcBean;
import com.example.abner.xywy_net.http.HttpCallBack;
import com.example.abner.xywy_net.http.RetrofitImpl;
import com.example.abner.xywy_net.params.Params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/6/10.
 */

public class DoctorActivity extends BaseActivity implements View.OnClickListener{

    private List<DcBean.DataBean> datas;
    private DoctorAdapter adapter;
    private ListView mlistView;
    private Button back_btn;
    private int pageNumber = 1;
    private int pageCount = 10;

    @Override
    protected int layoutId() {
        return R.layout.doctor_list;
    }


    @Override
    protected void initView() {
        mlistView = (ListView) findViewById(R.id.list_item);
        back_btn = (Button) findViewById(R.id.btn_back_erweima);
    }

    @Override
    protected void initData() {
        datas = new ArrayList<>();
        adapter = new DoctorAdapter(this,datas);
        mlistView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {
        Map<String,String> map = new HashMap<>();
        map.put("tag","BloodAndroid");
        map.put("sign","2c19b2821ebc5306c3ac37bac5b4288b");
        map.put("act","zhuanjia");
        map.put("fun","SearchDoctor");
        map.put("pageCount",pageCount+"");
        map.put("pageNum",pageNumber+"");
        map.put("illid","%E9%AB%98%E8%A1%80%E5%8E%8B");
        map.put("IsPlus","0");//免费加号
        map.put("title","");//医生职称
        map.put("province","");//所在省
        map.put("level","");//医院等级
        map.put("keyword","");//关键字

        RetrofitImpl.getInstance().get(DcBean.class, Params.URL, map, new HttpCallBack() {
            @Override
            public void onSuccessful(Object success) {
                DcBean dcBean = (DcBean) success;
                List<DcBean.DataBean> data = dcBean.getData();
                datas.addAll(data);
                adapter.notifyDataSetChanged();
                loadmore();
            }


            private void loadmore(){
                if(pageCount == 10){
                    getImageLoadding();
                    pageNumber ++ ;
                    loadData();
                    getImageLoadding();
                }
            }

            private void getImageLoadding(){

                View inflate = LayoutInflater.from(DoctorActivity.this).inflate(R.layout.check_dc_image, null);
                //TextView text = (TextView) inflate.findViewById(R.id.load_more);
                //text.setText("读取中");
                mlistView.addFooterView(inflate);
                adapter.notifyDataSetChanged();

            }
            @Override
            public void onError(String errorMessage) {

            }
        });
    }

    @Override
    protected void initListener() {
        back_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_back_erweima:
                onBackPressed();
                break;
        }
    }


}

