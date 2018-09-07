package com.jonzarate.fanduelgame.interactor.callback;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.Player;

import java.util.List;

public interface GetPlayersLiveDataCallbacks extends BaseCallbacks {

    void onGetPlayersObservable(LiveData<List<Player>> players);
    void onGetPlayersObservableError();

}
