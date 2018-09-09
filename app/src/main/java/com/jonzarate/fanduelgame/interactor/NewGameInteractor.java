package com.jonzarate.fanduelgame.interactor;

import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.data.repository.NbaRepository;
import com.jonzarate.fanduelgame.interactor.callback.NewGameCallbacks;
import com.jonzarate.fanduelgame.interactor.threading.MainThread;
import com.jonzarate.fanduelgame.interactor.threading.WorkerThread;

import java.util.List;
import java.util.Random;

import javax.inject.Inject;

public class NewGameInteractor extends BaseInteractor<NewGameCallbacks> {

    private NbaRepository repo;

    @Inject
    NewGameInteractor(MainThread main, WorkerThread worker, NbaRepository repo) {
        super(main, worker);
        this.repo = repo;
    }

    @Override
    protected Object runInBackground() {
        List<Player> players = repo.getPlayers();

        Random random = new Random();

        Player p0 = players.get(random.nextInt(players.size()));
        Player p1 = players.get(random.nextInt(players.size()));
        Player p2 = players.get(random.nextInt(players.size()));
        Player p3 = players.get(random.nextInt(players.size()));

        History history = new History();
        copyPlayers(history, p0, p1, p2, p3);

        setWinner(history, p0, p1, p2, p3);

        return history;
    }

    private void copyPlayers(History history, Player p0, Player p1, Player p2, Player p3) {
        history.setName0(p0.getFirstName());
        history.setFppg0(p0.getFppg());
        history.setImg0(p0.getImageUrl());
        history.setName1(p1.getFirstName());
        history.setFppg1(p1.getFppg());
        history.setImg1(p1.getImageUrl());
        history.setName2(p2.getFirstName());
        history.setFppg2(p2.getFppg());
        history.setImg2(p2.getImageUrl());
        history.setName3(p3.getFirstName());
        history.setFppg3(p3.getFppg());
        history.setImg3(p3.getImageUrl());
    }

    private void setWinner(History history, Player p0, Player p1, Player p2, Player p3) {
        float nums[] = {p0.getFppg(), p1.getFppg(), p2.getFppg(), p3.getFppg()};

        int highestPlayerIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[highestPlayerIndex])
                highestPlayerIndex = i;
        }

        history.setHigherFppgPlayer(highestPlayerIndex);
    }

    @Override
    protected void runInMain(Object result, NewGameCallbacks callback) {
        History history = (History) result;
        if (history != null) {
            callback.onNewGame(history);
        } else {
            callback.onNewGameError();
        }
    }
}
