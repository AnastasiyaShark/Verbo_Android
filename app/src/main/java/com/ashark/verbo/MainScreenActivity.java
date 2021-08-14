package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainScreenActivity extends AppCompatActivity {

    Button learnVerbs, repeatVerbs, exam, grammar, profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        learnVerbs = findViewById(R.id.learn_verbs);
        repeatVerbs = findViewById(R.id.repeat_verbs);
        exam = findViewById(R.id.exam);
        grammar = findViewById(R.id.grammar);
        profile = findViewById(R.id.profile);

        profile.setOnClickListener(v -> {
            Intent intent = new Intent(MainScreenActivity.this, UserScreenActivity.class);
            startActivity(intent);

        });

    }
}