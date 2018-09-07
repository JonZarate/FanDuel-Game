package com.jonzarate.fanduelgame.data.source.local;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.jonzarate.fanduelgame.data.model.Team;

import java.util.List;

@Dao
public interface TeamDao {

    @Query("SELECT * FROM team")
    LiveData<List<Team>> getAllLiveData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Team> teams);

}
