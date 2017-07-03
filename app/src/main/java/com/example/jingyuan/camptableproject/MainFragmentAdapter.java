package com.example.jingyuan.camptableproject;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by jingyuan on 01/07/17.
 */

public class MainFragmentAdapter extends FragmentPagerAdapter {
    public MainFragmentAdapter(FragmentManager fm){
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position){
            default:return new AddFragment();
            case 0: return new AddFragment();
            case 1: return new StatistiqueFragment();
            case 2: return new GraphFragment();
            case 3: return new SettingsFragment();

        }
    }

    @Override
    public int getCount() {
        return 4;
    }
}
