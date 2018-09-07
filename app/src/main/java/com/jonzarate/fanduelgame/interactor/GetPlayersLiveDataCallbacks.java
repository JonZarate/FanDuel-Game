package com.jonzarate.fanduelgame.interactor;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.Player;

public interface GetPlayersLiveDataCallbacks extends BaseCallbacks {

    void onGetPlayersObservable(LiveData<Player> players);
    void onGetPlayersObservableError();

}
