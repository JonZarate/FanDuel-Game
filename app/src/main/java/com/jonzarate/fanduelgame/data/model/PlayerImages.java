package com.jonzarate.fanduelgame.data.model;

import com.google.gson.annotations.SerializedName;

public class PlayerImages {

    @SerializedName("default")
    private PlayerImageUrl defaultImage;

    public PlayerImageUrl getDefaultImage() {
        return defaultImage;
    }
}
