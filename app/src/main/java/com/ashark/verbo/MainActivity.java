package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button login, signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        login = findViewById(R.id.grammar);
        signUp = findViewById(R.id.learn_verbs);
        //внутри что будет происходить при нажатии на кнопку
        login.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, LoginScreenActivity.class);
            startActivity(intent);

        });
        //переход на другую страницу
        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignupScreenActivity.class);
            startActivity(intent);
        });


    }
}