package com.ztb.nanke.designmode.observer;

import android.os.Bundle;

import com.ztb.nanke.R;
import com.ztb.nankerlibrary.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by nanker on 2017/8/17.
 */

public class ObserverActivity extends BaseActivity {
    @BindView(R.id.id_et)
    ObserverEditText mIdEt;
    @BindView(R.id.id_tv)
    MyTextView mIdTv;
    @BindView(R.id.id_iv)
    MyImageView mIdIv;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_observer;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
        mIdEt.addObserver(mIdIv);
        mIdEt.addObserver(mIdTv);
    }
}
