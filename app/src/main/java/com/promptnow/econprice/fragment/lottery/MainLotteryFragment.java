package com.promptnow.econprice.fragment.lottery;


import android.app.Activity;
import android.app.TabActivity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.ArrayList;
import java.util.List;

public class MainLotteryFragment extends android.support.v4.app.Fragment {
    private Typeface font;
    private View rootView;
    private TabLayout tabLayout;

    // Fragment TabHost as mTabHost
    //private FragmentTabHost mTabHost;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.stucture_lottery, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");

        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("ตรวจรางวัล"));
        tabLayout.addTab(tabLayout.newTab().setText("เลขเด็ด"));
        viewPager.setAdapter(new SampleFragmentPagerAdapterLotto(getChildFragmentManager(),
                getFragments()));
        tabLayout.setupWithViewPager(viewPager);

//        String[] List = {"ตรวจรางวัล", "เลขเด็ด"};
//        CustomTabLayout tab= new CustomTabLayout(getActivity(),List);


//        for (int i = 0; i < tabLayout.getTabCount(); i++) {
//            TabLayout.Tab tab = tabLayout.getTabAt(i);
//
//           tab.setCustomView(SampleFragmentPagerAdapterLotto.getTabView(i));
//        }
      //  SampleFragmentPagerAdapterLotto.applyFontedTab(MainLotteryFragment.this, viewPager, tabLayout);
      SampleFragmentPagerAdapterLotto.applyFontedTab(getActivity().getApplicationContext(),viewPager,tabLayout);

    }



    private List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();
        fList.add(new LotteryFragment());
        fList.add(new LotteryFragment2());
        return fList;
    }


}






























