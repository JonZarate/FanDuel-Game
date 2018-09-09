package com.jonzarate.fanduelgame.presenter;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.contract.HistoryContract;
import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.interactor.GetHistoryLiveDataInteractor;
import com.jonzarate.fanduelgame.interactor.callback.GetHistoryLiveDataCallbacks;

import java.util.List;

import javax.inject.Inject;

public class HistoryPresenter implements HistoryContract.Presenter , GetHistoryLiveDataCallbacks{

    private HistoryContract.View view;
    private GetHistoryLiveDataInteractor getHistoryLiveDataInteractor ;

    @Inject
    public HistoryPresenter(HistoryContract.View view, GetHistoryLiveDataInteractor getHistoryLiveDataInteractor) {
        this.view = view;
        this.getHistoryLiveDataInteractor = getHistoryLiveDataInteractor;
    }


    @Override
    public void loadHistoryLiveData() {
        getHistoryLiveDataInteractor.execute(this);
    }

    @Override
    public void onGetHistoryObservable(LiveData<List<History>> history) {
        view.setHistoryLiveData(history);
    }

    @Override
    public void onGetHistoryObservableError() {

    }
}
