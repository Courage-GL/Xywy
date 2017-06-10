package com.example.abner.xywy_net.controller.activity.zxm;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.base.BaseActivity;

import static com.umeng.socialize.utils.ContextUtil.getContext;

/**
 * Created by 张萌 on 2017/6/9.
 */

public class ZiliaoActivity  extends BaseActivity implements View.OnClickListener{
    RelativeLayout  name,sex,height,weight,birthday;
    TextView  sexText;
    @Override
    protected int layoutId() {
        return R.layout.activity_ziliao;
    }

    @Override
    protected void initView() {
     name= (RelativeLayout) findViewById(R.id.name);
        sex= (RelativeLayout) findViewById(R.id.sex);
        sexText= (TextView) findViewById(R.id.sexText);
        height= (RelativeLayout) findViewById(R.id.height);
        weight= (RelativeLayout) findViewById(R.id.weight);
        birthday= (RelativeLayout) findViewById(R.id.birthday);
    }

    @Override
    protected void initData() {

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
        AlertDialog.Builder customizeDialog =
                new AlertDialog.Builder(getContext());
        final View dialogView = LayoutInflater.from(ZiliaoActivity.this)
                .inflate(R.layout.dialog_chooseheight,null);
        customizeDialog.setTitle("选择身高");
        customizeDialog.setView(dialogView);
        customizeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        customizeDialog.show();
    }


}
