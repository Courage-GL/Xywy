package com.example.abner.xywy_net.controller.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.PopupWindow;

import com.example.abner.xywy_net.R;

/**
 * Created by think on 2017/6/13.
 */

public class MyPopupwindow  extends PopupWindow {

    Context mContext;
    private LayoutInflater mInflater;
    private View mContentView;


    public MyPopupwindow(Context context) {
        super(context);

        this.mContext=context;
        //打气筒
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        //打气

        mContentView = mInflater.inflate(R.layout.hos_popuwindow,null);

        //设置View
        setContentView(mContentView);


        //设置宽与高
        setWidth(WindowManager.LayoutParams.MATCH_PARENT);

        setHeight(WindowManager.LayoutParams.WRAP_CONTENT);


        /**
         * 设置进出动画
         */
        setAnimationStyle(R.style.AppTheme);


        /**
         * 设置背景只有设置了这个才可以点击外边和BACK消失
         */
        setBackgroundDrawable(new ColorDrawable());


        /**
         * 设置可以获取集点
         */
        setFocusable(true);

        /**
         * 设置点击外边可以消失
         */
        setOutsideTouchable(true);

        /**
         *设置可以触摸
         */
        setTouchable(true);


        /**
         * 设置点击外部可以消失
         */

        setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                /**
                 * 判断是不是点击了外部
                 */
                if(event.getAction()==MotionEvent.ACTION_OUTSIDE){
                    return true;
                }
                //不是点击外部
                return false;
            }
        });


        /**
         * 初始化View与监听器
         */
        initView();

        initListener();
    }




    private void initView() {

    }

    private void initListener() {

    }



}
