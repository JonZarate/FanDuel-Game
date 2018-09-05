package com.jonzarate.fanduelgame.view.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.contract.MainContract;

import javax.inject.Inject;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

    @Inject
    MainContract.Presenter presenter;

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

        return view;
    }

}
