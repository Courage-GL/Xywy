package com.example.abner.xywy_net.controller.fragment;


import android.content.SharedPreferences;
import android.util.Log;
import android.view.View;
import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseFragment;
import com.example.abner.xywy_net.controller.activity.KeChengBiaoView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by think on 2017/6/13.
 */

public class Zhuanjiafragment extends BaseFragment {

    private KeChengBiaoView keChengBiaoView;
    @Override
    protected int layoutId() {
        return R.layout.list;
    }

    @Override
    protected void initView(View view) {
        keChengBiaoView = (KeChengBiaoView) view.findViewById(R.id.kechengbiao);
    }

    @Override
    protected void loadData() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("kcb",MODE_PRIVATE);
        String substring = sharedPreferences.getString("substring", "");
        String substringTime = sharedPreferences.getString("substringTime", "");
        Log.i("aaa",substring);
        Log.i("bbb",substringTime);
        keChengBiaoView.setSunDay(substring,substringTime);
    }

    @Override
    protected void initListener() {

    }
}
