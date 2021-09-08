package com.ashark.verbo.controller;

import com.ashark.verbo.model.SigningRequest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface JsonPlaceHolderApi {
    @POST ("/login")
    Call<String> authenticateUser (@Body SigningRequest request);
}
