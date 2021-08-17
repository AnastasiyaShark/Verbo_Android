package com.ashark.verbo;

import static androidx.navigation.ui.NavigationUI.setupActionBarWithNavController;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;

public class UserScreenActivity extends AppCompatActivity {

    ImageButton back;
    Button account, vocabulary, logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_screen);



        back = findViewById(R.id.back);
        account = findViewById(R.id.account);
        vocabulary = findViewById(R.id.vocabulary);
        logout = findViewById(R.id.logout);

        back.setOnClickListener(v -> {
            Intent intent = new Intent(UserScreenActivity.this,MainScreenActivity.class);
            startActivity(intent);
        });

        logout.setOnClickListener(v -> {
            openQuitDialog();
        });

        account.setOnClickListener(v -> {
            Intent intent = new Intent(UserScreenActivity.this,SettingsActivity.class);
            startActivity(intent);
        });

    }

    private void openQuitDialog() {
        AlertDialog.Builder quitDialog = new AlertDialog.Builder(
                UserScreenActivity.this);
        quitDialog.setTitle("Exit");
        quitDialog.setMessage("Are you sure?");

        quitDialog.setPositiveButton("Logout", (dialog, which) -> {
//                finish();
            Intent intent = new Intent(UserScreenActivity.this,MainActivity.class);
            startActivity(intent);
        });

        quitDialog.setNegativeButton("Cancel", (dialog, which) -> dialog.dismiss());

        quitDialog.show();
    }
}