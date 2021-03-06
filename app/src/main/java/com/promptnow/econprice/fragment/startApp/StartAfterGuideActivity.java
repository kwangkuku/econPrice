package com.promptnow.econprice.fragment.startApp;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.activity.Menu;

/**
 * Created by Acer on 30/8/2559.
 */

public class StartAfterGuideActivity extends Fragment {
    private View rootView;
    private Typeface font;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_start_afterguide, container, false);
        setView();

        return rootView;
    }

    private void setView() {

        ImageView image = (ImageView) rootView.findViewById(R.id.imageView2);
        image.setImageResource(R.drawable.ic_tri);


        TextView ClickStart = (TextView) rootView.findViewById(R.id.textView9);
//        เปลี่ยนfont
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        ClickStart.setTypeface(font);
        ClickStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), Menu.class);
                startActivity(intent);
                getActivity().finish();



            }
        });

    }


}