package com.jonzarate.fanduelgame.data.repository;

import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.data.source.net.FanDuelApi;

import java.io.IOException;

import javax.inject.Inject;

import retrofit2.Response;

public class NbaRepositoryImpl implements NbaRepository {


    private FanDuelApi api;

    @Inject
    public NbaRepositoryImpl(FanDuelApi api)
    {
        this.api = api;
    }

    @Override
    public NbaData getNbaData() {
        try {
            Response<NbaData> response = api.getNbaData().execute();
            if (response.isSuccessful())
                return response.body();
        } catch (IOException ignore) { }
        return null;
    }
}
