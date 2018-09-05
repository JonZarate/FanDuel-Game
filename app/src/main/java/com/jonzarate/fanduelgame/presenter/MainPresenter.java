package com.jonzarate.fanduelgame.presenter;

import com.jonzarate.fanduelgame.contract.MainContract;

import javax.inject.Inject;

public class MainPresenter implements MainContract.Presenter{


    private MainContract.View view;

    @Inject
    public MainPresenter(MainContract.View view){
        this.view = view;
    }

    @Override
    public void loadNbaData() {

    }

    @Override
    public void onFabClick() {

    }
}
