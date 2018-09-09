package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.contract.GameContract;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.presenter.GamePresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class GameModule {

    private GameContract.View view;

    public GameModule(GameContract.View view){
        this.view = view;
    }

    @Provides
    GameContract.View provideView() {
        return view;
    }

    @Provides @ActivityScope
    GameContract.Presenter providePresenter(GamePresenter presenter) {
        return presenter;
    }

}
