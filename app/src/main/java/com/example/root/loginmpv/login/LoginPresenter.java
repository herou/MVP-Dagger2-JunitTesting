package com.example.root.loginmpv.login;


/**
 * Created by root on 10/15/17.
 */

public class LoginPresenter implements LoginMVP.Presenter{
    LoginMVP.View view;
    LoginModel loginModel = new LoginModel();

    public LoginPresenter(LoginMVP.View view) {
        this.view = view;
    }

    @Override
    public void onLoginButtonClick(String username,String password) {
        view.getUsername();
        view.getPassword();
        if(view.getUsername().equalsIgnoreCase("") || view.getPassword().equalsIgnoreCase("")){
            view.displayMsg();
        }else{
            if(loginModel.loginStatus(view.getUsername(),view.getPassword()) == true){
                view.displayLoginsuccesfully();
            }else{
                view.displayTryAgain();
            }
        }
    }
}
