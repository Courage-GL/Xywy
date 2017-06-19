package com.example.abner.xywy_net.tongjitu;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Abner on 2017/6/16.
 */

public class TiaoXingtu extends View {
    private final String TAG = TiaoXingtu.class.getName();
    //画笔
    private Paint mPaint;
    //标题
    private String title="血压测试图(100-200代表的是高压，200-300代表的是低压，300-400代表的是心率)";
    //标题颜色
    private int titleColor=Color.BLACK;
    //标题大小
    private float titleSize=40;
    //X坐标轴最大值
    private float maxAxisValueX = 500;
    //X坐标轴刻度线数量
    private int axisDivideSizeX = 5;
    //Y坐标轴最大值
    private float maxAxisValueY = 220;
    //Y坐标轴刻度线数量
    private int axisDivideSizeY = 11;
    //视图宽度
    private int width;
    //视图高度
    private int height;
    //坐标原点位置
    private final int originX = 100;
    private final int originY = 800;
    //柱状图数据
    private int columnInfo[][];

    public TiaoXingtu(Context context, AttributeSet attrs) {
        super(context, attrs);
        //创建画笔
        mPaint = new Paint();
    }

    /**
     * 设置X轴的最大值及刻度线数量（包括0坐标刻度）
     *
     * @param maxValue   X轴的最大值
     * @param divideSize 刻度线数量
     */
    public void setAxisX(float maxValue, int divideSize) {
        maxAxisValueX = maxValue;
        axisDivideSizeX = divideSize;
    }

    /**
     * 设置Y轴的最大值及刻度线数量（包括0坐标刻度）
     *
     * @param maxValue   Y轴的最大值
     * @param divideSize 刻度线数量
     */
    public void setAxisY(float maxValue, int divideSize) {
        maxAxisValueY = maxValue;
        axisDivideSizeY = divideSize;
    }

    /**
     * 设置柱状图数据
     *
     * @param columnInfo
     */
    public void setColumnInfo(int[][] columnInfo) {
        this.columnInfo = columnInfo;
        invalidate();
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec) - 200;
        height = MeasureSpec.getSize(heightMeasureSpec) - 800;
    }

    @Override
    public void onDraw(Canvas canvas) {
        drawAxisX(canvas, mPaint);
        drawAxisY(canvas, mPaint);
        drawAxisScaleMarkX(canvas, mPaint);
        drawAxisScaleMarkY(canvas, mPaint);
        drawAxisArrowsX(canvas, mPaint);
        drawAxisArrowsY(canvas, mPaint);
        drawAxisScaleMarkValueX(canvas, mPaint);
        drawAxisScaleMarkValueY(canvas, mPaint);
        drawColumn(canvas, mPaint);
        drawTitle(canvas, mPaint);
    }

    /**
     * 绘制横坐标轴（X轴）
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisX(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLACK);
        //设置画笔宽度
        paint.setStrokeWidth(5);
        //设置画笔抗锯齿
        paint.setAntiAlias(true);
        //画横轴(X)
        canvas.drawLine(originX, originY, originX + width, originY, paint);
    }

    /**
     * 绘制纵坐标轴(Y轴)
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisY(Canvas canvas, Paint paint) {
        //画竖轴(Y)
        canvas.drawLine(originX, originY, originX, originY - height, paint);//参数说明：起始点左边x,y，终点坐标x,y，画笔
    }


    /**
     * 绘制横坐标轴刻度线(X轴)
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisScaleMarkX(Canvas canvas, Paint paint) {
        float cellWidth = width / axisDivideSizeX;
        for (int i = 0; i < axisDivideSizeX - 1; i++) {
            canvas.drawLine(cellWidth * (i + 1) + originX, originY, cellWidth * (i + 1) + originX, originY - 10, paint);
        }
    }

    /**
     * 绘制纵坐标轴刻度线(Y轴)
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisScaleMarkY(Canvas canvas, Paint paint) {
        float cellHeight = height / axisDivideSizeY;
        for (int i = 0; i < axisDivideSizeY - 1; i++) {
            canvas.drawLine(originX, (originY - cellHeight * (i + 1)), originX + 10, (originY - cellHeight * (i + 1)), paint);
        }
    }

    /**
     * 绘制横坐标轴刻度值(X轴)
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisScaleMarkValueX(Canvas canvas, Paint paint) {
        //设置画笔绘制文字的属性
        paint.setColor(Color.GRAY);
        paint.setTextSize(28);
        paint.setFakeBoldText(true);

        float cellWidth = width / axisDivideSizeX;
        float cellValue = maxAxisValueX / axisDivideSizeX;
        for (int i = 1; i < axisDivideSizeX; i++) {
            canvas.drawText(String.valueOf(cellValue * i), cellWidth * i + originX - 35, originY + 30, paint);
        }
    }

    /**
     * 绘制纵坐标轴刻度值(Y轴)
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisScaleMarkValueY(Canvas canvas, Paint paint) {
        float cellHeight = height / axisDivideSizeY;
        float cellValue = maxAxisValueY / axisDivideSizeY;
        for (int i = 1; i < axisDivideSizeY; i++) {
            canvas.drawText(String.valueOf(cellValue * i), originX - 80, originY - cellHeight * i + 10, paint);
        }
    }

    /**
     * 绘制横坐标轴箭头(X轴)
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisArrowsX(Canvas canvas, Paint paint) {
        //画三角形（X轴箭头）
        Path mPathX = new Path();
        mPathX.moveTo(originX + width + 30, originY);//起始点
        mPathX.lineTo(originX + width, originY - 10);//下一点
        mPathX.lineTo(originX + width, originY + 10);//下一点
        mPathX.close();
        canvas.drawPath(mPathX, paint);
    }

    /**
     * 绘制纵坐标轴箭头(Y轴)
     *
     * @param canvas
     * @param paint
     */
    private void drawAxisArrowsY(Canvas canvas, Paint paint) {
        //画三角形（Y轴箭头）
        Path mPathX = new Path();
        mPathX.moveTo(originX, originY - height - 30);//起始点
        mPathX.lineTo(originX - 10, originY - height);//下一点
        mPathX.lineTo(originX + 10, originY - height);//下一点
        mPathX.close();
        canvas.drawPath(mPathX, paint);
    }

    /**
     * 绘制柱状图
     *
     * @param canvas
     * @param paint
     */
    private void drawColumn(Canvas canvas, Paint paint) {
        if(columnInfo == null)
            return;
        float cellWidth = width / axisDivideSizeX;
        for (int i = 0; i < columnInfo.length; i++) {
            paint.setColor(columnInfo[i][1]);
            float leftTopY = originY - height * columnInfo[i][0] / maxAxisValueY;
            canvas.drawRect(originX + cellWidth * (i + 1), leftTopY, originX + cellWidth * (i + 2), originY, mPaint);//左上角x,y右下角x,y，画笔
        }
    }

    /**
     * 绘制标题
     *
     * @param canvas
     * @param paint
     */
    private void drawTitle(Canvas canvas, Paint paint) {

        //画标题
        if (title != null) {
            //设置画笔绘制文字的属性
            mPaint.setColor(titleColor);
            mPaint.setTextSize(titleSize);
            mPaint.setFakeBoldText(true);
            canvas.drawText(title, 300, originY + 150, paint);
        }
    }
}
