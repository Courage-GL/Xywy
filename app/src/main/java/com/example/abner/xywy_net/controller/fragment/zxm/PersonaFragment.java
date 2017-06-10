package com.example.abner.xywy_net.controller.fragment.zxm;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseFragment;
import com.example.abner.xywy_net.controller.activity.zxm.JiahaoActivity;
import com.example.abner.xywy_net.controller.activity.zxm.LoginActivity;
import com.example.abner.xywy_net.controller.activity.zxm.MessageActivity;
import com.example.abner.xywy_net.controller.activity.zxm.SetActivity;
import com.example.abner.xywy_net.controller.activity.zxm.ShoucangActivity;
import com.example.abner.xywy_net.controller.activity.zxm.ZiliaoActivity;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class PersonaFragment  extends BaseFragment implements OnClickListener{
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
        loginbtn.setOnClickListener(this);
        jiahao= (RelativeLayout) view.findViewById(R.id.personal_jiahao);
        jiahao.setOnClickListener(this);
        like= (RelativeLayout) view.findViewById(R.id.personal_like);
        like.setOnClickListener(this);
        ziliao= (RelativeLayout) view.findViewById(R.id.personal_detail);
        ziliao.setOnClickListener(this);
        messge= (RelativeLayout) view.findViewById(R.id.personal_messgae);
        messge.setOnClickListener(this);
        shezhi= (RelativeLayout) view.findViewById(R.id.personal_set);
        shezhi.setOnClickListener(this);
        imageview= (ImageView) view.findViewById(R.id.personal_icon);
        imageview.setOnClickListener(this);
        beginlogin= (LinearLayout) view.findViewById(R.id.person_begin);
        beginlogin.setOnClickListener(this);
        afterlogin= (LinearLayout) view.findViewById(R.id.person_after);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.personal_jiahao:
                Intent intent=new Intent(getActivity(), JiahaoActivity.class);
                startActivity(intent);
                break;
            case R.id.personal_like:
                Intent intent1=new Intent(getActivity(), ShoucangActivity.class);
                startActivity(intent1);
                break;
            case R.id.personal_detail:
                Intent  intent2=new Intent(getActivity(), ZiliaoActivity.class);
                startActivity(intent2);
                break;
            case R.id.personal_messgae:
                Intent  intent3=new Intent(getActivity(), MessageActivity.class);
                startActivity(intent3);
                break;
            case R.id.personal_set:
                Intent  intent4=new Intent(getActivity(), SetActivity.class);
                startActivity(intent4);
                break;
            case R.id.personal_icon:

                break;
            case R.id.person_begin:
                Intent intent5=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent5);
                break;
        }
    }
}
