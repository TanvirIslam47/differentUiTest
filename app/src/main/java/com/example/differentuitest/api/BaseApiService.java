package com.example.differentuitest.api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BaseApiService {

    @Headers("Content-Type: application/json")
    @POST("Bondhon/BONDHON_LOGIN")
    Call<ResponseBody> bondhonLogin(@Query("_UserName") String userId,
                                    @Query("_Password") String password);

    @GET("APPBondhon/PARTNER_LIST")
    Call<ResponseBody> partnerList(@Header("Authorization") String token,
                                   @Query("_OFFSET") int offset,
                                   @Query("_LIMIT") int limit);

}
