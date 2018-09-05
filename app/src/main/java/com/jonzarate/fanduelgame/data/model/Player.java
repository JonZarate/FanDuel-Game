package com.jonzarate.fanduelgame.data.model;

import android.arch.persistence.room.Entity;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "player")
public class Player {

    @SerializedName("first_name")
    private String firstName;
    private float fppg;
    private PlayerImages images;

    public String getFirstName() {
        return firstName;
    }

    public float getFppg() {
        return fppg;
    }

    public PlayerImages getImages() {
        return images;
    }
}
