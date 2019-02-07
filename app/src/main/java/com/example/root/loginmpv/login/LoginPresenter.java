package com.example.root.loginmpv.login;

/**
 * Created by root on 10/15/17.
 */

public class LoginPresenter implements LoginMVP.Presenter{

    LoginMVP.View view;
    public LoginMVP.Model loginModel;


    public LoginPresenter(LoginMVP.View view,LoginMVP.Model loginModel) {
        this.view = view;
        this.loginModel = loginModel;
    }

    @Override
    public void onLoginButtonClick(String username,String password) {
        if(username.equalsIgnoreCase("") || password.equalsIgnoreCase("")){
            view.displayMsg();
        }else{
            if(loginModel.loginStatus(username, password) == true){
                view.displayLoginsuccesfully();
            }else{
                view.displayTryAgain();
            }
        }
    }
}
