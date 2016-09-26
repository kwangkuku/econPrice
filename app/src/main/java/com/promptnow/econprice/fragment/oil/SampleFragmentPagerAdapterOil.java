package com.promptnow.econprice.fragment.oil;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.List;

/**
 * Created by Whankung on 7/9/2559.
 */

public class SampleFragmentPagerAdapterOil extends FragmentPagerAdapter {
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"ตรวจสอบราคาน้ำมัน", "เปรียบเทียบราคาน้ำมัน"};
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

    public static void applyFontedTab(Context activity, ViewPager viewPager, TabLayout tabLayout) {


        Typeface font =Typeface.createFromAsset(activity.getAssets(), "tmedium.ttf");
        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
            View v = LayoutInflater.from(activity).inflate(R.layout.custom_tab_oil, null);
            TextView tv = (TextView) v.findViewById(R.id.textView);

            //   TextView tv = (TextView) activity.getLayoutInflater().inflate(R.layout.custom_tab, null);
            if (i == viewPager.getCurrentItem()) tv.setSelected(true);
            tv.setText(viewPager.getAdapter().getPageTitle(i));
            tabLayout.getTabAt(i).setCustomView(tv);
            tv.setTypeface(font);


        }


    }
}

