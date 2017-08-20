package com.ztb.nanke.customControl.firstView;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.ztb.nanke.R;

/**
 * Created by nanker on 2017/8/20.
 */

public class firstView extends View {
    private String oneStr,twoStr;
    private int oneColor,twoColor;
    // 1.创建一个画笔
    private Paint mPaint = new Paint();

    public firstView(Context context) {
        super(context);
        initPaint();
    }

    public firstView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.firstView);
        oneStr = typedArray.getString(R.styleable.firstView_oneStr);
        oneColor = typedArray.getColor(R.styleable.firstView_oneColor,getResources().getColor(R.color.white));
        twoStr = typedArray.getString(R.styleable.firstView_twoStr);
        twoColor = typedArray.getColor(R.styleable.firstView_twoColor,getResources().getColor(R.color.white));
        typedArray.recycle();
    }

    // 2.初始化画笔
    private void initPaint() {
        mPaint.setColor(Color.BLACK);       //设置画笔颜色
        mPaint.setStyle(Paint.Style.FILL);  //设置画笔模式为填充
        mPaint.setStrokeWidth(10f);         //设置画笔宽度为10px
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //定义存放测量后的View宽/高的变量
        int widthMeasure = 0;
        int heightMeasure = 0;
        //定义测量方法

//记得！最后使用setMeasuredDimension()  存储测量后View宽/高的值
//        setMeasuredDimension(20, 80);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(oneColor);
        mPaint.setTextSize(30);
        canvas.drawText(oneStr,0,50,mPaint);
        mPaint.setColor(twoColor);
        canvas.drawText(twoStr,oneStr.length()*30,50,mPaint);
    }
}
