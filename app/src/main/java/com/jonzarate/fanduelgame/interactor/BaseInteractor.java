package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.interactor.callback.BaseCallbacks;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

public abstract class BaseInteractor<T extends BaseCallbacks> {

    private MainThread main;
    private WorkerThread worker;

    BaseInteractor(MainThread main, WorkerThread worker) {
        this.main = main;
        this.worker = worker;
    }

    protected abstract Object runInBackground();
    protected abstract void runInMain(Object result, T callback);

    public void execute(final T callback) {
        worker.submit(new Runnable() {
            @Override
            public void run() {
                final Object result = BaseInteractor.this.runInBackground();

                main.post(new Runnable() {
                    @Override
                    public void run() {
                        BaseInteractor.this.runInMain(result, callback);
                    }
                });
            }
        });
    }
}
