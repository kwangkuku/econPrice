package com.promptnow.econprice.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;



public interface Lottery {

    @GET("LotteryAction")
    Call<LotteryModel> loadJson();



    @POST("")
    Call<LotteryRequest> postJson(@Body LotteryRequest body);


}
