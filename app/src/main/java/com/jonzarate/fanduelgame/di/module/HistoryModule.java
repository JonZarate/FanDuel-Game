package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.contract.HistoryContract;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.presenter.HistoryPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class HistoryModule {

    private HistoryContract.View view;

    public HistoryModule(HistoryContract.View view){
        this.view = view;
    }

    @Provides
    HistoryContract.View provideView() {
        return view;
    }

    @Provides @ActivityScope
    HistoryContract.Presenter providePresenter(HistoryPresenter presenter) {
        return presenter;
    }

}
