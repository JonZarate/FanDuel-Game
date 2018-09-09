package com.jonzarate.fanduelgame.data.source.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.data.model.PlayerTeam;

import java.util.List;

@Dao
public interface PlayerDao {

    @Query("SELECT * FROM player")
    LiveData<List<Player>> getAllLiveData();

    @Query("SELECT * FROM player")
    List<Player> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Player> players);
}
