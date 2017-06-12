package com.example.abner.xywy_net.controller.activity.zxm;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import static com.umeng.socialize.utils.ContextUtil.getContext;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class ZiliaoActivity  extends BaseActivity implements View.OnClickListener{
    RelativeLayout  name,sex,height,weight,birthday;
    TextView  sexText,heightText,nameText,birthText;
    HeightAdapter adapter;
    @Override
    protected int layoutId() {
        return R.layout.activity_ziliao;
    }

    @Override
    protected void initView() {
     name= (RelativeLayout) findViewById(R.id.name);
        name.setOnClickListener(this);
        sex= (RelativeLayout) findViewById(R.id.sex);
        sex.setOnClickListener(this);
        sexText= (TextView) findViewById(R.id.sexText);
        height= (RelativeLayout) findViewById(R.id.height);
        heightText= (TextView) findViewById(R.id.heightText);
        height.setOnClickListener(this);
        weight= (RelativeLayout) findViewById(R.id.weight);
        weight.setOnClickListener(this);
        birthday= (RelativeLayout) findViewById(R.id.birthday);
        birthday.setOnClickListener(this);
        birthText= (TextView) findViewById(R.id.birthText);
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences  share=getSharedPreferences("logindata",MODE_PRIVATE);
        String birthday = share.getString("birthday", "");
        Log.i("birth",birthday);
        int height = share.getInt("height", 0);
        String phonenum = share.getString("phonenum", "");
        String sex = share.getString("sex", "");
        String userid = share.getString("userid", "");
        boolean islogin = share.getBoolean("islogin", false);
        if(islogin){
            birthText.setText(birthday+"");
            heightText.setText(height+"");
            sexText.setText(sex);
        }

    }

    @Override
    protected void initData() {
        SharedPreferences  share=getSharedPreferences("logindata",MODE_PRIVATE);
        boolean islogin = share.getBoolean("islogin", false);
        if(!islogin){
            Intent  intent=new Intent(ZiliaoActivity.this,LoginActivity.class);
            startActivity(intent);
        }
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
            case R.id.name:

                break;
            case R.id.sex:
               showListDialog();
                break;
            case R.id.weight:

                break;
            case R.id.height:
                showCustomizeDialog();
                break;
            case R.id.birthday:

                break;
        }
    }

    //<-------选择性别------>

    private void showListDialog() {
        final String[] items = { "男","女"};
        AlertDialog.Builder listDialog =
                new AlertDialog.Builder(ZiliaoActivity.this);
        listDialog.setTitle("选择性别");
        listDialog.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // which 下标从0开始
                // ...To-do
                String item = items[which];
                sexText.setText(item);
                Toast.makeText(ZiliaoActivity.this,
                        "修改成功",
                        Toast.LENGTH_SHORT).show();
            }
        });
        listDialog.show();
    }





    //<-----------自定义--------------->

    private void showCustomizeDialog() {
    /* @setView 装入自定义View ==> R.layout.dialog_customize
     * 由于dialog_customize.xml只放置了一个EditView，因此和图8一样
     * dialog_customize.xml可自定义更复杂的View
     */
        final View dialogView = LayoutInflater.from(ZiliaoActivity.this)
                .inflate(R.layout.dialog_chooseheight,null);
        final ListView  listView= (ListView) dialogView.findViewById(R.id.listview);
        Button  button= (Button) dialogView.findViewById(R.id.dialog_sure);
        final Dialog customizeDialog = new AlertDialog.Builder(ZiliaoActivity.this).setView(dialogView).create();

        customizeDialog.setTitle("选择身高");
        final List<String>  mlist=new ArrayList<>();
        for(int i=40;i<199;i++){
            mlist.add(i+"");
        }
        adapter=new HeightAdapter(mlist,ZiliaoActivity.this);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = mlist.get(position);
                heightText.setText(s);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ZiliaoActivity.this, "修改成功", Toast.LENGTH_SHORT).show();
                 customizeDialog.dismiss();
            }
        });
        customizeDialog.show();
    }


    class HeightAdapter  extends BaseAdapter{
        List<String>  list;
        Context context;

        public HeightAdapter(List<String> list, Context context) {
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
                convertView=LayoutInflater.from(context).inflate(R.layout.diolog_heightitem,null);
                holder.textView= (TextView) convertView.findViewById(R.id.height_item);
                convertView.setTag(holder);
            }else{
                holder= (Holder) convertView.getTag();
            }
            String  str=list.get(position);
            holder.textView.setText(str);
            return convertView;
        }

        class Holder{
            TextView  textView;
        }
    }


}
