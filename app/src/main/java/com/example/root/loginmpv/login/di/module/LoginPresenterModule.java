package com.example.root.loginmpv.login.di.module;

import com.example.root.loginmpv.login.LoginActivity;
import com.example.root.loginmpv.login.LoginMVP;
import com.example.root.loginmpv.login.LoginModel;
import com.example.root.loginmpv.login.LoginPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by root on 12/31/17.
 */

@Module
public class LoginPresenterModule {

    @Provides
    LoginPresenter providesLoginPresenter() {
        return new LoginPresenter(new LoginActivity());
    }

    @Provides
    LoginModel providesLoginModel() {
        return new LoginModel();
    }
}
