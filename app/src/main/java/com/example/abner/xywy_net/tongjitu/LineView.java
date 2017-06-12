package com.example.abner.xywy_net.tongjitu;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;

@SuppressLint("DrawAllocation")
public class LineView extends View {

    private static final String TAG = "LineView";
    // 默认边距
    private int Margin = 40;
    // 原点坐标
    private int Xpoint;
    private int Ypoint;

    // X,Y轴的单位长度,即表格中的正方形的宽高
    private int Yscale = 32;
    private int Xscale = Yscale * 2;

    //是否显示表格
    private boolean isShowGrid = false;
    //是否展示表格为虚线
    private boolean isDottedLine = false;

    // X,Y轴 线的颜色
    private int XYColor = Color.WHITE;
    // X轴字体的颜色
    private int XTextColor = Color.WHITE;
    // Y轴字体的颜色
    private int YTextColor = Color.WHITE;
    // 表格的颜色
    private int GridColor = Color.WHITE;
    // 默认折线数据的颜色
    private int DataColor = Color.WHITE;

    private int XTextSize = 16;
    private int YTextSize = 16;

    // X轴上面的显示文字
    private ArrayList<String> XLabel;
    // Y轴上面的显示文字
    private ArrayList<String> YLabel;

    private int left = 0; // Y轴与Y轴上的文字的距离
    private int bottom = 0; //X轴与X轴上的文字的距离

    // 折线数据列表
    private ArrayList<ArrayList<Integer>> dataLists;
    //折线颜色列表
    private ArrayList<Integer> dataColorList;

    // 单前数据
    private ArrayList<Integer> dataList;
    private int dataColor;

    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public void setXYColor(int XYColor) {
        this.XYColor = XYColor;
    }

    public void setXTextColor(int XTextColor) {
        this.XTextColor = XTextColor;
    }

    public void setYTextColor(int YTextColor) {
        this.YTextColor = YTextColor;
    }

    public void setGridColor(int gridColor) {
        this.GridColor = gridColor;
    }

    public void setDataColor(int dataColor) {
        this.DataColor = dataColor;
    }

    public void setDataColorList(ArrayList<Integer> dataColorList) {
        this.dataColorList = dataColorList;
    }

    public void setXTextSize(int XTextSize) {
        this.XTextSize = XTextSize;
    }

    public void setYTextSize(int YTextSize) {
        this.YTextSize = YTextSize;
    }

    public void setShowGrid(boolean isShowGrid) {
        this.isShowGrid = isShowGrid;
    }

    public void setDottedLine(boolean isDottedLine) {
        this.isDottedLine = isDottedLine;
    }

    public void setXYLabel(ArrayList<String> xlabel, ArrayList<String> ylabel) {
        this.XLabel = xlabel;
        this.YLabel = ylabel;
    }

    public void setScale(int scale) {
        this.Yscale = scale;
        this.Xscale = this.Yscale * 2;
    }

    public void setYToYTextSpace(int left) {
        this.left = left;
    }

    public void setXToXTextSpace(int bottom) {
        this.bottom = bottom;
    }

    public void setDataList(ArrayList<ArrayList<Integer>> dataLists) {
        this.dataLists = dataLists;
        postInvalidate();
    }

    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (Yscale <= 24) {
            setMeasuredDimension(Xscale * (XLabel.size() + 2) + left, Yscale * (YLabel.size() + 2) + bottom);
        } else {
            setMeasuredDimension(Xscale * (XLabel.size() + 1) + left, Yscale * (YLabel.size() + 1) + bottom);
        }
    }

    // 初始化数据值
    public void init() {
        Xpoint = this.Margin + left;
        Ypoint = this.getHeight() - this.Margin - bottom;
        /*Xscale = (this.getWidth() - 2 * this.Margin) / (this.XLabel.size());
        Yscale = (this.getHeight() - 2 * this.Margin)  / (this.YLabel.size() - 1);*/
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawColor(Color.TRANSPARENT);
        Paint p1 = new Paint();
        p1.setStyle(Paint.Style.STROKE);
        p1.setAntiAlias(true);
        p1.setColor(XYColor);
        p1.setStrokeWidth(2);
        init();
        if (isShowGrid) {
            this.drawTable(canvas);
        } else {
            this.drawXLine(canvas, p1);
            this.drawYLine(canvas, p1);
        }
        if (dataLists != null) {
            for (int i = 0; i < dataLists.size(); i++) {
                this.drawData(canvas, i);
            }
        }
    }

    // 画表格
    private void drawTable(Canvas canvas) {
        Paint paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(GridColor);
        Path path = new Path();
        if (isDottedLine) {
            PathEffect effects = new DashPathEffect(new float[]{5, 5, 5, 5}, 1);//画虚线
            paint.setPathEffect(effects);
        }

        int startX = 0;
        int startY = 0;
        int stopX = 0;
        int stopY = 0;
        // 纵向线
        for (int i = 0; i <= XLabel.size(); i++) {
            startX = Xpoint + i * Xscale;
            startY = Ypoint;
            stopY = Ypoint - (this.YLabel.size() - 1) * Yscale;
            if (i != 0) {
                path.moveTo(startX - Xscale / 2, startY);
                path.lineTo(startX - Xscale / 2, stopY);
                canvas.drawPath(path, paint);
            }
            path.moveTo(startX, startY);
            path.lineTo(startX, stopY);
            canvas.drawPath(path, paint);
        }

        // 横向线
        for (int i = 0; i < YLabel.size(); i++) {
            startX = Xpoint;
            startY = Ypoint - i * Yscale;
            stopX = Xpoint + (this.XLabel.size()) * Xscale;
            path.moveTo(startX, startY);
            path.lineTo(stopX, startY);
            canvas.drawPath(path, paint);
        }
    }

    //画纵轴
    private void drawXLine(Canvas canvas, Paint p) {
        p.setColor(XYColor);
        float stopX = Xpoint;
        float stopY = Ypoint - Yscale * (YLabel.size() - 1);
        canvas.drawLine(Xpoint, Ypoint, stopX, stopY, p);
        // Y轴最后是否有箭头
        canvas.drawLine(stopX, stopY, stopX - Xscale / 6, stopY + Yscale / 3, p);
        canvas.drawLine(stopX, stopY, stopX + Xscale / 6, stopY + Yscale / 3, p);
    }


    // 画横轴
    private void drawYLine(Canvas canvas, Paint p) {
        p.setColor(XYColor);
        float stopX = Xpoint + Xscale * XLabel.size();
        float stopY = Ypoint;
        canvas.drawLine(Xpoint, Ypoint, stopX, stopY, p);
        // X轴最后是否有箭头
        canvas.drawLine(stopX, stopY, stopX - Xscale / 6, stopY - Yscale / 3, p);
        canvas.drawLine(stopX, stopY, stopX - Xscale / 6, stopY + Yscale / 3, p);
    }

    // 画数据
    private void drawData(Canvas canvas, int pos) {
        dataList = dataLists.get(pos);
        dataColor = pos < dataColorList.size() ? dataColorList.get(pos) : DataColor;
        Paint p = new Paint();
        p.setAntiAlias(true);

        // 纵轴数据
        for (int i = 0; i < YLabel.size(); i++) {
            int startY = Ypoint - i * Yscale;
            p.setColor(YTextColor);
            p.setTextSize(XTextSize);
            canvas.drawText(this.YLabel.get(i), this.Margin / 4,
                    startY + this.Margin / 4, p);
        }

        //横轴数据
        for (int i = 0; i < XLabel.size(); i++) {
            int startX = Xpoint + i * Xscale;
            p.setColor(XTextColor);
            p.setTextSize(YTextSize);
            canvas.drawText(this.XLabel.get(i), startX - this.Margin / 4 + Xscale / 2,
                    this.getHeight() - this.Margin / 4, p);
            p.setColor(dataColorList.size() > 0 ? dataColor : DataColor);
            canvas.drawCircle(startX + Xscale / 2, calY(dataList.get(i)), 4, p);

            if (i < XLabel.size() - 1) {
                canvas.drawLine(startX + Xscale / 2, calY(dataList.get(i)),
                        Xpoint + (i + 1) * Xscale + Xscale / 2, calY(dataList.get(i + 1)), p);
            }
        }
    }

    /**
     * @param y
     * @return
     */
    private int calY(int y) {
        int y0 = 0;
        int y1 = 0;
        //	Log.i("zzzz", "y:"+y);
        try {
            y0 = Integer.parseInt(YLabel.get(0));
            //		Log.i("zzzz", "y0"+y0);
            y1 = Integer.parseInt(YLabel.get(1));
            //		Log.i("zzzz","y1"+y1);
        } catch (Exception e) {
            //		Log.i("zzzz", "string changed is err");
            return 0;
        }
        try {
            //		Log.i("zzzz", "返回数据"+(Ypoint-(y-y0)*Yscale/(y1-y0)) );
            return Ypoint - ((y - y0) * Yscale / (y1 - y0));
        } catch (Exception e) {
            //	Log.i("zzzz", "return is err");
            return 0;
        }
    }

}
