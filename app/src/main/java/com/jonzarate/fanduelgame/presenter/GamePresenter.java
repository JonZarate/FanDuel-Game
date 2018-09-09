package com.jonzarate.fanduelgame.presenter;

import com.jonzarate.fanduelgame.contract.GameContract;
import com.jonzarate.fanduelgame.interactor.NewGameInteractor;

import javax.inject.Inject;

public class GamePresenter implements GameContract.Presenter {

    private GameContract.View view;
    private NewGameInteractor newGameInteractor;

    @Inject
    public GamePresenter(GameContract.View view, NewGameInteractor newGameInteractor) {
        this.view = view;
        this.newGameInteractor = newGameInteractor;
    }

    @Override
    public void onPlayerSelected(int position) {

    }

    @Override
    public void onNextClick() {

    }

    @Override
    public void onExitClick() {

    }
}
