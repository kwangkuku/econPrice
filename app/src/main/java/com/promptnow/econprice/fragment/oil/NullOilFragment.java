package com.promptnow.econprice.fragment.oil;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.Fragment.OilFragment;
import com.promptnow.econprice.fragment.Fragment.OilFragment2;

import java.util.ArrayList;
import java.util.List;

public class NullOilFragment extends Fragment {
    private View rootView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
//    private void setToolbar() {
//
//            TextView tb=(TextView) rootView.findViewById(R.id.toolbar_title);
//            tb.setText("ตรวจสอบราคาน้ำมัน");
//
//
//    }




    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       rootView = inflater.inflate(R.layout.activity_stucture_oil, container, false);

        setView();
      //  setToolbar();
        return rootView;
    }

    private void setView() {
        TabLayout tabLayout;

        final ViewPager viewPager = (ViewPager) rootView.findViewById(R.id.viewpager);
        tabLayout = (TabLayout) rootView.findViewById(R.id.tabLayout);
        tabLayout.addTab(tabLayout.newTab().setText("ตรวจสอบราคาน้ำมัน"));
        tabLayout.addTab(tabLayout.newTab().setText("เปรียบเทียบราคาน้ำมัน"));
        viewPager.setAdapter(new SampleFragmentPagerAdapterOil(getChildFragmentManager(),
                getFragments()));
        tabLayout.setupWithViewPager(viewPager);
    }

    private List<Fragment> getFragments() {

        List<Fragment> fList = new ArrayList<Fragment>();


        fList.add(new OilFragment());

        fList.add(new OilFragment2());

        // fList.add(MyFragment.newInstance("Fragment 3"));


        return fList;


    }
}