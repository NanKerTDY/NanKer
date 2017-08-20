package com.ztb.nanke.designmode.observer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by nanker on 2017/8/17.
 */

public class ObserverEditText extends android.support.v7.widget.AppCompatEditText {
    private Content content;

    public ObserverEditText(Context context) {
        super(context);
    }

    public ObserverEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        content = new Content();
        setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i == EditorInfo.IME_ACTION_SEARCH || i == EditorInfo.IME_ACTION_DONE ||
                        keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                                keyEvent.getAction() == KeyEvent.KEYCODE_ENTER) {
                    //触发各个Observer
                    content.setEditTextContent(getText().toString());
                }
                return false;
            }
        });
    }

    /**
     * 添加观察者
     *
     * @param observer
     */
    public void addObserver(Observer observer) {
        content.addObserver(observer);
    }

    //被观察者需要继承Observable
    private class Content extends Observable {
        private String editTextContent;

        public void setEditTextContent(String editTextContent) {
            this.editTextContent = editTextContent;
            //标识状态或者内容发生改变
            setChanged();
            //通知所有的观察者
            notifyObservers(editTextContent);
        }
    }
}
