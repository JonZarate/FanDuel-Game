package com.jonzarate.fanduelgame.di.component;

import com.jonzarate.fanduelgame.di.module.MainModule;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.view.fragment.MainFragment;

import dagger.Component;

@ActivityScope
@Component(modules = MainModule.class, dependencies = AppComponent.class)
public interface MainComponent {
    void inject (MainFragment fragment);
}
