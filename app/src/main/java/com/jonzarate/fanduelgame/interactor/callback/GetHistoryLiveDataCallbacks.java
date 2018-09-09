package com.jonzarate.fanduelgame.interactor.callback;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.History;

import java.util.List;

public interface GetHistoryLiveDataCallbacks extends BaseCallbacks {
    void onGetHistoryObservable(LiveData<List<History>> history);
    void onGetHistoryObservableError();
}
