package com.jonzarate.fanduelgame.di.component;

import com.jonzarate.fanduelgame.di.module.PlayerModule;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.view.fragment.PlayerFragment;

import dagger.Component;

@ActivityScope
@Component(modules = PlayerModule.class, dependencies = AppComponent.class)
public interface PlayerComponent {
    void inject (PlayerFragment fragment);
}
