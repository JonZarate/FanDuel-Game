package com.jonzarate.fanduelgame.interactor.callback;

import com.jonzarate.fanduelgame.data.model.History;

public interface NewGameCallbacks extends BaseCallbacks {
    void onNewGame(History history);
    void onNewGameError();
}
