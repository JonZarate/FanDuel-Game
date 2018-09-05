package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.model.NbaData;

public interface GetNbaDataCallbacks extends BaseCallbacks {

    void onGetData(NbaData data);
    void onError();

}
