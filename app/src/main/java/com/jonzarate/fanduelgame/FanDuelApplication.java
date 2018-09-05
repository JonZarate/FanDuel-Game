package com.jonzarate.fanduelgame;

import android.app.Application;

import com.jonzarate.fanduelgame.di.component.AppComponent;
import com.jonzarate.fanduelgame.di.component.DaggerAppComponent;
import com.jonzarate.fanduelgame.di.module.AppModule;

public class FanDuelApplication extends Application {

    public AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent
                .builder()
                .appModule(new AppModule())
                .build();
    }
}
