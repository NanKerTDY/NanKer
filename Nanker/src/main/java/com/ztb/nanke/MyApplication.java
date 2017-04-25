package com.ztb.nanke;

import android.app.Application;

import org.litepal.LitePal;

/**
 * Created by nanker on 2017/4/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//        初始化数据库操作工具LitePal
        LitePal.initialize(this);
    }
}
