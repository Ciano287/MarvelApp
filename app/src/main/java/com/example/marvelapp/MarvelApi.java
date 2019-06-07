package com.example.marvelapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MarvelApi {

    private static final String BASE_URL = "https://gateway.marvel.com";

    public static MarvelService create(){

        OkHttpClient okHttpClient = new OkHttpClient.Builder()

                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))

                .build();


        Retrofit characterApi = new Retrofit.Builder()

                .baseUrl(BASE_URL)

                .client(okHttpClient)

                .addConverterFactory(GsonConverterFactory.create())

                .build();


        return characterApi.create(MarvelService.class);

    }


}
