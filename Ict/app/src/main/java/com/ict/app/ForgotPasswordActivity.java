package com.ict.app;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ict.app.constant.Ict;

public class ForgotPasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setTitle(Ict.FORGOT_PASSWORD_TITLE);

        Typeface font = Typeface.createFromAsset(getAssets(), "font/RobotoSlab-Bold.ttf");
    }
}
