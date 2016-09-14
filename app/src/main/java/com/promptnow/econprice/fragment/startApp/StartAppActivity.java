package com.promptnow.econprice.fragment.startApp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.activity.Menu;

/**
 * Created by Acer on 30/8/2559.
 */

public class StartAppActivity extends Fragment{
    private View rootView;

    Handler handler;
    Runnable runnable;
    long delay_time;
    long time = 3000L;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();

        runnable = new Runnable() {
            public void run() {
                Intent intent = new Intent(getActivity(), Menu.class);
               startActivity(intent);
                getActivity().finish();

            }
        };
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_start, container, false);


        setView();

        return rootView;
    }

    private void setView() {

        ImageView image = (ImageView) rootView.findViewById(R.id.logoStart);
        image.setImageResource(R.drawable.deer);

    }
    public void onResume() {
        super.onResume();
        delay_time = time;
        handler.postDelayed(runnable, delay_time);
        time = System.currentTimeMillis();
    }

    public void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable);
        time = delay_time - (System.currentTimeMillis() - time);
    }
}

