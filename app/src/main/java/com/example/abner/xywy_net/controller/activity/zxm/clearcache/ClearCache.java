package com.example.abner.xywy_net.controller.activity.zxm.clearcache;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.abner.xywy_net.R;

import java.util.ArrayList;
import java.util.List;

public class ClearCache extends AppCompatActivity {

    private Context context;

    private Button btnCatchSize, btnCatchCleanDisk, btnCatchCleanMemory, btnCatchCleanDiskSelf;
    private LinearLayout layoutContainer;

    private List<String> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clearcache);
        initView();
        initData();
        initAdapter();
        initListener();
    }

    private void initView() {
        this.context = this;
        layoutContainer = (LinearLayout) findViewById(R.id.layout_container);
        btnCatchSize = (Button) findViewById(R.id.btn_catch_size);
        btnCatchCleanDisk = (Button) findViewById(R.id.btn_catch_clean_disk);
        btnCatchCleanMemory = (Button) findViewById(R.id.btn_catch_clean_memory);
        btnCatchCleanDiskSelf = (Button) findViewById(R.id.btn_catch_clean_disk_self);
    }

    private void initListener() {
        // Glide磁盘缓存大小
        btnCatchSize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Glide磁盘缓存大小:" + GlideCatchUtil.getInstance().getCacheSize());
            }
        });

        // 删除文件夹方法在主线程执行
        btnCatchCleanDisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GlideCatchUtil.getInstance().cleanCatchDisk()) {
                    showToast("清除Glide磁盘缓存成功，删除文件夹方法");
                } else {
                    showToast("清除Glide磁盘缓存失败，删除文件夹方法");
                }
            }
        });

        // 清除内存缓存
        btnCatchCleanMemory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GlideCatchUtil.getInstance().clearCacheMemory()) {
                    showToast("清除Glide内存缓存成功");
                } else {
                    showToast("清除Glide内存缓存失败");
                }
            }
        });

        // Glide自带删除磁盘缓存方法在线程中执行
        btnCatchCleanDiskSelf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (GlideCatchUtil.getInstance().clearCacheDiskSelf()) {
                    showToast("清除Glide磁盘缓存成功，Glide自带方法");
                } else {
                    showToast("清除Glide磁盘缓存失败，Glide自带方法");
                }
            }
        });

    }

    private void initData() {
        // 图片url在百度随便搜的
        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add("http://img1.imgtn.bdimg.com/it/u=3203939691,850046686&fm=21&gp=0.jpg");
            list.add("http://img3.imgtn.bdimg.com/it/u=875165914,2642402717&fm=21&gp=0.jpg");
            list.add("http://img3.imgtn.bdimg.com/it/u=4139437186,74667515&fm=21&gp=0.jpg");
            list.add("http://img4.imgtn.bdimg.com/it/u=2248379219,3604474269&fm=21&gp=0.jpg");
            list.add("http://img2.niutuku.com/1312/0831/0831-niutuku.com-28071.jpg");
            list.add("http://www.pp3.cn/uploads/201408/1406686270117.jpg");
            list.add("http://img3.imgtn.bdimg.com/it/u=3375298313,1944835706&fm=21&gp=0.jpg");
            list.add("http://bizhi.zhuoku.com/2012/12/09/zhuoku/Zhuoku147.jpg");
            list.add("http://img2.niutuku.com/desk/1208/2148/ntk-2148-41003.jpg");
            list.add("http://bizhi.zhuoku.com/2010/03/23/jingxuan/jingxuan074.jpg");
            list.add("http://img.dota2.com.cn/dota2/01/4c/014c4eb20ae9cda9213d64d02a18f5261463732426.jpg");
            list.add("http://img.dota2.com.cn/dota2/d3/5a/d35af02410b2ab10a4aa15d23795a0d11463732396.jpg");
        }
    }

    private void initAdapter() {
        if (layoutContainer.getChildCount() > 0) {
            layoutContainer.removeAllViews();
        }
        MainAdapter mainAdapter = new MainAdapter();
        ListView listView = new ListView(context);
        listView.setAdapter(mainAdapter);
        layoutContainer.addView(listView);
        mainAdapter.notifyDataSetChanged();
    }

    private void showToast(String toast) {
        Toast.makeText(this, toast, Toast.LENGTH_SHORT).show();
    }

    class MainAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder holder;
            if (null == view) {
                holder = new ViewHolder();
                LinearLayout layout = new LinearLayout(context);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        (int) (120 * context.getResources().getDisplayMetrics().density + 0.5f));
                layout.setLayoutParams(lp);
                ImageView img = new ImageView(context);
                img.setScaleType(ImageView.ScaleType.FIT_START);
                layout.addView(img);
                view = layout;
                holder.img = img;
                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            Glide.with(context).load(list.get(i)).into(holder.img);
            return view;
        }
    }

    class ViewHolder {
        ImageView img;
    }

}
