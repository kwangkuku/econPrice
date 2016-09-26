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


    public static void applyFontedTab(Context activity, ViewPager viewPager, TabLayout tabLayout) {


        Typeface font =Typeface.createFromAsset(activity.getAssets(), "tmedium.ttf");
        for (int i = 0; i < viewPager.getAdapter().getCount(); i++) {
           View v = LayoutInflater.from(activity).inflate(R.layout.custom_tab, null);
            TextView tv = (TextView) v.findViewById(R.id.textView);

         //   TextView tv = (TextView) activity.getLayoutInflater().inflate(R.layout.custom_tab, null);
            if (i == viewPager.getCurrentItem()) tv.setSelected(true);
            tv.setText(viewPager.getAdapter().getPageTitle(i));
            tabLayout.getTabAt(i).setCustomView(tv);
            tv.setTypeface(font);


        }


    }


    /**
     * Created by Whankung on 22/9/2559.
     */

    public static class CustomTabLayout extends BaseAdapter {
        private Typeface font;
    //    public CustomTabLayout(Context context) {
    //        super(context);
    //    }
    //
    //    public CustomTabLayout(Context context, String[] attrs) {
    //        super(context, attrs);
    //    }
    //
    //    public CustomTabLayout(Context context, AttributeSet attrs, int defStyleAttr) {
    //        super(context, attrs, defStyleAttr);
    //    }
    //
    //
    //    public void setTabsFromPagerAdapter(@NonNull PagerAdapter adapter) {
    //        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
    //
    //        this.removeAllTabs();
    //
    //        ViewGroup slidingTabStrip = (ViewGroup) getChildAt(0);
    //
    //        for (int i = 0, count = adapter.getCount(); i < count; i++) {
    //            Tab tab = this.newTab();
    //            this.addTab(tab.setText(adapter.getPageTitle(i)));
    //            AppCompatTextView view = (AppCompatTextView) ((ViewGroup)slidingTabStrip.getChildAt(i)).getChildAt(1);
    //            view.setTypeface(font, Typeface.NORMAL);
    //
    //        }
    //
    //    }
    //    @Override
    //    public void setupWithViewPager(ViewPager viewPager)
    //    {
    //        super.setupWithViewPager(viewPager);
    //
    //        if (font != null)
    //        {
    //            this.removeAllTabs();
    //
    //            ViewGroup slidingTabStrip = (ViewGroup) getChildAt(0);
    //
    //            PagerAdapter adapter = viewPager.getAdapter();
    //
    //            for (int i = 0, count = adapter.getCount(); i < count; i++)
    //            {
    //                Tab tab = this.newTab();
    //                this.addTab(tab.setText(adapter.getPageTitle(i)));
    //                AppCompatTextView view = (AppCompatTextView) ((ViewGroup) slidingTabStrip.getChildAt(i)).getChildAt(1);
    //                view.setTypeface(font, Typeface.NORMAL);
    //
    //
    //            }
    //        }
    //    }
    Context mContext;
        String[] List ;



        public CustomTabLayout(Context context, String[] strName) {
            this.mContext = context;
            this.List = strName;

        }

        public int getCount() {
            return List.length;
        }

        public Object getItem(int position) {


            return null;
        }


        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater inflater=
                    (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            view = inflater.inflate(R.layout.custom_tab, parent, false);



            TextView textView = (TextView) view.findViewById(R.id.textView);
            textView.setText(List[position]);


            font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");
            textView.setTypeface(font);


            View.OnClickListener yourClickListener = new View.OnClickListener() {
                public void onClick(View v) {
                    //put your desired action here

                }
            };

            return view;
        }

    }
}

