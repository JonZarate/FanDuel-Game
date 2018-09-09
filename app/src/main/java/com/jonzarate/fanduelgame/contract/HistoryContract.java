package com.jonzarate.fanduelgame.contract;

import android.arch.lifecycle.LiveData;

import com.jonzarate.fanduelgame.data.model.History;

import java.util.List;

public interface HistoryContract {

    interface Presenter {
        void loadHistoryLiveData();
    }

    interface View {
        void setHistoryLiveData(LiveData<List<History>> players);
    }
}
