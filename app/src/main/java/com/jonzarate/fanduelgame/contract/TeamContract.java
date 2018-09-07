package com.jonzarate.fanduelgame.contract;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.Team;

import java.util.List;

public interface TeamContract {

    interface Presenter {
        void loadTeamsLiveData();
    }

    interface View {
        void setTeamsLiveData(LiveData<List<Team>> teams);
    }

}
