package com.jonzarate.fanduelgame.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.data.model.Team;

@Database(entities = {Player.class, Team.class}, exportSchema = false, version = 1)
public abstract class NbaDb extends RoomDatabase {
    public abstract PlayerDao playerDao();
}
