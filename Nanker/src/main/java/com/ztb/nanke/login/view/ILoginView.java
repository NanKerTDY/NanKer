package com.ztb.nanke.login.view;

/**
 * Created by nanker on 2017/6/22.
 */

public interface ILoginView {
    String getUserName();

    String getUserPassword();

    void clearUserName();

    void clearUserPassword();

    void showLoading();

    void hideLoading();

    void showFailedError();
}
