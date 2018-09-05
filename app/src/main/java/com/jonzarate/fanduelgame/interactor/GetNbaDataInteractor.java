package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import javax.inject.Inject;

public class GetNbaDataInteractor extends BaseInteractor<GetNbaDataCallbacks> {

    private NbaRepository repo;

    @Inject
    protected GetNbaDataInteractor(MainThread main, WorkerThread worker,
                                   NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    @Override
    protected Object runInBackground() {
        return repo.getNbaData();
    }

    @Override
    protected void runInMain(Object result, GetNbaDataCallbacks callback) {
        NbaData data = (NbaData) result;
        if (data != null)
            callback.onGetData(data);
        else
            callback.onError();
    }
}
