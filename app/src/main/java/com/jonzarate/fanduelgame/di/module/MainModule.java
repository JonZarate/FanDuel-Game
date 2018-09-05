package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.contract.MainContract;
import com.jonzarate.fanduelgame.presenter.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainModule {

    private MainContract.View view;

    public MainModule(MainContract.View view) {

    }

    @Provides
    MainContract.View provideView(){
        return view;
    }

    @Provides @Singleton
    MainContract.Presenter providePresenter(MainPresenter presenter) {
        return presenter;
    }

}
