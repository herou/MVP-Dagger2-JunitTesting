package com.example.root.loginmpv.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.root.loginmpv.R;

public class LoginActivity extends AppCompatActivity implements LoginMVP.View {

    EditText username;
    EditText password;
    Button login;

    private LoginPresenter mLoginPresernter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLoginPresernter = new LoginPresenter(this);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLoginPresernter.onLoginButtonClick(getUsername(),getPassword());
            }
        });
    }

    @Override
    public String getUsername() {
        return username.getText().toString();
    }

    @Override
    public String getPassword() {
        return password.getText().toString();
    }

    @Override
    public void displayMsg() {
        Toast.makeText(getApplicationContext(), R.string.checkUsernameAndPassowrd,Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayLoginsuccesfully() {
        Toast.makeText(getApplicationContext(), R.string.loginSuccesfully,Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayTryAgain() {
        Toast.makeText(getApplicationContext(), R.string.tryAgain,Toast.LENGTH_LONG).show();
    }
}
