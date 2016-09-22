package com.promptnow.econprice.fragment.lottery;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.econprice.R;

/**
 * Created by Acer on 30/8/2559.
 */

public class GuideLottery extends Fragment {
    private Typeface font;
    private TextView tv1, tv2;
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.guide_lottery, container, false);
        setView();

        return rootView;
    }

    private void setView() {
        tv1=(TextView) rootView.findViewById(R.id.tv_header_lotto);
        tv2=(TextView) rootView.findViewById(R.id.textView6);

//        เปลี่ยนfont
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv1.setTypeface(font);
        tv2.setTypeface(font);

        ImageView image = (ImageView) rootView.findViewById(R.id.lottory);
        image.setImageResource(R.drawable.ic_lottory);
    }

}




