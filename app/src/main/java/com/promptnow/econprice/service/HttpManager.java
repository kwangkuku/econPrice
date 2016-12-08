package com.promptnow.econprice.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.promptnow.econprice.fragment.lottery.LotteryFragment.BASE_URL;



public class HttpManager {

    private static HttpManager instance;

    Lottery lot;
    User user;
    OilUser oilUser;
    OilExcelUser oilExcelUser;

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
        lot = retrofit.create(Lottery.class);
        user = retrofit.create(User.class);
        oilUser = retrofit.create(OilUser.class);
        oilExcelUser = retrofit.create(OilExcelUser.class);
    }

    public Lottery getLot() {
        return lot;
    }

    public User getUser() {
        return user;
    }
    public OilUser getOilUser() {
        return oilUser;
    }

    public OilExcelUser getOilExcelUser() {return oilExcelUser;
    }
}
