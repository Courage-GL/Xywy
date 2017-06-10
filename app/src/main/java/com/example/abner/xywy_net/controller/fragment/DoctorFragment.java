package com.example.abner.xywy_net.controller.fragment;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.abner.xywy_net.App;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.adapter.DoctorAdapter;
import com.example.abner.xywy_net.base.BaseFragment;
import com.example.abner.xywy_net.controller.activity.DoctorActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by think on 2017/6/9.
 */

public class DoctorFragment extends BaseFragment implements View.OnClickListener{

    private LinearLayout mlinearLayout;
    @Override
    protected int layoutId() {
        return R.layout.activity_sc_main;
    }

    @Override
    protected void initView(View view) {
        mlinearLayout  = (LinearLayout) view.findViewById(R.id.check_dc);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
        mlinearLayout.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.check_dc:
                Intent intent_dc = new Intent(getActivity(), DoctorActivity.class);
                startActivity(intent_dc);
            break;
        }
    }
}
