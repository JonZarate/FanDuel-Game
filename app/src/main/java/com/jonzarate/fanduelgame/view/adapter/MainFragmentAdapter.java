package com.jonzarate.fanduelgame.view.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jonzarate.fanduelgame.R;
import com.jonzarate.fanduelgame.view.fragment.HistoryFragment;

public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private Fragment fragments[];

    public MainFragmentAdapter(Context context, FragmentManager fm) {
        super(fm);

        this.context = context;
        fragments = new Fragment[3];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return context.getString(R.string.tab_history);
            case 1:
                return context.getString(R.string.tab_players);
            case 2:
                return context.getString(R.string.tab_teams);
        }

        return super.getPageTitle(position);
    }

    @Override
    public Fragment getItem(int position) {
        if (fragments[position] == null)
            fragments[position] = HistoryFragment.newInstance();

        return fragments[position];
    }

    @Override
    public int getCount() {
        return fragments.length;
    }
}
