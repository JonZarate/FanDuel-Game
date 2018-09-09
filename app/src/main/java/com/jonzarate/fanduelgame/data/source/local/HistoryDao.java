package com.jonzarate.fanduelgame.data.source.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.jonzarate.fanduelgame.data.model.History;

import java.util.List;

@Dao
public interface HistoryDao {

    @Query("SELECT * FROM history")
    LiveData<List<History>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(History history);

}
