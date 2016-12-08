package com.promptnow.econprice.service;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Admin on 28/9/2559.
 */

public interface OilExcelUser {

    @GET("OilExcelAction")
    Call<OilExcelModel> loadJson();

    @POST("")
    Call<OilExcelUserRequest> postJson(@Body OilExcelUserRequest body);

}
