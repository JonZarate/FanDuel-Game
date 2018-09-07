package com.jonzarate.fanduelgame.data.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "player")
public class Player {

    @PrimaryKey
    @ColumnInfo(name = "id")
    @NonNull
    @Expose
    public String id;

    @ColumnInfo(name = "first_name")
    @SerializedName("first_name")
    @Expose
    public String firstName;

    @ColumnInfo(name = "fppg")
    @SerializedName("fppg")
    @Expose
    public float fppg;

    @ColumnInfo(name = "imageUrl")
    public String imageUrl;

    @Ignore
    @SerializedName("images")
    @Expose
    public PlayerImages images;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public float getFppg() {
        return fppg;
    }

    public void setFppg(float fppg) {
        this.fppg = fppg;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public PlayerImages getImages() {
        return images;
    }

    public void setImages(PlayerImages images) {
        this.images = images;
    }
}
