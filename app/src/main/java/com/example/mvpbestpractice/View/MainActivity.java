package com.example.mvpbestpractice.View;



import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.example.mvpbestpractice.Presenter.MainPresenter;
import com.example.mvpbestpractice.R;
import com.example.mvpbestpractice.base.BaseActivity;

public class MainActivity extends BaseActivity<IMainView,MainPresenter> implements View.OnClickListener{



    private EditText accountText;
    private EditText passwordText;
    private Button login;
    private Button logon;
    private String account;
    private String password;

    @Override
    protected MainPresenter createPresenter(){
        return new MainPresenter();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        accountText = (EditText)findViewById(R.id.account_text);
        passwordText = (EditText)findViewById(R.id.password_text);
        login = (Button)findViewById(R.id.login);
        logon = (Button)findViewById(R.id.logon);
        login.setOnClickListener(this);
        logon.setOnClickListener(this);


    }

    @Override
    public void onClick(View view){
        account = accountText.getText().toString();
        password = passwordText.getText().toString();
        switch (view.getId()){
            case R.id.login:{
                //调用mainPresenter的方法，数据从MainActivity传入mainPresenter
                getPresenter().login(account,password);
                break;
            }
            case R.id.logon:{
                //调用mainPresenter的方法，数据从MainActivity传入mainPresenter
                getPresenter().logon(account,password);
                break;
            }
        }
    }
    @Override
    public void loginSuccess(){
        Toast.makeText(this,"loginSuccess",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void loginFailed(){
        Toast.makeText(this,"loginFailed",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void logonSuccess(){
        Toast.makeText(this,"logonSuccess",Toast.LENGTH_SHORT).show();
    }
    @Override
    public void logonFailed(){
        Toast.makeText(this,"logonFailed",Toast.LENGTH_SHORT).show();
    }
}
