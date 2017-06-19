package com.example.abner.xywy_net.adapter;

import android.content.Context;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.CommonAdapter;
import com.example.abner.xywy_net.base.ViewHolder;
import com.example.abner.xywy_net.entity.ZJBean;

import java.util.List;

/**
 * Created by think on 2017/6/14.
 */

public class ZJFragmentAdapter extends CommonAdapter<ZJBean.DataBean> {

    private List<ZJBean.DataBean> datas;
    private Context context;
    public ZJFragmentAdapter(Context context, List<ZJBean.DataBean> datas) {
        super(context, datas, R.layout.dc_item);
        this.datas = datas;
        this.context = context;
    }

    @Override
    public void display(ViewHolder holder, ZJBean.DataBean dataBean) {
        String title = dataBean.getTitle();
        holder.setText(R.id.text_dc1,title);
        String reply = dataBean.getReply();
        holder.setText(R.id.text_dc1,reply);
    }
}
