package com.example.root.loginmpv.login;

/**
 * Created by root on 10/15/17.
 */

public class LoginModel implements LoginMVP.Model {

    @Override
    public boolean loginStatus(String username, String password) {

        if(username.equalsIgnoreCase("eljo")&&password.equalsIgnoreCase("111111")){
            return true;
        }
        return false;
    }
}
