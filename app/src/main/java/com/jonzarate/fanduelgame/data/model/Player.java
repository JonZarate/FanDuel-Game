package com.jonzarate.fanduelgame.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "player")
public class Player {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    public String firstName;

    @ColumnInfo(name = "fppg")
    public float fppg;

    @ColumnInfo(name = "image_url")
    public String imageUrl;

    @Ignore
    public PlayerImages images;
}
