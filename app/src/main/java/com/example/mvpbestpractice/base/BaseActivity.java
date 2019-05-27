package com.example.mvpbestpractice.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.mvpbestpractice.View.IMainView;

public abstract class BaseActivity<V extends IBaseView,P extends BasePresenter<V>> extends AppCompatActivity implements IMainView{

    public P basePresenter;
    protected abstract P createPresenter();

    public P getPresenter(){
        if (basePresenter == null){
            basePresenter = createPresenter();
        }
        return basePresenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        basePresenter = createPresenter();
        basePresenter.attachView((V)this);
    }
    @Override
    protected void onDestroy(){
        if (basePresenter != null){
            basePresenter.detachView();
        }
        super.onDestroy();
    }

}
