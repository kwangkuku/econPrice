package com.promptnow.econprice.fragment.weather;

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

public class GuideWeather extends Fragment {
    private Typeface font;
    private TextView tv1,tv2,tv3;
    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.guide_weather, container, false);


        setView();

        return rootView;
    }

    private void setView() {
        tv1=(TextView)rootView.findViewById(R.id.color_blue_tv_header_weather);
        tv2=(TextView)rootView.findViewById(R.id.textView8);
        tv3=(TextView)rootView.findViewById(R.id.textView9);

//       เปลี่ยนfont
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv1.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);

        ImageView image = (ImageView) rootView.findViewById(R.id.weather);
        image.setImageResource(R.drawable.ic_weather);
    }

}
