package com.jonzarate.fanduelgame.interactor;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.Team;
import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.callback.GetTeamsLiveDataCallbacks;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import java.util.List;

import javax.inject.Inject;

public class GetTeamsLiveDataInteractor extends BaseInteractor<GetTeamsLiveDataCallbacks> {

    private NbaRepository repo;

    @Inject
    public GetTeamsLiveDataInteractor(MainThread main, WorkerThread worker,
                                      NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    @Override
    protected Object runInBackground() {
        return repo.getTeamsLiveData();
    }

    @Override
    protected void runInMain(Object result, GetTeamsLiveDataCallbacks callback) {
        LiveData<List<Team>> teams = (LiveData<List<Team>>) result;
        if (teams != null) {
            callback.onGetTeamsLiveData(teams);
        } else {
            callback.onGetTeamsError();
        }
     }
}
