package com.jonzarate.fanduelgame.data.repository;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.data.model.Player;

import java.util.List;

public interface NbaRepository {

    NbaData downloadNbaData();

    void saveNbaData(NbaData data);


    LiveData<List<Player>> getPlayersLiveData();

}
