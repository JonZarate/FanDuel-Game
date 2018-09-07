package com.jonzarate.fanduelgame.interactor;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import javax.inject.Inject;

public class GetPlayersLiveDataInteractor extends BaseInteractor<GetPlayersLiveDataCallbacks> {

    private NbaRepository repo;

    @Inject
    GetPlayersLiveDataInteractor(MainThread main, WorkerThread worker, NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    @Override
    protected Object runInBackground() {
        return repo.getPlayersLiveData();
    }

    @Override
    protected void runInMain(Object result, GetPlayersLiveDataCallbacks callback) {
        LiveData<Player> players = (LiveData<Player>) result;
        if (players != null) {
            callback.onGetPlayersObservable(players);
        } else {
            callback.onGetPlayersObservableError();
        }

    }
}
