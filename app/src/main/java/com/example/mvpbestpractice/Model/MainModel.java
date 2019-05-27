package com.example.mvpbestpractice.Model;

public class MainModel implements IMainModel {

    @Override
    public void login(String account,String password,ILoginListener iLoginListener){
        //当账号密码都为“1”时，Toast登录成功
        if (account.equals("1")&&password.equals("1")){
            iLoginListener.loginSuccess();
        }else {
            iLoginListener.loginFailed();
        }
    }
    @Override
    public void logon(String account,String password,ILogonListener iLogonListener){

        //当账号密码都为“2”时，Toast注册成功
        if (account.equals("2")&&password.equals("2")){
            iLogonListener.logonSuccess();
        }else {
            iLogonListener.logonFailed();
        }
    }
}
