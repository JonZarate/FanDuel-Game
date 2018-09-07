package com.jonzarate.fanduelgame.presenter;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.contract.PlayerContract;
import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.interactor.GetPlayersLiveDataInteractor;
import com.jonzarate.fanduelgame.interactor.callback.GetPlayersLiveDataCallbacks;

import java.util.List;

import javax.inject.Inject;

public class PlayerPresenter implements PlayerContract.Presenter, GetPlayersLiveDataCallbacks{

    private PlayerContract.View view;
    private GetPlayersLiveDataInteractor getPlayersLiveDataInteractor;

    @Inject
    public PlayerPresenter(PlayerContract.View view,
                           GetPlayersLiveDataInteractor getPlayersLiveDataInteractor) {
        this.view = view;
        this.getPlayersLiveDataInteractor = getPlayersLiveDataInteractor;
    }

    @Override
    public void loadPlayersLiveData() {
        getPlayersLiveDataInteractor.execute(this);
    }

    @Override
    public void onGetPlayersObservable(LiveData<List<Player>> players) {
        view.setPlayersLiveData(players);
    }

    @Override
    public void onGetPlayersObservableError() {

    }
}
