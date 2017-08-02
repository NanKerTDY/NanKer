package com.ztb.nanke;

import android.os.Bundle;
import android.widget.Button;

import com.ztb.nankerlibrary.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by nanker on 2017/4/20.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.rx_java_btn)
    Button mRxJavaBtn;
    @BindView(R.id.view_group_btn)
    Button mViewGroupBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}

