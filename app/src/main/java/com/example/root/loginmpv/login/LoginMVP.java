package com.example.root.loginmpv.login;

/**
 * Created by root on 10/15/17.
 */

public class LoginMVP {
    public interface View{
        String getUsername();
        String getPassword();

        void displayMsg();

        void displayLoginsuccesfully();

        void displayTryAgain();
    }
    public interface Presenter{
        void onLoginButtonClick(String username,String password);
        
    }
    public interface Model{
        boolean loginStatus(String username,String password);
    }
}
