package com.example.abner.xywy_net.controller.fragment.zxm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

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

public class PersonaFragment  extends BaseFragment {
    Button  loginbtn;
    ImageView  imageview;
    LinearLayout  beginlogin,afterlogin;
    RelativeLayout  jiahao,like,ziliao,messge,shezhi;
    SharedPreferences  share;
    TextView  idText;
    boolean islogin ;
    @Override
    protected int layoutId() {
        return R.layout.fragment_personal;
    }

    @Override
    protected void initView(View view) {
        idText= (TextView) view.findViewById(R.id.idText);
        loginbtn= (Button) view.findViewById(R.id.login_btn);
        jiahao= (RelativeLayout) view.findViewById(R.id.personal_jiahao);
        like= (RelativeLayout) view.findViewById(R.id.personal_like);
        ziliao= (RelativeLayout) view.findViewById(R.id.personal_detail);
        messge= (RelativeLayout) view.findViewById(R.id.personal_messgae);
        shezhi= (RelativeLayout) view.findViewById(R.id.personal_set);
        imageview= (ImageView) view.findViewById(R.id.personal_icon111);
        beginlogin= (LinearLayout) view.findViewById(R.id.person_begin);
        afterlogin= (LinearLayout) view.findViewById(R.id.person_after);
        beginlogin.setVisibility(View.VISIBLE);
        afterlogin.setVisibility(View.GONE);
    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onResume() {
        super.onResume();
     share=getActivity().getSharedPreferences("logindata", Context.MODE_PRIVATE);
     islogin = share.getBoolean("islogin", false);
        String userid = share.getString("userid", "");
        idText.setText("id"+userid);
        if(islogin){
            beginlogin.setVisibility(View.GONE);
            afterlogin.setVisibility(View.VISIBLE);

        }else{
            beginlogin.setVisibility(View.VISIBLE);
            afterlogin.setVisibility(View.GONE);
        }
        onClick();
    }

    @Override
    protected void initListener() {

    }

    public void onClick() {

               jiahao.setOnClickListener(new OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(islogin){
                           Intent intent=new Intent(getActivity(), JiahaoActivity.class);
                           startActivity(intent);
                       }else{
                           Intent  intent=new Intent(getActivity(),LoginActivity.class);
                           startActivity(intent);
                       }
                   }
               });

               like.setOnClickListener(new OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       if(islogin){
                           Intent intent=new Intent(getActivity(), ShoucangActivity.class);
                           startActivity(intent);
                       }else{
                           Intent  intent=new Intent(getActivity(),LoginActivity.class);
                           startActivity(intent);
                       }
                   }
               });
        ziliao.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(islogin){
                    Intent intent=new Intent(getActivity(),ZiliaoActivity.class);
                    startActivity(intent);
                }else{
                    Intent  intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

       messge.setOnClickListener(new OnClickListener() {
           @Override
           public void onClick(View v) {
               if(islogin){
                   Intent intent=new Intent(getActivity(), MessageActivity.class);
                   startActivity(intent);
               }else{
                   Intent  intent=new Intent(getActivity(),LoginActivity.class);
                   startActivity(intent);
               }
           }
       });

        shezhi.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(islogin){
                    Intent intent=new Intent(getActivity(), SetActivity.class);
                    startActivity(intent);
                }else{
                    Intent  intent=new Intent(getActivity(),LoginActivity.class);
                    startActivity(intent);
                }
            }
        });


                   beginlogin.setOnClickListener(new OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           Intent  intent=new Intent(getActivity(),LoginActivity.class);
                           startActivity(intent);
                       }
                   });


        }
    }

