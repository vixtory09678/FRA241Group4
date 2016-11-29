package com.example.fragment.manager;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.example.fragment.fragment.FourthFragment;
import com.example.fragment.fragment.MainFragment;
import com.example.fragment.fragment.SecondFragment;
import com.example.fragment.fragment.ThirdFragment;

/**
 * Created by Palmkongkiet on 11/27/2016.
 */

public class PagerViewAdapter extends FragmentPagerAdapter {
    public PagerViewAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                Log.w("check fragment","FourthFragment");
                return FourthFragment.newInstance();
            case 1:
                Log.w("check fragment","MainFragment");
                return MainFragment.newInstance(123);
            case 2:
                Log.w("check fragment","ThirdFragment");
                return ThirdFragment.newInstance();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
