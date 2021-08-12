package com.ashark.verbo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

public class SignupScreenActivity extends AppCompatActivity {
    MaterialEditText userName, password, email, nativeLanguage, learningLanguage;

    Button buttonNativeLanguage, buttonLearningLanguage;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        userName = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);
        email = findViewById(R.id.signup_email);
        nativeLanguage = findViewById(R.id.signup_native_language);
        learningLanguage = findViewById(R.id.signup_learning_language);

        buttonNativeLanguage = findViewById(R.id.button_native_language);
        buttonLearningLanguage = findViewById(R.id.button_learning_language);

        buttonNativeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInfoAboutLang();

            }
        });
    }

    String[] languages = {"Swedish", "English", "Russian"};
    boolean[] checkedSites = new boolean[]{false, false, false};

    public void showInfoAboutLang() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setTitle("Native language");
        dialog.setMessage("Choose your native language");

        //Building the list to be shown in AlertDialog
        dialog.setMultiChoiceItems(languages, checkedSites, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                // Update the current item's checked status
                checkedSites[which] = isChecked;
            }
        });
        //Set Positive Button
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), "OK button was pressed", Toast.LENGTH_LONG).show();

            }
        });
        //Set Negative Button
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        //Creating AlertDialog
        AlertDialog alterDialog = dialog.create();
        //Displaying AlertDialog
        alterDialog.show();

    }


}