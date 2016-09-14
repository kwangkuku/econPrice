package com.promptnow.econprice.fragment.oil;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Whankung on 7/9/2559.
 */

public class SampleFragmentPagerAdapterOil extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[] {"ตรวจสอบราคาน้ำมัน","เปรียบเทียบราคาน้ำมัน" };
    private Context context;

    private List<Fragment> fragments;


    public SampleFragmentPagerAdapterOil(FragmentManager fm, List<Fragment> fragments) {

        super(fm);

        this.fragments = fragments;

    }

    @Override

    public Fragment getItem(int position) {

        return this.fragments.get(position);

    }


    @Override

    public int getCount() {

        return this.fragments.size();

    }
    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}

