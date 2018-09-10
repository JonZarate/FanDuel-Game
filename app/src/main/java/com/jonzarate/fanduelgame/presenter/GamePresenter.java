package com.jonzarate.fanduelgame.presenter;

import com.jonzarate.fanduelgame.contract.GameContract;
import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.interactor.NewGameInteractor;
import com.jonzarate.fanduelgame.interactor.SaveGameInteractor;
import com.jonzarate.fanduelgame.interactor.callback.NewGameCallbacks;
import com.jonzarate.fanduelgame.interactor.callback.SaveGameCallbacks;

import javax.inject.Inject;

public class GamePresenter implements GameContract.Presenter, NewGameCallbacks, SaveGameCallbacks {

    private GameContract.View view;
    private NewGameInteractor newGameInteractor;
    private SaveGameInteractor saveGameInteractor;

    private History history;

    @Inject
    public GamePresenter(GameContract.View view, NewGameInteractor newGameInteractor, SaveGameInteractor saveGameInteractor) {
        this.view = view;
        this.newGameInteractor = newGameInteractor;
        this.saveGameInteractor = saveGameInteractor;

        onNextClick();
    }

    @Override
    public void onPlayerSelected(int position) {
        history.setUserChoice(position);
        saveGameInteractor.setHistory(history);
        saveGameInteractor.execute(this);

        view.setBorders(position, history.getHigherFppgPlayer());
        view.showAfterGameOptions();
    }

    @Override
    public void onNextClick() {
        newGameInteractor.execute(this);
        view.hideGameOptions();
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

    @Override
    public void onSaveGame() {

    }

    @Override
    public void onSaveGameError() {

    }
}
