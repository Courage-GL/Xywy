package com.example.abner.xywy_net;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.ImageView;

import com.androidkun.adapter.BaseAdapter;
import com.androidkun.adapter.ViewHolder;
import com.bumptech.glide.Glide;
import com.example.abner.xywy_net.controller.activity.YuyueZhuanjiaActivity;
import com.example.abner.xywy_net.entity.DcBean;

import java.util.List;

/**
 * Created by think on 2017/6/16.
 */

public class CheckedDcAdapter extends BaseAdapter<DcBean.DataBean> {

    private Context context;
    private List<DcBean.DataBean> datas;

    public CheckedDcAdapter(Context context, List<DcBean.DataBean> datas) {
        super(context, R.layout.listview_item_doctor, datas);
        this.context = context;
        this.datas = datas;
    }

    @Override
    public void convert(ViewHolder holder, DcBean.DataBean dataBean) {

        ImageView imageViewadd = holder.getView(R.id.free_addnumber);
        imageViewadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, YuyueZhuanjiaActivity.class);
                context.startActivity(intent);
            }
        });
        String app_image = dataBean.getApp_image();
        ImageView imageView = holder.getView(R.id.image_dc);
        Glide.with(context).load(app_image).into(imageView);
        String name = dataBean.getName();
        holder.setText(R.id.name_dc,name);
        String hospital = dataBean.getHospital();
        holder.setText(R.id.address_dc,hospital);
        String title = dataBean.getTitle();
        holder.setText(R.id.work_dc,title);
        String depart = dataBean.getDepart();
        holder.setText(R.id.jineng_dc,depart);
        String teach = dataBean.getTeach();
        holder.setText(R.id.zhiwei_dc,teach);
        String goodat = dataBean.getGoodat();
        holder.setText(R.id.text_dc,goodat);

        SharedPreferences sp = context.getSharedPreferences("dc_data",Context.MODE_PRIVATE);
        SharedPreferences.Editor edit = sp.edit();
        edit.putString("app_image",app_image);
        edit.putString("name",name);
        edit.putString("depart",depart);
        edit.putString("title",title);
        edit.putString("teach",teach);
        edit.putString("hospital",hospital);
        edit.putString("goodat",goodat);
        edit.commit();
    }
}
