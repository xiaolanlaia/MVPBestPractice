package com.example.mvpbestpractice.Presenter;

import android.widget.Toast;

import com.example.mvpbestpractice.Model.ILoginListener;
import com.example.mvpbestpractice.Model.ILogonListener;
import com.example.mvpbestpractice.Model.IMainModel;
import com.example.mvpbestpractice.Model.MainModel;
import com.example.mvpbestpractice.View.IMainView;

public class MainPresenter {

    private IMainView iMainView;
    private IMainModel iMainModel;

    public MainPresenter(IMainView iMainView){
        this.iMainView = iMainView;
        iMainModel = new MainModel();
    }



    public void login(String account,String password){

        iMainModel.login(account, password, new ILoginListener() {
            @Override
            public void loginSuccess() {

                iMainView.loginSuccess();
            }

            @Override
            public void loginFailed() {

                iMainView.loginFailed();
            }
        });
    }

    public void logon(String account,String password){
        iMainModel.logon(account, password, new ILogonListener() {
            @Override
            public void logonSuccess() {
                iMainView.logonSuccess();
            }

            @Override
            public void logonFailed() {

                iMainView.logonFailed();
            }
        });
    }
}
