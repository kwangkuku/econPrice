package com.promptnow.econprice.fragment.lottery;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.activity.MainActivity;

import java.util.List;

import static com.promptnow.econprice.R.id.tabLayout;

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

//
//
//
//    public View getTabView(int position) {
//        v = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
//        font = Typeface.createFromAsset(context.getAssets(), "tmedium.ttf");
//        TextView tv = (TextView) v.findViewById(R.id.textView);
//        tv.setText(tabTitles[position]);
//        tv.setTypeface(font);
//
////         Given you have a custom layout in `res/layout/custom_tab.xml` with a TextView and ImageView
//
//  return v;
//
//
//    }

    
}

