package com.example.abner.xywy_net.controller.activity;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioButton;

import com.example.abner.xywy_net.R;
import com.example.abner.xywy_net.adapter.UploadImageAdapter;
import com.example.abner.xywy_net.utils.netutils.ImageUtils;

import java.util.LinkedList;


/**
 * Created by Abner on 2017/6/10.
 */

public class FreeAskActivity extends BaseActivity1 implements View.OnClickListener{
    private ImageView imageView_back;
    private Button commitBtn;
    private EditText context,age;
    private RadioButton radiaBtnOne,radioBtnTwo;
    private String sex;

    private GridView uploadGridView;
    /**
     * 需要上传的图片路径 控制默认图片在最后面需要用LinkedList
     */
    private LinkedList<String> dataList = new LinkedList<String>();
    /**
     * 图片上传Adapter
     */
    private UploadImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freeask);
        initView();
    }

    private void initView() {
        uploadGridView = (GridView) findViewById(R.id.upload_pictures);
        dataList.addLast(null);// 初始化第一个添加按钮数据
        adapter = new UploadImageAdapter(this, dataList);
        uploadGridView.setAdapter(adapter);
        uploadGridView.setOnItemClickListener(mItemClick);
        uploadGridView.setOnItemLongClickListener(mItemLongClick);
        imageView_back= (ImageView) findViewById(R.id.freeask_back);
        imageView_back.setOnClickListener(this);
        commitBtn= (Button) findViewById(R.id.commit);
        commitBtn.setOnClickListener(this);
        context= (EditText) findViewById(R.id.data);
        age= (EditText) findViewById(R.id.age);
        radiaBtnOne= (RadioButton) findViewById(R.id.radioButton1);
        radioBtnTwo= (RadioButton) findViewById(R.id.radioButton2);
    }
    /**
     * 上传图片GridView Item单击监听
     */
    private AdapterView.OnItemClickListener mItemClick = new AdapterView.OnItemClickListener() {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            if (parent.getItemAtPosition(position) == null) { // 添加图片
                // showPictureDailog();//Dialog形式
                showPicturePopupWindow();// PopupWindow形式
            }
        }
    };

    /**
     * 上传图片GridView Item长按监听
     */
    private AdapterView.OnItemLongClickListener mItemLongClick = new AdapterView.OnItemLongClickListener() {

        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view,
                                       int position, long id) {
            if (parent.getItemAtPosition(position) != null) { // 长按删除
                dataList.remove(parent.getItemAtPosition(position));
                adapter.update(dataList); // 刷新图片
            }
            return true;
        }
    };

    String[] proj = { MediaStore.MediaColumns.DATA };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECT_IMAGE_RESULT_CODE && resultCode == RESULT_OK) {
            String imagePath = "";
            Uri uri = null;
            if (data != null && data.getData() != null) {// 有数据返回直接使用返回的图片地址
                uri = data.getData();
                Cursor cursor = getContentResolver().query(uri, proj, null,
                        null, null);
                if (cursor == null) {
                    uri = ImageUtils.getUri(this, data);
                }
                imagePath = ImageUtils.getFilePathByFileUri(this, uri);
            } else {// 无数据使用指定的图片路径
                imagePath = mImagePath;
            }
            dataList.addFirst(imagePath);
            adapter.update(dataList); // 刷新图片
        }
    }
    protected void loadData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.update_back:
                finish();
                break;
            case R.id.commit:
                String age=this.age.getText().toString().trim();
                String context=this.context.getText().toString().trim();
                if(radiaBtnOne.isChecked()){
                    sex="男";
                }else {

                    sex="女";
                }
                //下面该发送网络请求了
                break;
        }
    }
}
