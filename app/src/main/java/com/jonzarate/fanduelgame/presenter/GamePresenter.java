package com.jonzarate.fanduelgame.presenter;

import com.jonzarate.fanduelgame.contract.GameContract;
import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.interactor.NewGameInteractor;
import com.jonzarate.fanduelgame.interactor.callback.NewGameCallbacks;

import javax.inject.Inject;

public class GamePresenter implements GameContract.Presenter, NewGameCallbacks {

    private GameContract.View view;
    private NewGameInteractor newGameInteractor;

    private History history;

    @Inject
    public GamePresenter(GameContract.View view, NewGameInteractor newGameInteractor) {
        this.view = view;
        this.newGameInteractor = newGameInteractor;

        onNextClick();
    }

    @Override
    public void onPlayerSelected(int position) {
        view.setBorders(position, history.getHigherFppgPlayer());
    }

    @Override
    public void onNextClick() {
        newGameInteractor.execute(this);
    }

    @Override
    public void onExitClick() {
        view.goBack();
    }

    @Override
    public void onNewGame(History history) {
        this.history = history;
        view.setGameData(history);
    }

    @Override
    public void onNewGameError() {
        view.goBack();
    }
}
