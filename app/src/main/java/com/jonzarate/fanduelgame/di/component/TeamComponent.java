package com.jonzarate.fanduelgame.di.component;

import com.jonzarate.fanduelgame.di.module.TeamModule;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.view.fragment.TeamFragment;

import dagger.Component;

@ActivityScope
@Component(modules = TeamModule.class, dependencies = AppComponent.class)
public interface TeamComponent {
    void inject(TeamFragment view);
}
