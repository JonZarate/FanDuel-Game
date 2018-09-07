package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.contract.TeamContract;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.presenter.TeamPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class TeamModule {

    private TeamContract.View view;

    public TeamModule(TeamContract.View view) {
        this.view = view;
    }

    @Provides
    TeamContract.View provideView() {
        return view;
    }

    @Provides @ActivityScope
    TeamContract.Presenter providePresenter(TeamPresenter presenter) {
        return presenter;
    }

}
