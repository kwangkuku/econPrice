package com.promptnow.econprice.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Admin on 28/9/2559.
 */

public interface OilUser {

    @GET("oilAction")
    Call<OilModel> loadJson();

    @POST("")
    Call<OilUserRequest> postJson(@Body OilUserRequest body);

}
