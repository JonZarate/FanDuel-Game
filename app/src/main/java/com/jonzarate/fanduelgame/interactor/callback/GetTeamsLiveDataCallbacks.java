package com.jonzarate.fanduelgame.interactor.callback;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.Team;

import java.util.List;

public interface GetTeamsLiveDataCallbacks extends BaseCallbacks {
    void onGetTeamsLiveData(LiveData<List<Team>> teams);
    void onGetTeamsError();
}
