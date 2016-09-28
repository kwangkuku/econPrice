package com.promptnow.econprice.fragment.lottery;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.List;

/**
 * Created by Whankung on 7/9/2559.
 */

public class SampleFragmentPagerAdapterLotto extends FragmentPagerAdapter {
    private Typeface font;
    final int PAGE_COUNT = 2;
    private String tabTitles[] = {"ตรวจรางวัล", "เลขเด็ด"};
    private List<Fragment> fragments;
    private View v;
    private Context context;


    public SampleFragmentPagerAdapterLotto(FragmentManager fm, List<Fragment> fragments) {

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

// เปลี่ยน font tab
    public static void applyFontedTab(Context activity, ViewPager viewPager, TabLayout tabLayout) {
        Typeface font =Typeface.createFromAsset(activity.getAssets(), "tmedium.ttf");
        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
           View v = LayoutInflater.from(activity).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) v.findViewById(R.id.textView);
            if (i == viewPager.getCurrentItem()) tv.setSelected(true);
            tv.setText(viewPager.getAdapter().getPageTitle(i));
            tabLayout.getTabAt(i).setCustomView(tv);
            tv.setTypeface(font);
        }
    }
}

