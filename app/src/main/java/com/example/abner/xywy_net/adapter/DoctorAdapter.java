package com.example.abner.xywy_net.adapter;

import android.content.Context;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.CommonAdapter;
import com.example.abner.xywy_net.base.ViewHolder;

import java.util.List;

/**
 * Created by think on 2017/6/10.
 */

public class DoctorAdapter extends CommonAdapter {

    private List<String> datas;
    private Context context;
    public DoctorAdapter(Context context, List datas) {
        super(context, datas, R.layout.listview_item_doctor);
        this.datas = datas;
        this.context = context;
    }

    @Override
    public void display(ViewHolder holder, Object o) {

    }
}
