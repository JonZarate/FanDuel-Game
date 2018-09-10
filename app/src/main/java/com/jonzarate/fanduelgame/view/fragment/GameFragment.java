package com.jonzarate.fanduelgame.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.jonzarate.fanduelgame.FanDuelApplication;
import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.contract.GameContract;
import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.di.component.DaggerGameComponent;
import com.jonzarate.fanduelgame.di.module.GameModule;
import com.jonzarate.fanduelgame.view.adapter.GameAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class GameFragment extends Fragment implements GameContract.View, GameAdapter.OnPlayerClickListener {

    @BindView(R.id.game_recycler)
    RecyclerView recycler;

    @BindView(R.id.game_next)
    Button next;

    @BindView(R.id.game_exit)
    Button exit;

    @Inject
    GameContract.Presenter presenter;

    private GameAdapter adapter;
    private boolean gameReady;

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

        gameReady = false;

        initializeRecycler();
        hideGameOptions();

        DaggerGameComponent.builder()
                .appComponent(((FanDuelApplication)getContext().getApplicationContext()).appComponent)
                .gameModule(new GameModule(this))
                .build()
                .inject(this);

        return view;
    }


    private void initializeRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        recycler.setLayoutManager(layoutManager);
        recycler.setAdapter(adapter = new GameAdapter(this));
    }

    @Override
    public void setGameData(History history) {
        gameReady = true;
        adapter.updateGame(history);
        adapter.setFppgVisible(false);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void setBorders(int positionSelected, int positionHighestFppgPlayer) {
        adapter.setFppgVisible(true);
        adapter.setBorders(positionSelected, positionHighestFppgPlayer);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showAfterGameOptions() {
        exit.setVisibility(View.VISIBLE);
        next.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideGameOptions() {
        exit.setVisibility(View.GONE);
        next.setVisibility(View.GONE);
    }

    @Override
    public void goBack() {
        getActivity().onBackPressed();
    }

    @OnClick({R.id.game_next, R.id.game_exit})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.game_next:
                presenter.onNextClick();
                break;

            case R.id.game_exit:
                presenter.onExitClick();
                break;
        }
    }

    @Override
    public void onPlayerClick(int position) {
        if (gameReady) {
            gameReady = false;
            presenter.onPlayerSelected(position);
        }
    }
}
