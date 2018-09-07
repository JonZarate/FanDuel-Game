package com.jonzarate.fanduelgame.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerImages {

    @SerializedName("default")
    @Expose
    public PlayerImageUrl defaultImage;


    public PlayerImageUrl getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(PlayerImageUrl defaultImage) {
        this.defaultImage = defaultImage;
    }
}
