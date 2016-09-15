package com.promptnow.econprice.fragment.lottery;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

import static com.promptnow.econprice.R.id.date;
import static com.promptnow.econprice.R.id.enterAlways;
import static com.promptnow.econprice.R.id.random;
import static com.promptnow.econprice.R.id.time;
import static com.promptnow.econprice.R.id.tv;

/**
 * Created by Whankung on 7/9/2559.
 */

public class LotteryFragment2 extends Fragment {
    private View rootView;
    private TextView tv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.checklottery_number, container, false);
        setRandom();
        //setTime();
        return rootView;

    }


    private void setRandom() {
        Random rand = new Random();
        String yourFormattedString = "";
        String yourFormattedString2 = "";
        String yourFormattedString3 = "";

        for (int i = 0; i < 3; i++) {
            TextView tv = (TextView) rootView.findViewById(random);
            int random = rand.nextInt(999);
            DecimalFormat formatter = new DecimalFormat("000");
            yourFormattedString += formatter.format(random) + "  ";
            tv.setText(yourFormattedString);
        }

        for (int i = 0; i < 3; i++) {
            TextView tv2 = (TextView) rootView.findViewById(R.id.random2);
            int random = rand.nextInt(999);
            DecimalFormat formatter = new DecimalFormat("000");
            yourFormattedString2 += formatter.format(random) + "  ";
            tv2.setText(yourFormattedString2);

        }

        for (int i = 0; i < 3; i++) {
            Random rand2 = new Random();
            TextView tv3 = (TextView) rootView.findViewById(R.id.random3);
            int random = rand2.nextInt(99);
            DecimalFormat formatter = new DecimalFormat("00");
            yourFormattedString3 += formatter.format(random) + "  ";
            tv3.setText(yourFormattedString3);
        }

    }


//    private void setTime() {
//        Calendar c = Calendar.getInstance();
//        tv = (TextView) rootView.findViewById(time);
//        int hour = c.get(Calendar.HOUR_OF_DAY);
//        int minutes = c.get(Calendar.MINUTE);
//        String time = hour + ":" + minutes;
//
//        if (hour < 12 && hour >= 0) {
//            tv.setText(time);
//
//        } else {
//            hour -= 12;
//            if (hour == 0) {
//            }
//            tv.setText(time);
//        }
//    }

}
// tv = (TextView) rootView.findViewById(time);

//        Calendar c = Calendar.getInstance();
//        int hour = c.get(Calendar.HOUR_OF_DAY);
//        int minutes = c.get(Calendar.MINUTE);
//        String time = hour + ":" + minutes;
//        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT+1:00"));
//        Date currentLocalTime = cal.getTime();
//        DateFormat date = new SimpleDateFormat("HH:mm");
//        // you can get seconds by adding  "...:ss" to it
//        date.setTimeZone(TimeZone.getTimeZone("GMT+1:00"));
//        String localTime = date.format(currentLocalTime);
//
//        Log.w(localTime, "1");
//
//        if (hour < 12 && hour >= 0) {
//            tv.setText("122");
//
//        } else {
//            hour -= 12;
//            if (hour == 0) {
//               setRandom();
//            } Calendar c = Calendar.getInstance();
//    }



























