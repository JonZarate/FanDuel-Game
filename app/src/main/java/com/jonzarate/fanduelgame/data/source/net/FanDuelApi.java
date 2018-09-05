package com.jonzarate.fanduelgame.data.source.net;

import com.jonzarate.fanduelgame.data.model.*;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FanDuelApi {

    @GET("bb40ee8721f1a9313c22c6ea0851a105/raw/6b6fc89d55ebe4d9b05c1469349af33651d7e7f1/Player.json")
    Call<NbaData> getNbaData();

}
