package com.jonzarate.fanduelgame.data.source.net;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonzarate.fanduelgame.BuildConfig;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitSetup {

    private static Gson gson = new GsonBuilder().create();

    public static FanDuelApi api =  new Retrofit.Builder()
            .baseUrl(BuildConfig.FANDUEL_API)
            .client(new OkHttpClient())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(FanDuelApi.class);

}
