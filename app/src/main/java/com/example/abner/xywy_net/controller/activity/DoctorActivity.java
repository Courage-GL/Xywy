package com.example.abner.xywy_net.controller.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.adapter.DoctorAdapter;
import com.example.abner.xywy_net.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/10.
 */

public class DoctorActivity extends BaseActivity implements View.OnClickListener{

    private List<String> datas;
    private DoctorAdapter adapter;
    private ListView mlistView;
    private Button back_btn;
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
    }

    @Override
    protected void loadData() {
        mlistView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
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
