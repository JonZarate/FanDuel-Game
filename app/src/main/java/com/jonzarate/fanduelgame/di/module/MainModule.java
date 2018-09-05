package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.contract.MainContract;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view) {
        this.view = view;
    }

    @Provides
    MainContract.View provideView(){
        return view;
    }

    @Provides @ActivityScope
    MainContract.Presenter providePresenter(MainPresenter presenter) {
        return presenter;
    }

}
