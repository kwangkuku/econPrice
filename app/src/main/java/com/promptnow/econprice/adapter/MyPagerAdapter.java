package com.promptnow.econprice.adapter;

/**
 * Created by Acer on 31/8/2559.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.promptnow.econprice.activity.FirstScreen;
import com.promptnow.econprice.fragment.lottery.GuideLottery;
import com.promptnow.econprice.fragment.oil.GuideOilPrice;
import com.promptnow.econprice.fragment.startApp.StartAfterGuideActivity;
import com.promptnow.econprice.fragment.startApp.StartAppActivity;
import com.promptnow.econprice.fragment.weather.GuideWeather;

public  class MyPagerAdapter extends FragmentPagerAdapter {

    public MyPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public int getCount() {
        return 6;
    }

    public Fragment getItem(int position) {
        if(position == 0)
            return new FirstScreen();
        else if(position == 1)
            return new GuideOilPrice();
        else if(position == 2)
            return new GuideLottery();
        else if(position == 3)
            return new GuideWeather();
        else if(position == 4)
            return new StartAfterGuideActivity();
        else if(position == 5)
            return new StartAppActivity();
        return null;
    }
}


