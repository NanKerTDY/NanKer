package com.ztb.nanke.customControl.firstView;

import android.os.Bundle;

import com.ztb.nanke.R;
import com.ztb.nankerlibrary.base.BaseActivity;

import butterknife.ButterKnife;

/**
 * Created by nanker on 2017/8/20.
 */

public class customControlActivity extends BaseActivity {
    @Override
    protected int getLayoutId() {
        return R.layout.activity_custom_control;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }
}
