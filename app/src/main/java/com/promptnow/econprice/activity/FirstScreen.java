package com.promptnow.econprice.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.econprice.R;

/**
 * Created by Acer on 31/8/2559.
 */

public class FirstScreen extends Fragment {
    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_first_screen, container, false);


        setView();

        return rootView;
    }

    private void setView() {

        ImageView image = (ImageView) rootView.findViewById(R.id.imageView);
        image.setImageResource(R.drawable.deer_);

        TextView btnClick = (TextView) rootView.findViewById(R.id.tv_guide);
        btnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                new MyPagerAdapter(getActivity().getSupportFragmentManager()).getItem(1);

                ((MainActivity) getActivity()).setSelect(1);
            }
        });


        Button btnClickSKIP = (Button) rootView.findViewById(R.id.skip);
        btnClickSKIP.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                ((MainActivity) getActivity()).setSelect(5);
            }
        });


    }

}

//