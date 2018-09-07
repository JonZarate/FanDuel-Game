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
import com.jonzarate.fanduelgame.contract.TeamContract;
import com.jonzarate.fanduelgame.data.model.Team;
import com.jonzarate.fanduelgame.data.source.net.FanDuelApi;
import com.jonzarate.fanduelgame.di.component.DaggerTeamComponent;
import com.jonzarate.fanduelgame.di.module.TeamModule;
import com.jonzarate.fanduelgame.view.adapter.TeamAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment implements TeamContract.View {

    @BindView(R.id.team_recycler)
    RecyclerView recycler;

    @Inject
    TeamContract.Presenter presenter;

    private TeamAdapter adapter;

    public static TeamFragment newInstance(){
        TeamFragment fragment = new TeamFragment();
        return fragment;
    }


    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_team, container, false);

        ButterKnife.bind(this, view);

        initializeRecycler();

        DaggerTeamComponent.builder()
                .appComponent(((FanDuelApplication) getContext().getApplicationContext()).appComponent)
                .teamModule(new TeamModule(this))
                .build()
                .inject(this);

        presenter.loadTeamsLiveData();

        return view;
    }

    private void initializeRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                layoutManager.getOrientation());

        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(dividerItemDecoration);
        recycler.setAdapter(adapter = new TeamAdapter());
    }

    @Override
    public void setTeamsLiveData(LiveData<List<Team>> teams) {
        teams.observe(this, new Observer<List<Team>>() {
            @Override
            public void onChanged(@Nullable List<Team> teams) {
                updateteams(teams);
            }
        });

        updateteams(teams.getValue());
    }

    private void updateteams(List<Team> teams) {
        adapter.updateTeams(teams);
        adapter.notifyDataSetChanged();
    }
}
