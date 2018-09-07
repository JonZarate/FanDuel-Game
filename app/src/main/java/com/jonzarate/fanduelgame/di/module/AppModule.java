package com.jonzarate.fanduelgame.di.module;

import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.data.repository.NbaRepositoryImpl;
import com.jonzarate.fanduelgame.data.source.local.NbaDb;
import com.jonzarate.fanduelgame.data.source.local.RoomSetup;
import com.jonzarate.fanduelgame.data.source.net.FanDuelApi;
import com.jonzarate.fanduelgame.data.source.net.RetrofitSetup;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

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

    @Provides @Singleton
    FanDuelApi provideFanDuelApi() {
        return RetrofitSetup.api;
    }

    @Provides @Singleton
    NbaDb provideNbaDb() {
        return RoomSetup.nbaDb;
    }

    @Provides @Singleton
    NbaRepository provideNbaRepository(NbaRepositoryImpl repo) {
        return repo;
    }

}
