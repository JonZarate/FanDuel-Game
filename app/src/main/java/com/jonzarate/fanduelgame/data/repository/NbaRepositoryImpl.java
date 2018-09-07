package com.jonzarate.fanduelgame.data.repository;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.data.model.Team;
import com.jonzarate.fanduelgame.data.source.local.NbaDb;
import com.jonzarate.fanduelgame.data.source.net.FanDuelApi;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Response;

public class NbaRepositoryImpl implements NbaRepository {

    private FanDuelApi api;
    private NbaDb db;

    @Inject
    public NbaRepositoryImpl(FanDuelApi api, NbaDb db)
    {
        this.api = api;
        this.db = db;
    }

    @Override
    public NbaData downloadNbaData() {
        NbaData data = null;
        Response<NbaData> response = null;
        try {
            response = api.getNbaData().execute();
        } catch (IOException ignore) { }

        if (response.isSuccessful()) {
            data = response.body();

            saveNbaData(data);
        }

        return data;
    }

    @Override
    public void saveNbaData(NbaData data) {

        // Ease access to default image url
        for (Player p : data.players) {
            p.imageUrl = p.images.defaultImage.url;
        }

        db.playerDao().insertAll(data.players);
        db.teamDao().insertAll(data.teams);
    }

    @Override
    public LiveData<List<Player>> getPlayersLiveData() {
        return db.playerDao().getAll();
    }

    @Override
    public LiveData<List<Team>> getTeamsLiveData() {
        return db.teamDao().getAllLiveData();
    }
}
