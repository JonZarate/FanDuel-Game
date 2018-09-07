package com.jonzarate.fanduelgame.presenter;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.contract.TeamContract;
import com.jonzarate.fanduelgame.data.model.Team;
import com.jonzarate.fanduelgame.interactor.GetTeamsLiveDataInteractor;
import com.jonzarate.fanduelgame.interactor.callback.GetTeamsLiveDataCallbacks;

import java.util.List;

import javax.inject.Inject;

public class TeamPresenter implements TeamContract.Presenter, GetTeamsLiveDataCallbacks {

    private TeamContract.View view;
    private GetTeamsLiveDataInteractor getTeamsLiveDataInteractor;

    @Inject
    public TeamPresenter (TeamContract.View view, GetTeamsLiveDataInteractor getTeamsLiveDataInteractor) {
        this.view = view;
        this.getTeamsLiveDataInteractor = getTeamsLiveDataInteractor;
    }


    @Override
    public void loadTeamsLiveData() {
        getTeamsLiveDataInteractor.execute(this);
    }

    @Override
    public void onGetTeamsLiveData(LiveData<List<Team>> teams) {
        view.setTeamsLiveData(teams);
    }

    @Override
    public void onGetTeamsError() {

    }
}
