package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.model.NbaData;

public interface LoadNbaDataCallbacks extends BaseCallbacks {

    void onLoadNbaData(NbaData data);
    void onLoadNbaDataError();

}
