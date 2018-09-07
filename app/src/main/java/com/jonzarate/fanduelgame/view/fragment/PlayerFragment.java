package com.jonzarate.fanduelgame.view.fragment;


import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonzarate.fanduelgame.FanDuelApplication;
import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.contract.PlayerContract;
import com.jonzarate.fanduelgame.data.model.Player;
import com.jonzarate.fanduelgame.di.component.DaggerPlayerComponent;
import com.jonzarate.fanduelgame.di.module.PlayerModule;
import com.jonzarate.fanduelgame.view.adapter.PlayerAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class PlayerFragment extends Fragment implements PlayerContract.View {

    @BindView(R.id.player_recycler)
    RecyclerView recycler;

    @Inject
    PlayerContract.Presenter presenter;

    private PlayerAdapter adapter;

    public static PlayerFragment newInstance() {
        PlayerFragment fragment = new PlayerFragment();
        return fragment;
    }

    public PlayerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_player, container, false);

        ButterKnife.bind(this, view);


        initializeRecycler();

        DaggerPlayerComponent.builder()
                .appComponent(((FanDuelApplication) getContext().getApplicationContext()).appComponent)
                .playerModule(new PlayerModule(this))
                .build()
                .inject(this);

        presenter.loadPlayersLiveData();

        return view;
    }

    private void initializeRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                layoutManager.getOrientation());

        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(dividerItemDecoration);
        recycler.setAdapter(adapter = new PlayerAdapter());
    }

    @Override
    public void setPlayersLiveData(LiveData<List<Player>> players) {
        players.observe(this, new Observer<List<Player>>() {
            @Override
            public void onChanged(@Nullable List<Player> players) {
                updatePlayers(players);
            }
        });

        updatePlayers(players.getValue());
    }

    private void updatePlayers(List<Player> players) {
        adapter.updatePlayer(players);
        adapter.notifyDataSetChanged();
    }

}
