package com.jonzarate.fanduelgame.contract;

import com.jonzarate.fanduelgame.data.model.History;

public interface GameContract {

    interface Presenter {
        void onPlayerSelected(int position);
        void onNextClick();
        void onExitClick();
    }


    interface View {
        void setGameData(History history);
        void setBorders(int positionSelected, int positionHighestFppgPlayer);
        void showAfterGameOptions();
        void hideGameOptions();
        void goBack();
    }

}
