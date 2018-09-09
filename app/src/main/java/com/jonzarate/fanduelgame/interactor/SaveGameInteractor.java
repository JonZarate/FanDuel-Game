package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.callback.SaveGameCallbacks;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import javax.inject.Inject;

public class SaveGameInteractor extends BaseInteractor<SaveGameCallbacks> {

    private NbaRepository repo;
    private History history;

    @Inject
    SaveGameInteractor(MainThread main, WorkerThread worker, NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    public void setHistory(History history) {
        this.history = history;
    }

    @Override
    protected Object runInBackground() {
        repo.saveGame(history);
        return null;
    }

    @Override
    protected void runInMain(Object result, SaveGameCallbacks callback) {
        callback.onSaveGame();
    }
}
