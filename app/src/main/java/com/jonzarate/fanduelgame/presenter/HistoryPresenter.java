package com.jonzarate.fanduelgame.presenter;

import com.jonzarate.fanduelgame.contract.HistoryContract;

import javax.inject.Inject;

public class HistoryPresenter implements HistoryContract.Presenter {

    private HistoryContract.View view;

    @Inject
    public HistoryPresenter(HistoryContract.View view) {
        this.view = view;
    }


    @Override
    public void loadHistoryLiveData() {

    }
}
