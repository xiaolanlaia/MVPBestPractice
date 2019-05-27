package com.example.mvpbestpractice.View;

import com.example.mvpbestpractice.base.IBaseView;

public interface IMainView extends IBaseView {
    void loginSuccess();
    void loginFailed();
    void logonSuccess();
    void logonFailed();
}
