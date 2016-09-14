package com.promptnow.econprice.fragment.lottery;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.promptnow.econprice.R;

/**
 * Created by Acer on 30/8/2559.
 */

public class GuideLotteryActivity extends Fragment {

    private View rootView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_guide_lottery, container, false);


        setView();

        return rootView;
    }

    private void setView() {

        ImageView image = (ImageView) rootView.findViewById(R.id.imageView3);
        image.setImageResource(R.drawable.lottery);
    }

}




