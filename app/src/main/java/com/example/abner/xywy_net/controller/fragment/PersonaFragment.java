package com.example.abner.xywy_net.controller.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseFragment;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class PersonaFragment  extends BaseFragment {
    Button  loginbtn;
    ImageView  imageview;
    LinearLayout  beginlogin,afterlogin;
    RelativeLayout  jiahao,like,ziliao,messge,shezhi;
    @Override
    protected int layoutId() {
        return R.layout.activity_personal;
    }

    @Override
    protected void initView(View view) {
        loginbtn= (Button) view.findViewById(R.id.login_btn);
        jiahao= (RelativeLayout) view.findViewById(R.id.personal_jiahao);
        like= (RelativeLayout) view.findViewById(R.id.personal_like);
        ziliao= (RelativeLayout) view.findViewById(R.id.personal_detail);
        messge= (RelativeLayout) view.findViewById(R.id.personal_messgae);
        shezhi= (RelativeLayout) view.findViewById(R.id.personal_set);
        imageview= (ImageView) view.findViewById(R.id.personal_icon);
        beginlogin= (LinearLayout) view.findViewById(R.id.person_begin);
        afterlogin= (LinearLayout) view.findViewById(R.id.person_after);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }
}
