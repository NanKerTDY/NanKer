package com.ztb.nanke.login;

import com.ztb.nanke.R;
import com.ztb.nanke.login.view.ILoginView;
import com.ztb.nankerlibrary.base.BaseActivity;

/**
 * Created by nanker on 2017/6/22.
 */

public class LoginActivity extends BaseActivity implements ILoginView {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public String getUserName() {
        return null;
    }

    @Override
    public String getUserPassword() {
        return null;
    }

    @Override
    public void clearUserName() {

    }

    @Override
    public void clearUserPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showFailedError() {

    }
}
