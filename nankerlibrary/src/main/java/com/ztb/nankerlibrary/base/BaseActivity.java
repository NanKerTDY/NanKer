package com.ztb.nankerlibrary.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;

/**
 * Created by nanker on 2017/4/20.
 * 所有Activity的父类，写了一些公用的方法
 */

public class BaseActivity extends AppCompatActivity {
    protected LayoutInflater mInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        mInflater = getLayoutInflater();
        if (getLayoutId() != 0){
            setContentView(getLayoutId());
//            initActionBar();
        }
    }

    protected int getLayoutId() {
        return 0;
    }
}
