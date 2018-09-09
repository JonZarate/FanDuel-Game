package com.jonzarate.fanduelgame.di.component;

import com.jonzarate.fanduelgame.di.module.GameModule;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.view.fragment.GameFragment;

import dagger.Component;

@ActivityScope
@Component(modules = GameModule.class, dependencies = AppComponent.class)
public interface GameComponent {
    void inject(GameFragment fragment);
}
