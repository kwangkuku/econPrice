package com.promptnow.econprice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.promptnow.econprice.fragment.lottery.LotteryFragment.BASE_URL;



public class HttpManager {

    private static HttpManager instance;

    User user;
    public static HttpManager getInstance(){

        return new HttpManager();
    }

    private HttpManager(){

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        user = retrofit.create(User.class);
    }

    public User getUser() {
        return user;
    }
}
