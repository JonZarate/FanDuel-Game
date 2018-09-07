package com.jonzarate.fanduelgame.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PlayerImageUrl {

    @Expose
    @SerializedName("url")
    public String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
