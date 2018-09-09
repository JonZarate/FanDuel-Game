package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.callback.NewGameCallbacks;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import javax.inject.Inject;

public class NewGameInteractor extends BaseInteractor<NewGameCallbacks> {

    private NbaRepository repo;

    @Inject
    NewGameInteractor(MainThread main, WorkerThread worker, NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    @Override
    protected Object runInBackground() {
        return null;
    }

    @Override
    protected void runInMain(Object result, NewGameCallbacks callback) {

    }
}
