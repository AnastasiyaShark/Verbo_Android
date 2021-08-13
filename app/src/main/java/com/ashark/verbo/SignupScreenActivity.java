package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class SignupScreenActivity extends AppCompatActivity {
    MaterialEditText userName, password, email;
    MaterialBetterSpinner materialBetterSpinnerNativeLanguage, materialBetterSpinnerLearningLanguage;
    Button back, signUp;

    String[] nativeLanguages = {"Swedish", "English", "Russian"};
    String[] learningLanguages = {"Swedish", "English"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        userName = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);
        email = findViewById(R.id.signup_email);
        materialBetterSpinnerNativeLanguage = (MaterialBetterSpinner) findViewById(R.id.material_spinner_native_language);
        materialBetterSpinnerLearningLanguage = (MaterialBetterSpinner) findViewById(R.id.material_spinner_learning_language);
        back = findViewById(R.id.button_back);
        signUp = findViewById(R.id.button_reg);

        //установка native language
        ArrayAdapter<String> adapterNativeLanguage = new ArrayAdapter<>(SignupScreenActivity.this, android.R.layout.simple_dropdown_item_1line, nativeLanguages);
        materialBetterSpinnerNativeLanguage.setAdapter(adapterNativeLanguage);
        //установка learning language
        ArrayAdapter<String> adapterLearningLanguage = new ArrayAdapter<>(SignupScreenActivity.this, android.R.layout.simple_dropdown_item_1line, learningLanguages);
        materialBetterSpinnerLearningLanguage.setAdapter(adapterLearningLanguage);

        //переход на начальную страницу
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignupScreenActivity.this, MainActivity.class);
                startActivity(intent);
            }


        });


//        buttonNativeLanguage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v)
//
//            }
//        });
    }


//    public void showInfoAboutLang() {

//        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
//        dialog.setTitle("Native language");
//        dialog.setMessage("Choose your native language");
//
//        //Building the list to be shown in AlertDialog
//        dialog.setMultiChoiceItems(languages, checkedSites, new DialogInterface.OnMultiChoiceClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
//                // Update the current item's checked status
//                checkedSites[which] = isChecked;
//            }
//        });
//        //Set Positive Button
//        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Toast.makeText(getApplicationContext(), "OK button was pressed", Toast.LENGTH_LONG).show();
//
//            }
//        });
//        //Set Negative Button
//        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//            }
//        });
//
//        //Creating AlertDialog
//        AlertDialog alterDialog = dialog.create();
//        //Displaying AlertDialog
//        alterDialog.show();

//    }


}