package com.promptnow.econprice.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Admin on 28/9/2559.
 */

public interface User {

    @GET("LotteryAction")
    Call<LotteryModel> loadJson();

    @POST("")
    Call<LotteryUserRequest> postJson(@Body LotteryUserRequest body);

}
