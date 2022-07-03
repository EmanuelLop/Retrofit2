package com.example.retrofit2.service;

import com.example.retrofit2.entity.Message;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApiService {
    @GET("posts/{id}")
    Call<Message>getMessageId(@Path("id")int id);

}
