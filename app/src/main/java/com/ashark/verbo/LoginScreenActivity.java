package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

public class LoginScreenActivity extends AppCompatActivity {
    MaterialEditText userName, password;
    Button back, login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        userName = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);
        back = findViewById(R.id.button_back);
        login = findViewById(R.id.button_login);


        //переход на начальную страницу
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }


        });
    }
}