package com.jonzarate.fanduelgame.interactor;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.callback.GetHistoryLiveDataCallbacks;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import java.util.List;

import javax.inject.Inject;

public class GetHistoryLiveDataInteractor extends BaseInteractor<GetHistoryLiveDataCallbacks> {

    private NbaRepository repo;

    @Inject
    GetHistoryLiveDataInteractor(MainThread main, WorkerThread worker, NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    @Override
    protected Object runInBackground() {
        return repo.getHistoryLiveData();
    }

    @Override
    protected void runInMain(Object result, GetHistoryLiveDataCallbacks callback) {
        LiveData<List<History>> history = (LiveData<List<History>>) result;
        if (result != null) {
            callback.onGetHistoryObservable(history);
        } else {
            callback.onGetHistoryObservableError();
        }
    }
}
