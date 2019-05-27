package com.example.mvpbestpractice.Model;

public interface IMainModel {
    void login(String account,String password,ILoginListener iLoginListener);
    void logon(String account,String password,ILogonListener iLogonListener);
}
