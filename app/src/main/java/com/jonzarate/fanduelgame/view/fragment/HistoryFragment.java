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
import com.jonzarate.fanduelgame.contract.HistoryContract;
import com.jonzarate.fanduelgame.data.model.History;
import com.jonzarate.fanduelgame.di.component.DaggerHistoryComponent;
import com.jonzarate.fanduelgame.di.module.HistoryModule;
import com.jonzarate.fanduelgame.view.adapter.HistoryAdapter;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryFragment extends Fragment implements HistoryContract.View{

    @BindView(R.id.history_recycler)
    RecyclerView recycler;

    private HistoryAdapter adapter;

    public static HistoryFragment newInstance() {
        HistoryFragment fragment = new HistoryFragment();
        return fragment;
    }

    public HistoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        ButterKnife.bind(this, view);

        initializeRecycler();

        DaggerHistoryComponent.builder()
                .appComponent(((FanDuelApplication)getContext().getApplicationContext()).appComponent)
                .historyModule(new HistoryModule(this))
                .build()
                .inject(this);

        return view;
    }


    private void initializeRecycler() {
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                layoutManager.getOrientation());

        recycler.setLayoutManager(layoutManager);
        recycler.addItemDecoration(dividerItemDecoration);
        recycler.setAdapter(adapter = new HistoryAdapter());
    }

    @Override
    public void setHistoryLiveData(LiveData<List<History>> history) {
        history.observe(this, new Observer<List<History>>() {
            @Override
            public void onChanged(@Nullable List<History> history) {
                updateHistory(history);
            }
        });

        updateHistory(history.getValue());
    }

    private void updateHistory(List<History> history) {
        adapter.updateHistory(history);
        adapter.notifyDataSetChanged();
    }
}
