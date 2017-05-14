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

import com.esdonmez.esd.healthmonitor.Models.UserModel;

public class RegisterActivity extends AppCompatActivity {

    LinearLayout registerButton;
    EditText name, email, password;
    Editable nameText, emailText, passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Initialize();

        nameText = name.getText();
        emailText = email.getText();
        passwordText = password.getText();

        GradientDrawable register =  new GradientDrawable();
        register.setCornerRadius(15);
        register.setColor(Color.parseColor("#e04f5f"));

        registerButton.setBackground(register);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nameText != null && emailText != null && passwordText != null)
                {
                    UserModel user = new UserModel(0, nameText.toString(), emailText.toString(), passwordText.toString());

                    MainActivity.user = user;
                    Intent i = new Intent(RegisterActivity.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });
    }

    private void Initialize()
    {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);

        registerButton = (LinearLayout) findViewById(R.id.RegisterButton);
        name = (EditText) findViewById(R.id.Name);
        email = (EditText) findViewById(R.id.Email);
        password = (EditText) findViewById(R.id.Password);
    }
}
