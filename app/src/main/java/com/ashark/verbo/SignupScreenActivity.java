package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.ashark.verbo.controller.JsonPlaceHolderApi;
import com.ashark.verbo.controller.JsonPlaceHolderApiSignup;
import com.ashark.verbo.model.SignupRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignupScreenActivity extends AppCompatActivity {
    MaterialEditText userName, password, email;
    MaterialBetterSpinner materialBetterSpinnerNativeLanguage, materialBetterSpinnerLearningLanguage;
    Button back, signUp;

    String[] nativeLanguages = {"Swedish", "English", "Russian"};
    String[] learningLanguages = {"Swedish", "English"};

    JsonPlaceHolderApi jsonPlaceHolderApi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_screen);

        userName = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);
        email = findViewById(R.id.signup_email);
        materialBetterSpinnerNativeLanguage =  findViewById(R.id.material_spinner_native_language);
        materialBetterSpinnerLearningLanguage =  findViewById(R.id.material_spinner_learning_language);

        back = findViewById(R.id.button_back);
        signUp = findViewById(R.id.button_reg);

        //установка native language
        ArrayAdapter<String> adapterNativeLanguage = new ArrayAdapter<>(SignupScreenActivity.this, android.R.layout.simple_dropdown_item_1line, nativeLanguages);
        materialBetterSpinnerNativeLanguage.setAdapter(adapterNativeLanguage);
        //установка learning language
        ArrayAdapter<String> adapterLearningLanguage = new ArrayAdapter<>(SignupScreenActivity.this, android.R.layout.simple_dropdown_item_1line, learningLanguages);
        materialBetterSpinnerLearningLanguage.setAdapter(adapterLearningLanguage);



        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        //переход на начальную страницу
        back.setOnClickListener(v -> {
            Intent intent = new Intent(SignupScreenActivity.this, MainActivity.class);
            startActivity(intent);
        });

        signUp.setOnClickListener(v -> {
            Intent intent = new Intent(SignupScreenActivity.this, MainScreenActivity.class);
            startActivity(intent);
        });

    }

    private void createUser(String name, String password, String email,
                            String nativeLanguage, String learningLanguage1) {

        SignupRequest request = new SignupRequest(name,password,email,nativeLanguage,learningLanguage1);

        Call<Response<String>> call = jsonPlaceHolderApi.createUser(request);

        call.enqueue(new Callback<Response<String>>() {
            @Override
            public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {

            }

            @Override
            public void onFailure(Call<Response<String>> call, Throwable t) {
                System.out.println(t);
            }
        }

    }


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