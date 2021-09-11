package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.widget.Button;
import android.widget.Toast;

import com.ashark.verbo.controller.JsonPlaceHolderApi;
import com.ashark.verbo.model.SigningRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.rengwuxian.materialedittext.MaterialEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginScreenActivity extends AppCompatActivity {
    MaterialEditText email, password;
    Button back, login;
    JsonPlaceHolderApi jsonPlaceHolderApi;
    Account[] list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        email = findViewById(R.id.signup_email);
        password = findViewById(R.id.signup_password);
        back = findViewById(R.id.button_back);
        login = findViewById(R.id.button_login);


//проверка валидности логина
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
//                    Toast.makeText(getApplicationContext(), "Invalid Email Address", Toast.LENGTH_LONG).show();
                    email.setError("Invalid Email Address");
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
//проверка валидности логина

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://10.0.2.2:8080/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        //переход на начальную страницу
        back.setOnClickListener(v -> {
            Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
            startActivity(intent);
        });

        login.setOnClickListener(v -> {
            authenticateUser(email.getText().toString(), password.getText().toString());

        });

    }

    private void authenticateUser(String login, String password) {

        SigningRequest request = new SigningRequest(login, password);

        Call<String> call = jsonPlaceHolderApi.authenticateUser(request);

        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                if (!response.isSuccessful()) {
                    Context context = getApplicationContext();
                    CharSequence text = "Incorrect login or password!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else {
                    Intent intent = new Intent(LoginScreenActivity.this, MainScreenActivity.class);
                    startActivity(intent);
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Context context = getApplicationContext();
                CharSequence text = "Incorrect login or password!";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                System.out.println(t);
            }
        });


    }
}