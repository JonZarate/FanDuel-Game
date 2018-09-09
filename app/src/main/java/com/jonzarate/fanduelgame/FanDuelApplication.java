package com.jonzarate.fanduelgame;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.jonzarate.fanduelgame.data.source.local.NbaDb;
import com.jonzarate.fanduelgame.data.source.local.RoomSetup;
import com.jonzarate.fanduelgame.di.component.AppComponent;
import com.jonzarate.fanduelgame.di.component.DaggerAppComponent;
import com.jonzarate.fanduelgame.di.module.AppModule;

public class FanDuelApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        RoomSetup.init(this);

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();
    }
}
