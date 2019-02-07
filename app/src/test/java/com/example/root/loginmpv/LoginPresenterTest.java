package com.example.root.loginmpv;

import com.example.root.loginmpv.login.LoginActivity;
import com.example.root.loginmpv.login.LoginMVP;
import com.example.root.loginmpv.login.LoginModel;
import com.example.root.loginmpv.login.LoginPresenter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by root on 12/31/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class LoginPresenterTest {

    @Mock
    LoginMVP.Presenter presenter;

    @Mock
    LoginMVP.View view;

    @Mock
    LoginMVP.Model model;

    @Before
    public void setUp() throws Exception{
        presenter = new LoginPresenter(view, model);
    }


    @Test
    public void showErrorWhenUserNameIsEmpty() throws Exception {

        //given
        String username = "";
        String password = "111111";

        //when
        presenter.onLoginButtonClick(username,password);

        //then
        Mockito.verify(view).displayMsg();
    }

    @Test
    public void showErrorWhenPassowrdIsEmpty() throws Exception {

        //given
        String username = "eljo";
        String password = "";

        //when
        presenter.onLoginButtonClick(username,password);

        //then
        Mockito.verify(view).displayMsg();
    }

    @Test
    public void showErrorWhenUsernameOrPasswordDoesNotMatch() throws Exception {

        //given
        String username = "eljo";
        String password = "11";

        //when
        presenter.onLoginButtonClick(username,password);

        //then
        Mockito.verify(view).displayTryAgain();
    }

    @Test
    public void showLoginsuccessfully() throws Exception {

        //given
        String username = "eljo";
        String password = "1111111";

        //when
        presenter.onLoginButtonClick(username,password);

        //then
        Mockito.verify(view).displayTryAgain();

    }
}
