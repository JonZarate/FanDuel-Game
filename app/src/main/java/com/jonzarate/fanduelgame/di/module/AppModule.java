package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.threading.MainThread;
import com.jonzarate.fanduelgame.threading.WorkerThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides @Singleton
    MainThread provideMainThread(MainThread main){
        return main;
    }

    @Provides @Singleton
    WorkerThread provideWorkerThread(WorkerThread worker) {
        return worker;
    }

}
