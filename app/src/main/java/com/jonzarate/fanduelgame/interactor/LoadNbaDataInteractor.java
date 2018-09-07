package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import javax.inject.Inject;

public class LoadNbaDataInteractor extends BaseInteractor<LoadNbaDataCallbacks> {

    private NbaRepository repo;

    @Inject
    protected LoadNbaDataInteractor(MainThread main, WorkerThread worker,
                                    NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    @Override
    protected Object runInBackground() {
        return repo.downloadNbaData();
    }

    @Override
    protected void runInMain(Object result, LoadNbaDataCallbacks callback) {
        NbaData data = (NbaData) result;
        if (data != null)
            callback.onLoadNbaData(data);
        else
            callback.onLoadNbaDataError();
    }
}
