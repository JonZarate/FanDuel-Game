package com.jonzarate.fanduelgame.di.component;

import com.jonzarate.fanduelgame.di.module.AppModule;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import dagger.Component;

@Component(modules = AppModule.class)
public interface AppComponent {

    MainThread mainThread();
    WorkerThread workerThread();

}
