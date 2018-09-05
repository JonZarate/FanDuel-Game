package com.jonzarate.fanduelgame.view.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.jonzarate.fanduelgame.view.fragment.HistoryFragment;

public class MainFragmentAdapter extends FragmentStatePagerAdapter {

    private Fragment fragments[];

    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);

        fragments = new Fragment[3];
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "0";
            case 1:
                return "1";
            case 2:
                return "2";
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
