package com.example.abner.xywy_net.controller.activity.zxm;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;
import com.example.abner.xywy_net.controller.fragment.DoctorFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 张萌 on 2017/6/10.
 */

public class CityActivity  extends BaseActivity {
    ListView  listView;
    List<String>  mlist;
    ListAdapter  adapter;
    @Override
    protected int layoutId() {
        return R.layout.activity_city;
    }

    @Override
    protected void initView() {
     listView= (ListView) findViewById(R.id.citylistview);
    }

    @Override
    protected void initData() {
    mlist=new ArrayList<>();
        mlist.add("不限");
        mlist.add("北京市");
        mlist.add("山东省");
        mlist.add("河北省");
        mlist.add("河南省");
        mlist.add("天津市");
        mlist.add("辽宁省");
        mlist.add("黑龙江省");
        mlist.add("吉林省");
        mlist.add("湖北省");
        mlist.add("湖南省");
        mlist.add("上海市");
        mlist.add("四川省");
        mlist.add("重庆市");
        mlist.add("陕西省");
        mlist.add("甘肃省");
        mlist.add("云南省");
        mlist.add("新疆维吾尔族自治区");
        mlist.add("内蒙古自治区");
        mlist.add("海南省");
        mlist.add("贵州省");
        mlist.add("青海省");
        mlist.add("广东省");
        mlist.add("宁夏回族自治区");
        mlist.add("西藏自治区");
        mlist.add("广西壮族自治区");
        mlist.add("江苏省");
        mlist.add("浙江省");
        mlist.add("安徽省");
        mlist.add("江西省");
        mlist.add("福建省");
        adapter=new ListAdapter(mlist,CityActivity.this);
        listView.setAdapter(adapter);
    }

    @Override
    protected void loadData() {

    }

    @Override
    protected void initListener() {
      listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
          @Override
          public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
              String s = mlist.get(position);
              Intent  intent=new Intent();
              intent.putExtra("s",s);
              intent.setClass(CityActivity.this, DoctorFragment.class);
              setResult(100,intent);
              finish();
//              SharedPreferences  sharedPreferences=getSharedPreferences("data",MODE_PRIVATE);
//              SharedPreferences.Editor  editor=sharedPreferences.edit();
//              editor.putString("s",s);
//              editor.commit();
          }
      });
    }

    class ListAdapter  extends BaseAdapter{
        List<String>  list;
        Context context;

        public ListAdapter(List<String> list, Context context) {
            this.list = list;
            this.context = context;
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            Holder  holder=null;
            if(convertView==null){
                holder=new Holder();
                convertView= LayoutInflater.from(context).inflate(R.layout.activity_city_item,null);
                holder.textView= (TextView) convertView.findViewById(R.id.cityitem);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            String  s=list.get(position);
            holder.textView.setText(s);
            return convertView;
        }

        class Holder {
            TextView  textView;
        }
    }


}
