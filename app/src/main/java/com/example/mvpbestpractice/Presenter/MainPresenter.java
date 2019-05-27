package com.example.mvpbestpractice.Presenter;



import com.example.mvpbestpractice.Model.ILoginListener;
import com.example.mvpbestpractice.Model.ILogonListener;
import com.example.mvpbestpractice.Model.IMainModel;
import com.example.mvpbestpractice.Model.MainModel;
import com.example.mvpbestpractice.View.IMainView;
import com.example.mvpbestpractice.base.BasePresenter;

public class MainPresenter extends BasePresenter<IMainView> {

    // 的实例传入Presenter

    private IMainModel iMainModel;

    public MainPresenter(){
        iMainModel = new MainModel();
    }
    public void login(String account,String password){
        //将account、password传入Model
        //实现数据从Presenter传入Model
        iMainModel.login(account, password, new ILoginListener() {

            @Override
            public void loginSuccess() {
                getView().loginSuccess();
            }

            @Override
            public void loginFailed() {
                getView().loginFailed();
            }
        });
    }

    public void logon(String account,String password){
        iMainModel.logon(account, password, new ILogonListener() {
            @Override
            public void logonSuccess() {
                getView().logonSuccess();
            }

            @Override
            public void logonFailed() {
                getView().logonFailed();
            }
        });
    }
}
