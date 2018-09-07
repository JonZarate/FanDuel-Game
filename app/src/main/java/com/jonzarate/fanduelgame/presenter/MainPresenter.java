package com.jonzarate.fanduelgame.presenter;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.contract.MainContract;
import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.interactor.GetPlayersLiveDataCallbacks;
import com.jonzarate.fanduelgame.interactor.GetPlayersLiveDataInteractor;
import com.jonzarate.fanduelgame.interactor.LoadNbaDataCallbacks;
import com.jonzarate.fanduelgame.interactor.LoadNbaDataInteractor;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter, LoadNbaDataCallbacks, GetPlayersLiveDataCallbacks {

    private MainContract.View view;
    private LoadNbaDataInteractor loadNbaDataInteractor;
    private GetPlayersLiveDataInteractor getPlayersLiveDataInteractor;

    @Inject
    public MainPresenter(MainContract.View view,
                         LoadNbaDataInteractor loadNbaDataInteractor,
                         GetPlayersLiveDataInteractor getPlayersLiveDataInteractor){
        this.view = view;
        this.loadNbaDataInteractor = loadNbaDataInteractor;
        this.getPlayersLiveDataInteractor = getPlayersLiveDataInteractor;
    }

    @Override
    public void loadNbaData() {
        loadNbaDataInteractor.execute(this);
        view.displayToast("loading");
    }

    @Override
    public void onFabClick() {
        view.displayToast("fab");
    }

    @Override
    public void onLoadNbaData(NbaData data) {
        view.displayToast("load nba data");
        getPlayersLiveDataInteractor.execute(this);
    }

    @Override
    public void onLoadNbaDataError() {
        view.displayToast("error nba data");
    }

    @Override
    public void onGetPlayersObservable(LiveData<Player> players) {
        view.displayToast("get players");
    }

    @Override
    public void onGetPlayersObservableError() {
        view.displayToast("error get players");
    }
}
