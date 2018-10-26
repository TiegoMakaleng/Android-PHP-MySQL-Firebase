package com.ict.app;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.ict.app.constant.Ict;

public class ChangePasswordActivity extends AppCompatActivity {

    private EditText oldPassword, newPassword, confirmNewPassword;
    private Typeface font = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        setTitle(Ict.CHANGE_PASSWORD_TITLE);

        font = Typeface.createFromAsset(getAssets(), "font/PTN57F-webfont.ttf");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        oldPassword = (EditText) findViewById(R.id.editTextOldPassword);
        oldPassword.setTypeface(font);

        newPassword = (EditText) findViewById(R.id.editTextPassword);
        newPassword.setTypeface(font);

        confirmNewPassword = (EditText) findViewById(R.id.editTextPasswordConfirm);
        confirmNewPassword.setTypeface(font);

    }
}
