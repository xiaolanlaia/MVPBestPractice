package com.example.mvpbestpractice.base;

import com.example.mvpbestpractice.View.IMainView;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public abstract class BasePresenter<V extends IBaseView> {

    protected V mIBaseView;

    protected void getProxyView(){
        mIBaseView = (V) Proxy.newProxyInstance(mIBaseView.getClass().getClassLoader(),mIBaseView.getClass().getInterfaces(),
                new NotNullnvocationHandler(mIBaseView));
    }

    public void attachView(V mIBaseView){
        this.mIBaseView = mIBaseView;
        getProxyView();
    }
    public V getView(){
        return mIBaseView;
    }
    public void detachView(){
        mIBaseView = null;
    }

    public class NotNullnvocationHandler implements InvocationHandler{

        protected V v;

        public NotNullnvocationHandler(V v){
            this.v = v;
        }

        @Override
        public Object invoke(Object proxy, Method method,Object[] args) throws Throwable{
            if (mIBaseView == null){
                return null;
            }
            return method.invoke(v,args);
        }
    }
}
