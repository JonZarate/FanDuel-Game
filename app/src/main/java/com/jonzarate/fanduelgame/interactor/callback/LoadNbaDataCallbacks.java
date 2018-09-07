package com.jonzarate.fanduelgame.interactor.callback;

import com.jonzarate.fanduelgame.data.model.NbaData;

public interface LoadNbaDataCallbacks extends BaseCallbacks {

    void onLoadNbaData(NbaData data);
    void onLoadNbaDataError();

}
