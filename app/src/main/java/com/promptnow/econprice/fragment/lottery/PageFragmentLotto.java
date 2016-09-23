package com.promptnow.econprice.fragment.lottery;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.promptnow.econprice.R;

/**
 * Created by Whankung on 7/9/2559.
 */

public class PageFragmentLotto extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    private int mPage;
    private String tabTitles[] = {"ตรวจรางวัล", "เลขเด็ด"};


    public static PageFragmentLotto newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        PageFragmentLotto fragment = new PageFragmentLotto();
        fragment.setArguments(args);
        return fragment;

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPage = getArguments().getInt(ARG_PAGE);

    }

   // @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState,int position) {
       // View view = inflater.inflate(R.layout.checklottery, container, false);

       View view = inflater.inflate(R.layout.custom_tab, null);
        Typeface font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        TextView tv = (TextView) view.findViewById(R.id.textView);
        tv.setText(tabTitles[position]);
        tv.setTypeface(font);
        return view;
    }
}
