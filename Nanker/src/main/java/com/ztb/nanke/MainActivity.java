package com.ztb.nanke;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ztb.nanke.customControl.firstView.customControlActivity;
import com.ztb.nanke.designmode.observer.ObserverActivity;
import com.ztb.nankerlibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by nanker on 2017/4/20.
 */
public class MainActivity extends BaseActivity {

    @BindView(R.id.rx_java_btn)
    Button mRxJavaBtn;
    @BindView(R.id.view_group_btn)
    Button mViewGroupBtn;
    @BindView(R.id.observer_pattern_btn)
    Button mObserverPatternBtn;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.rx_java_btn, R.id.view_group_btn, R.id.observer_pattern_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.rx_java_btn:
                break;
            case R.id.view_group_btn:
                startActivity(new Intent(this,customControlActivity.class));
                break;
            case R.id.observer_pattern_btn:
                startActivity(new Intent(this, ObserverActivity.class));
                break;
        }
    }
}

