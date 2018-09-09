package com.jonzarate.fanduelgame.di.component;

import com.jonzarate.fanduelgame.di.module.HistoryModule;
import com.jonzarate.fanduelgame.di.scope.ActivityScope;
import com.jonzarate.fanduelgame.view.fragment.HistoryFragment;

import dagger.Component;

@ActivityScope
@Component(modules = HistoryModule.class, dependencies = AppComponent.class)
public interface HistoryComponent {
    void inject(HistoryFragment fragment);
}
