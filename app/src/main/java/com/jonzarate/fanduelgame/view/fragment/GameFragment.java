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
import android.widget.Button;

import com.jonzarate.fanduelgame.FanDuelApplication;
import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.contract.GameContract;
import com.jonzarate.fanduelgame.contract.HistoryContract;
import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.di.component.DaggerGameComponent;
import com.jonzarate.fanduelgame.di.component.DaggerHistoryComponent;
import com.jonzarate.fanduelgame.di.module.GameModule;
import com.jonzarate.fanduelgame.di.module.HistoryModule;
import com.jonzarate.fanduelgame.view.adapter.GameAdapter;
import com.jonzarate.fanduelgame.view.adapter.HistoryAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements GameContract.View {

    @BindView(R.id.game_recycler)
    RecyclerView recycler;

    @BindView(R.id.game_next)
    Button next;

    @BindView(R.id.game_exit)
    Button exit;

    @Inject
    GameContract.Presenter presenter;

    private GameAdapter adapter;

    public static GameFragment newInstance() {
        GameFragment fragment = new GameFragment();
        return fragment;
    }

    public GameFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_game, container, false);

        ButterKnife.bind(this, view);

        initializeRecycler();
        setButtonListeners();
        hideButtons();

        DaggerGameComponent.builder()
                .appComponent(((FanDuelApplication)getContext().getApplicationContext()).appComponent)
                .gameModule(new GameModule(this))
                .build()
                .inject(this);

        return view;
    }


    private void initializeRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                getContext(), LinearLayoutManager.HORIZONTAL, false);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(
                getContext(), layoutManager.getOrientation());

        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(dividerItemDecoration);
        recycler.setAdapter(adapter = new GameAdapter());
    }

    private void setButtonListeners() {
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onExitClick();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onNextClick();
            }
        });
    }

    private void hideButtons() {
        exit.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
    }

    @Override
    public void setGameData(History history) {
        adapter.updateGame(history);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setBorders(int positionSelected, int positionHighestFppgPlayer) {

    }

    @Override
    public void showAfterGameOptions() {
        exit.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
    }
}
