package com.promptnow.econprice.adapter;

/**
 * Created by Acer on 31/8/2559.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.promptnow.econprice.activity.FirstScreen;
import com.promptnow.econprice.fragment.lottery.GuideLotteryActivity;
import com.promptnow.econprice.fragment.oil.GuideOilPriceActivity;
import com.promptnow.econprice.fragment.startApp.StartAfterGuideActivity;
import com.promptnow.econprice.fragment.startApp.StartAppActivity;
import com.promptnow.econprice.fragment.weather.GuideWeatherActivity;

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
            return new GuideOilPriceActivity();
        else if(position == 2)
            return new GuideLotteryActivity();
        else if(position == 3)
            return new GuideWeatherActivity();
        else if(position == 4)
            return new StartAfterGuideActivity();
        else if(position == 5)
            return new StartAppActivity();
        return null;
    }
}


