package com.jonzarate.fanduelgame.data.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class NbaData {

    @SerializedName("players")
    @Expose
    public ArrayList<Player> players;

    @SerializedName("teams")
    @Expose
    public ArrayList<Team> teams;


    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<Player> players) {
        this.players = players;
    }

    public ArrayList<Team> getTeams() {
        return teams;
    }

    public void setTeams(ArrayList<Team> teams) {
        this.teams = teams;
    }
}
