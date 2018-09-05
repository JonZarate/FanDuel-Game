package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import javax.inject.Inject;

public class GetNbaDataInteractor extends BaseInteractor<GetNbaDataCallbacks> {

    @Inject
    protected GetNbaDataInteractor(MainThread main, WorkerThread worker) {
        super(main, worker);
    }

    @Override
    protected Object runInBackground() {
        return null;
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
