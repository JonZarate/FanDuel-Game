package com.jonzarate.fanduelgame.presenter;

import com.jonzarate.fanduelgame.contract.MainContract;
import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.interactor.GetPlayersLiveDataInteractor;
import com.jonzarate.fanduelgame.interactor.callback.LoadNbaDataCallbacks;
import com.jonzarate.fanduelgame.interactor.LoadNbaDataInteractor;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter, LoadNbaDataCallbacks {

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
    }

    @Override
    public void onFabClick() {
        view.launchGame();
    }

    @Override
    public void onLoadNbaData(NbaData data) {
        ;
    }

    @Override
    public void onLoadNbaDataError() {

    }

}
