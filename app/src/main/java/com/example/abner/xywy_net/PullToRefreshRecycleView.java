package com.example.abner.xywy_net;


import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.widget.Button;
import com.androidkun.PullToRefreshRecyclerView;
import com.androidkun.callback.PullToRefreshListener;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.entity.DcBean;
import com.example.abner.xywy_net.http.HttpCallBack;
import com.example.abner.xywy_net.http.RetrofitImpl;
import com.example.abner.xywy_net.params.Params;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by think on 2017/6/16.
 */

public class PullToRefreshRecycleView extends BaseActivity implements View.OnClickListener{

    private List<DcBean.DataBean> datas;
    private CheckedDcAdapter adapter;
    private PullToRefreshRecyclerView mPullToRefreshView;
    private Button back_btn;
    private int pageNumber = 1;
    private int pageCount = 10;
    private int IsPlus = 0; //免费加号

    @Override
    protected int layoutId() {
        return R.layout.doctor_list;
    }

    @Override
    protected void initView() {

        mPullToRefreshView = (PullToRefreshRecyclerView) findViewById(R.id.RecyclerView);
        back_btn = (Button) findViewById(R.id.btn_back_erweima);
    }

    @Override
    protected void initData() {
        datas = new ArrayList<>();
        LinearLayoutManager layoutManager = new LinearLayoutManager(PullToRefreshRecycleView.this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mPullToRefreshView.setLayoutManager(layoutManager);
        adapter = new CheckedDcAdapter(this,datas);
        mPullToRefreshView.setAdapter(adapter);
        //是否开启下拉刷新功能
        mPullToRefreshView.setPullRefreshEnabled(false);
        //是否开启上拉加载功能
        mPullToRefreshView.setLoadingMoreEnabled(true);
        //设置是否显示上次刷新的时间
        mPullToRefreshView.displayLastRefreshTime(true);
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
        SharedPreferences sp = getSharedPreferences("dc_data", Context.MODE_PRIVATE);
        String province = sp.getString("province", "");
        map.put("IsPlus",IsPlus+"");//免费加号
        SharedPreferences sps = getSharedPreferences("findkey",MODE_PRIVATE);
        String content = sp.getString("content", "");
        map.put("title","");//医生职称
        map.put("province",province);//所在省
        map.put("level","");//医院等级
        map.put("keyword",content);//关键字

        RetrofitImpl.getInstance().get(DcBean.class, Params.URL, map, new HttpCallBack() {
            @Override
            public void onSuccessful(Object success) {
                DcBean dcBean = (DcBean) success;
                List<DcBean.DataBean> data = dcBean.getData();
                datas.addAll(data);
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

        mPullToRefreshView.setPullToRefreshListener(new PullToRefreshListener() {
            @Override
            public void onRefresh() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        pageNumber ++ ;
                        mPullToRefreshView.setRefreshComplete();
                    }
                },2000);
            }

            @Override
            public void onLoadMore() {
                mPullToRefreshView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        loadData();
                        pageNumber ++ ;
                        mPullToRefreshView.setLoadMoreComplete();
                    }
                },2000);
            }
        });
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
