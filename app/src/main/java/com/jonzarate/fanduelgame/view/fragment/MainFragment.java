package com.jonzarate.fanduelgame.view.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jonzarate.fanduelgame.FanDuelApplication;
import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.contract.MainContract;
import com.jonzarate.fanduelgame.di.component.DaggerMainComponent;
import com.jonzarate.fanduelgame.di.module.MainModule;
import com.jonzarate.fanduelgame.view.activity.GameActivity;
import com.jonzarate.fanduelgame.view.adapter.MainFragmentAdapter;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainContract.View {

    @BindView(R.id.main_pager)
    ViewPager pager;

    @BindView(R.id.main_tabs)
    TabLayout tabs;

    @Inject
    MainContract.Presenter presenter;

    private boolean started;

    public static MainFragment newInstance() {
        MainFragment fragment = new MainFragment();
        return fragment;
    }

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRetainInstance(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        ButterKnife.bind(this, view);

        DaggerMainComponent
                .builder()
                .appComponent(((FanDuelApplication)getContext().getApplicationContext()).appComponent)
                .mainModule(new MainModule(this))
                .build()
                .inject(this);

        // Avoid reloading data when rotating the phone
        if (!started) {
            started = true;
            presenter.loadNbaData();
        }

        setupView();

        return view;
    }

    private void setupView() {
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(new MainFragmentAdapter(getContext(), getFragmentManager()));
        tabs.setupWithViewPager(pager);
    }


    @OnClick(R.id.main_fab)
    public void onClick(){
        presenter.onFabClick();
    }

    @Override
    public void launchGame() {
        Intent intent = new Intent(getContext(), GameActivity.class);
        startActivity(intent);
    }
}
