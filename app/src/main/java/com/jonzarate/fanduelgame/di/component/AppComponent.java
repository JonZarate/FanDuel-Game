package com.jonzarate.fanduelgame.di.component;

import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.data.source.net.FanDuelApi;
import com.jonzarate.fanduelgame.di.module.AppModule;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    NbaRepository nbaRepository();

}
