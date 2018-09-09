package com.jonzarate.fanduelgame.interactor.callback;

public interface SaveGameCallbacks extends BaseCallbacks {
    void onSaveGame();
    void onSaveGameError();
}
