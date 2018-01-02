package com.example.root.loginmpv.login.di.component;

import com.example.root.loginmpv.login.LoginPresenter;
import com.example.root.loginmpv.login.di.module.LoginPresenterModule;

import dagger.Component;

/**
 * Created by root on 12/31/17.
 */

@Component(modules = LoginPresenterModule.class)
public interface LoginPresenterComponent {

    void inject(LoginPresenter presenter);
}
