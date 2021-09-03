package com.ashark.verbo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.widget.Button;
import android.widget.Toast;

import com.ashark.verbo.controller.JsonPlaceHolderApi;
import com.ashark.verbo.model.SigningRequest;
import com.rengwuxian.materialedittext.MaterialEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginScreenActivity extends AppCompatActivity {
    MaterialEditText userName, password;
    Button back, login;
    JsonPlaceHolderApi jsonPlaceHolderApi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        userName = findViewById(R.id.signup_username);
        password = findViewById(R.id.signup_password);
        back = findViewById(R.id.button_back);
        login = findViewById(R.id.button_login);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://10.0.2.2:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);


        //переход на начальную страницу
        back.setOnClickListener(v -> {
            Intent intent = new Intent(LoginScreenActivity.this, MainActivity.class);
            startActivity(intent);
        });
        login.setOnClickListener(v -> {
            authenticateUser(userName.getHelperText(),password.getHelperText());

//            Intent intent = new Intent(LoginScreenActivity.this, MainScreenActivity.class);
//            startActivity(intent);
        });

    }

    private void authenticateUser (String login, String password){

        SigningRequest request = new SigningRequest(login,password);

        Call<Response<String>> call = jsonPlaceHolderApi.authenticateUser(request);
//        System.out.println(call.request());

        call.enqueue(new Callback<Response<String>>() {

            @Override
            public void onResponse(Call<Response<String>> call, Response<Response<String>> response) {
                    if (!response.isSuccessful()){
                        System.out.println(response.body());
                    }

            }

            @Override
            public void onFailure(Call<Response<String>> call, Throwable t) {
                System.out.println(t);
            }
        });
    }
}