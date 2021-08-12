package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.rengwuxian.materialedittext.MaterialEditText;

public class SignupScreenActivity extends AppCompatActivity {
    MaterialEditText userName,password,email,nativeLanguage,learningLanguage;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        userName = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);
        email = findViewById (R.id.signup_email);
        nativeLanguage = findViewById (R.id.signup_native_language);
        learningLanguage = findViewById (R.id.signup_learning_language);
    }


}