package com.ztb.nanke.designmode.observer;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
    * Created by iuni.life on 16/9/7.
    * yangfei's computer.
    * 观察者需要实现接口Observer，并在update方法中实现业务逻辑
    */
   public class MyTextView extends android.support.v7.widget.AppCompatTextView implements Observer {
       public MyTextView(Context context) {
           super(context);
       }

       public MyTextView(Context context, AttributeSet attrs) {
           super(context, attrs);
       }

       public MyTextView(Context context, AttributeSet attrs, int defStyleAttr) {
           super(context, attrs, defStyleAttr);
       }

       @Override
       public void update(Observable observable, Object o) {
           Log.d("MyTextView", "Observer:MyTextView收到通知:" + o);
           setText(o.toString());
       }
   }