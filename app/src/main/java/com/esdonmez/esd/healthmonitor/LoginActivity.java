package com.esdonmez.esd.healthmonitor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.esdonmez.esd.healthmonitor.Models.UserModel;

public class LoginActivity extends AppCompatActivity {

    LinearLayout loginButton;
    EditText email, password;
    Editable emailText, passwordText;
    TextView registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Initialize();

        emailText = email.getText();
        passwordText = password.getText();

        GradientDrawable login =  new GradientDrawable();
        login.setCornerRadius(15);
        login.setColor(Color.parseColor("#e04f5f"));

        loginButton.setBackground(login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(emailText != null && passwordText != null)
                {
                    UserModel user = new UserModel(emailText.toString().split("\\@")[0], emailText.toString(), passwordText.toString());

                    MainActivity.user = user;
                    Intent i = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(i);
            }
        });
    }

    private void Initialize()
    {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        loginButton = (LinearLayout) findViewById(R.id.LoginButton);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);
        registerButton = (TextView) findViewById(R.id.RegisterButton);
    }
}
