package com.xh.hospitalclient.module.login;

import android.content.SharedPreferences;
import android.util.Log;

import com.trello.rxlifecycle.LifecycleProvider;
import com.trello.rxlifecycle.android.ActivityEvent;
import com.xh.hospitalclient.MyApplication;
import com.xh.hospitalclient.model.UserBean;
import com.xh.hospitalclient.model.UserInfo;
import com.xh.hospitalclient.net.RetrofitSubscriber;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

public class LoginPresenterImpl extends LoginContract.LoginPresenter {
    private static final String TAG = "LoginActivityPresenter";
    private LoginModelImpl loginModel;

    @Override
    void login(String username, String password) {
        getView().showLoading();

        loginModel.login(username, password)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .compose(getProvider().<UserBean>bindUntilEvent(ActivityEvent.DESTROY))
                .subscribe(new RetrofitSubscriber<UserBean>() {

                    @Override
                    public void onSuccess(UserBean userBean){
                        Log.i(TAG, "onSuccess: " + userBean.toString());
                        //放入缓存
                        UserInfo.set(MyApplication.getInstance(),userBean);
                        getView().hideLoading();
                        getView().showSuccess("登录");
                        getView().toMainActivity();

                    }
                    @Override
                    public void onError(String errorMsg) {
                        Log.i(TAG, "onError: fail");
                        getView().hideLoading();
                        getView().showError("用户不存在或密码错误，登录");
                    }
                });

    }

    LoginPresenterImpl(LifecycleProvider<ActivityEvent> provider) {
        super(provider);
        loginModel = LoginModelImpl.getInstance();
        loginModel.getRealm();
    }

    @Override
    public void onDetach() {
        super.onDetach();
        loginModel.closeRealm();
    }
}
