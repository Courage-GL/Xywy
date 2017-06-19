package com.example.abner.xywy_net.controller.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by think on 2017/6/14.
 */

public class AleView extends View {

    private Context context;
    private int Xwight = 8;
    private int Yhight = 4;
    private int width;
    private int height;
    private int widths;
    private int heights;
    public String[] Data = {"一", "二", "三", "四", "五", "六", "七"};
    public String[] Time = {"上午", "下午", "晚上"};
    private Map<String, Integer> map;

    public AleView(Context context) {
        super(context);
    }

    public AleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        map = new HashMap<>();
        this.context = context;
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = getWidth();
        height = getHeight();

        widths = width / Xwight;  //x间隔
        heights = height / Yhight; //Y间隔
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setAntiAlias(true);
        paint.setTextSize(35);

        for (int i = 0; i < Data.length; i++) {
                  canvas.drawText(Data[i], widths * (i+1) + widths / 3, heights / 3 * 2, paint);
        }

        for (int i = 0; i < Time.length; i++) {
                canvas.drawText(Time[i], widths / 6, heights / 3 * 2 + heights * (i+1), paint);
        }
        for(int i = 0;i*heights<height;i++){
            canvas.drawLine(0,0+heights*i,width,heights*i,paint);
        }

        canvas.drawLine(widths,0,widths,height,paint);

    }



    /**
     * @param sun 星期 1 到 7
     * @param sunType   上午1 中午 2 下午 3
     */
    public void setSunDay(String sun,String sunType) {
        int  sunday=0;
        int   type=0;
        switch (sun){
            case  "星期一":
                sunday=1;
                break;
            case  "星期二":
                sunday=2;
                break;
            case  "星期三":
                sunday=3;
                break;
            case  "星期四":
                sunday=4;
                break;
            case  "星期五":
                sunday=5;
                break;
            case  "星期六":
                sunday=6;
                break;
            case  "星期七":
                sunday=7;
                break;

        }
        if (sunType.contains("上午")){
            type=1;
        }
        else  if (sunType.contains("下午")){
            type=2;
        }
        else  if (sunType.contains("晚上")){
            type=3;
        }
        //这里判断用户输入的sunday值和type是否正确 不正确 直接Toast 同时return
        if (sunday == 0 || sunday > 7 || type == 0 || type > 3) {
            Toast.makeText(context, "请输入正确的星期或者时间", Toast.LENGTH_SHORT).show();
            return;
        }

        if (map.get(String.valueOf(sunday) + String.valueOf(type)) != null) {
            int index = map.get(String.valueOf(sunday) + String.valueOf(type));
            map.remove(String.valueOf(sunday) + String.valueOf(type));
            addView(sunday, type);
        } else {
            addView(sunday, type);
        }


    }

    /**
     * 这里是添加view的方法
     *
     * @param sunday  1-7
     * @param type   123  上午 下午  晚上
     */
    private void addView(int sunday, int type) {

        // map.put(String.valueOf(sunday) + String.valueOf(type), getChildCount());
        //这个view的左边距等于 你输入的星期几 乘以 每个view的宽度
        int left = widths * sunday;
        //这里每个view的上边距为 你输入的时间 乘以每个子view的高度
        int top = heights * type;


        TextView textView = new TextView(context);
        //textView.setLayoutParams(params);
        textView.setTextSize(15);
        textView.setText("专家");
        textView.setBackgroundColor(Color.parseColor("#16DCC7"));
        //addView(textView);
        textView.layout(left, top, left + widths, top + heights);
    }

}
