package com.promptnow.econprice.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;

import com.promptnow.econprice.R;
import com.promptnow.econprice.adapter.MyPagerAdapter;
import com.viewpagerindicator.CirclePageIndicator;


public class MainActivity extends FragmentActivity {
    ViewPager pager;
    MyPagerAdapter adapter;
    CirclePageIndicator indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        //TH sarabran
        //Typeface myTypeface = Typeface.createFromAsset(getAssets(),"THSarabunNew.ttf");
        //TextView myTextView = (TextView)findViewById(R.id.textView2);
        //myTextView.setTypeface(myTypeface);

        adapter = new MyPagerAdapter(getSupportFragmentManager());

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);


        indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        indicator.setViewPager(pager);


//      pager = (ViewPager) findViewById(R.id.indicator);
        //      pager.setAdapter(adapter);


    }


    public void setSelect(int position) {
        pager.setCurrentItem(position);
    }


}







