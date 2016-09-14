package com.promptnow.econprice.fragment.lottery;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.promptnow.econprice.R;

import java.util.ArrayList;
import java.util.List;

public class MainLotteryFragment extends android.support.v4.app.Fragment {
    private View rootView;

    // Fragment TabHost as mTabHost
    //private FragmentTabHost mTabHost;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceStat) {
        rootView = inflater.inflate(R.layout.activity_stucture_lottery, container, false);
        setView();
        // setToolbar();


        return rootView;
    }

//    private void setToolbar() {
//        TextView tb=(TextView) rootView.findViewById(R.id.toolbar_title);
//        tb.setText("ตรวจผลสลากกินแบ่งรัฐบาล");
//
//
//    }

    private void setView() {

        TabLayout tabLayout;


        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);

        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);


        tabLayout.addTab(tabLayout.newTab().setText("ตรวจรางวัล"));
        tabLayout.addTab(tabLayout.newTab().setText("เลขเด็ด"));


        viewPager.setAdapter(new SampleFragmentPagerAdapterLotto(getChildFragmentManager(),
                getFragments()));


        tabLayout.setupWithViewPager(viewPager);
    }

    private List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();


        fList.add(new LotteryFragment());

        fList.add(new LotteryFragment2());

        // fList.add(MyFragment.newInstance("Fragment 3"));


        return fList;

    }


}






























