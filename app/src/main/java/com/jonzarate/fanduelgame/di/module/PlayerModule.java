package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.contract.PlayerContract;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.presenter.PlayerPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class PlayerModule {

    private PlayerContract.View view;

    public PlayerModule(PlayerContract.View view) {
        this.view = view;
    }

    @Provides
    PlayerContract.View provideView() {
        return view;
    }

    @Provides @ActivityScope
    PlayerContract.Presenter providePresenter(PlayerPresenter presenter) {
        return presenter;
    }

}
