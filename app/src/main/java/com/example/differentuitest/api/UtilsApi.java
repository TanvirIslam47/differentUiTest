package com.example.differentuitest.api;

public class UtilsApi {
    public static final String BASE_URL_API = "https://appapi.elpl.app/";

    // Mendeklarasikan Interface BaseApiService
    public static BaseApiService getAPIService(){
        return RetrofitClient.getClient(BASE_URL_API).create(BaseApiService.class);


    }
}
