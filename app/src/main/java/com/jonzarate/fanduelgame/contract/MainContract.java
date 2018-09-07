package com.jonzarate.fanduelgame.contract;

public interface MainContract {

    interface Presenter {
        void loadNbaData();
        void onFabClick();
    }

    interface View {
        void displayToast(String text);
    }
}
