package com.jonzarate.fanduelgame.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import com.jonzarate.fanduelgame.data.model.Player;

import java.util.List;

@Dao
public interface PlayerDao {

    @Query("SELECT * FROM player")
    List<Player> getAll();

}
