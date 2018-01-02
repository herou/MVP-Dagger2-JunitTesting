package com.example.root.loginmpv;

import com.example.root.loginmpv.login.LoginActivity;
import com.example.root.loginmpv.login.LoginModel;
import com.example.root.loginmpv.login.LoginPresenter;
import com.example.root.loginmpv.login.di.DaggerLoginPresenterComponent;
import com.example.root.loginmpv.login.di.component.LoginPresenterComponent;
import com.example.root.loginmpv.login.di.module.LoginPresenterModule;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by root on 12/31/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginPresenter presenter;

    @Mock
    LoginActivity view;

    @Mock
    LoginModel model;

    @Before
    public void setUp() throws Exception{

        presenter = new LoginPresenter(view);

        LoginPresenterComponent component =
                DaggerLoginPresenterComponent.builder()
                        .loginPresenterModule(new LoginPresenterModule())
                        .build();

        component.inject(presenter);

    }


    @Test
    public void showErrorWhenUserNameIsEmpty() throws Exception {

        when(view.getUsername()).thenReturn("");
        presenter.onLoginButtonClick(view.getUsername(),view.getPassword());
        verify(view).displayMsg();

    }

    @Test
    public void showErrorWhenPassowrdIsEmpty() throws Exception {

        when(view.getUsername()).thenReturn("eljo");
        when(view.getPassword()).thenReturn("");
        presenter.onLoginButtonClick(view.getUsername(),view.getPassword());
        verify(view).displayMsg();
    }

    @Test
    public void showErrorWhenUsernameOrPasswordDoesNotMatch() throws Exception {

        when(view.getUsername()).thenReturn("eljo");
        when(view.getPassword()).thenReturn("1");
        when(model.loginStatus(view.getUsername(),view.getPassword())).thenReturn(false);
        presenter.onLoginButtonClick(view.getUsername(),view.getPassword());
        verify(view).displayTryAgain();
    }

    @Test
    public void showLoginsuccessfully() throws Exception {

        when(view.getUsername()).thenReturn("eljo");
        when(view.getPassword()).thenReturn("111111");
        when(model.loginStatus(view.getUsername(),view.getPassword())).thenReturn(true);
        presenter.onLoginButtonClick(view.getUsername(),view.getPassword());
        verify(view).displayLoginsuccesfully();

    }


}
