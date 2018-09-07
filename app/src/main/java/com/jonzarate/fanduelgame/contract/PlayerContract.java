package com.jonzarate.fanduelgame.contract;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.data.model.Team;

import java.util.List;

public interface PlayerContract {

    interface Presenter {
        void loadPlayersLiveData();
    }

    interface View {
        void setPlayersLiveData(LiveData<List<Player>> players);
    }

}
