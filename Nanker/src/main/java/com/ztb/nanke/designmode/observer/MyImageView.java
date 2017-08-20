package com.ztb.nanke.designmode.observer;

import android.content.Context;
import android.media.Image;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.ImageView;

import com.ztb.nanke.R;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by iuni.life on 16/9/7.
 * yangfei's computer.
 * 观察者需要实现接口Observer，并在update方法中实现业务逻辑
 */
public class MyImageView extends android.support.v7.widget.AppCompatImageView implements Observer {
    public MyImageView(Context context) {
        super(context);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void update(Observable observable, Object o) {
        Log.d("MyImageView", "Observer:MyImageView收到通知:" + o);
        String content = o.toString();
        if (o.equals("iuni")) {
            setImageResource(R.mipmap.ic_launcher);
        } else {
            setImageResource(R.mipmap.ic_launcher);
        }
    }
}