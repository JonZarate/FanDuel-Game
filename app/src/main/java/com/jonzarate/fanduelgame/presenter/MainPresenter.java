package com.jonzarate.fanduelgame.presenter;

import com.jonzarate.fanduelgame.contract.MainContract;
import com.jonzarate.fanduelgame.data.model.NbaData;
import com.jonzarate.fanduelgame.interactor.GetNbaDataCallbacks;
import com.jonzarate.fanduelgame.interactor.GetNbaDataInteractor;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter, GetNbaDataCallbacks{

    private MainContract.View view;
    private GetNbaDataInteractor getNbaDataInteractor;

    @Inject
    public MainPresenter(MainContract.View view, GetNbaDataInteractor getNbaDataInteractor){
        this.view = view;
        this.getNbaDataInteractor = getNbaDataInteractor;
    }

    @Override
    public void loadNbaData() {
        getNbaDataInteractor.execute(this);
    }

    @Override
    public void onFabClick() {

    }

    @Override
    public void onGetData(NbaData data) {

    }

    @Override
    public void onError() {

    }
}
