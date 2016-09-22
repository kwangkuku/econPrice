package com.promptnow.econprice.fragment.oil;

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
 * Created by Acer on 29/8/2559.
 */

public class GuideOilPrice extends Fragment {
    private Typeface font;
    private TextView tv1,tv2,tv3;
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.guide_oilprice, container, false);


        setView();

        return rootView;
    }

    private void setView() {
        tv1=(TextView) rootView.findViewById(R.id.tv_header_oil_price);
        tv2=(TextView) rootView.findViewById(R.id.textView3);
        tv3=(TextView) rootView.findViewById(R.id.textView4);

//        เปลี่ยนfont
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv1.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);

        ImageView image = (ImageView) rootView.findViewById(R.id.oil_price);
        image.setImageResource(R.drawable.ic_oilprice);

    }


}


