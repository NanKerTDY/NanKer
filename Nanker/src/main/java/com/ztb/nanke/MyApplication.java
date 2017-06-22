package com.ztb.nanke;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

import org.litepal.LitePal;

/**
 * Created by nanker on 2017/4/24.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initTool();

    }

    private void initTool() {
        //初始化数据库操作工具LitePal
        LitePal.initialize(this);
        //初始化logger
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)  // (可选）是否显示线程信息。默认值为true
                .methodCount(0)         //（可选）要显示的方法行数。默认值2
                .methodOffset(7)        //（可选）隐藏内部方法调用到偏移量。默认5
//                .logStrategy(customLog) //（可选）更改要打印的日志策略。默认LogCat
                .tag("nk")   //（可选）每个日志的全局标签。
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy));
    }
}
