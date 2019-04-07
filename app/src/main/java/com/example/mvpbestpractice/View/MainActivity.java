package com.example.mvpbestpractice.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import android.widget.Toast;

import com.example.mvpbestpractice.Presenter.MainPresenter;
import com.example.mvpbestpractice.R;

public class MainActivity extends AppCompatActivity implements IMainView, View.OnClickListener{

    MainPresenter mainPresenter = new MainPresenter(this);
    private EditText accountText;
    private EditText passwordText;
    private Button login;
    private Button logon;
    private String account;
    private String password;

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
                mainPresenter.login(account,password);
                break;
            }
            case R.id.logon:{
                mainPresenter.logon(account,password);
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
