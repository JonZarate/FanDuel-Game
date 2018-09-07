package com.jonzarate.fanduelgame.data.source.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.data.model.PlayerTeam;

import java.util.List;

@Dao
public interface PlayerDao {

    @Query("SELECT player.first_name AS playerName, player.fppg AS fppg, team.id AS teamName" +
            " FROM player, team" +
            " WHERE player.id = team.id")
    LiveData<List<PlayerTeam>> getPlayerTeam();

    @Query("SELECT * FROM player")
    LiveData<List<Player>> getAll();


    @Insert
    void insertAll(List<Player> players);
}
