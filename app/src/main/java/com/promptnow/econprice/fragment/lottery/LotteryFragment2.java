package com.promptnow.econprice.fragment.lottery;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.promptnow.econprice.R;
import com.promptnow.econprice.view.Singleton;

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

// หน้าเลขเด็ด
public class LotteryFragment2 extends Fragment {
    private View rootView;
    private Typeface font;
    private TextView tv, tv2, tv3,tv4,tv5,tv6;
    private String yourFormattedString = "";
    private String yourFormattedString2 = "";
    private String yourFormattedString3 = "";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.checklottery_number, container, false);

        setView();
        if (Singleton.getInstance().getFirstOpenApp()) {
            setRandom();
            Singleton.getInstance().setFirstOpenApp(false);
            Singleton.getInstance().setYourFormattedString(yourFormattedString);
            Singleton.getInstance().setYourFormattedString2(yourFormattedString2);
            Singleton.getInstance().setYourFormattedString3(yourFormattedString3);
        }
        setText();

        return rootView;
    }

    private void setView() {
        tv = (TextView) rootView.findViewById(R.id.random);
        tv2 = (TextView) rootView.findViewById(R.id.random2);
        tv3 = (TextView) rootView.findViewById(R.id.random3);
//        เลขมงคล
        tv4 = (TextView) rootView.findViewById(R.id.num1);
//        เลขท้าย 3ตัว
        tv5 = (TextView) rootView.findViewById(R.id.num2);
//        เลขท้าย 2ตัว
        tv6 = (TextView) rootView.findViewById(R.id.num3);
//        เปลี่ยน font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font);
        tv5.setTypeface(font);
        tv6.setTypeface(font);

    }

    private void setRandom() {
        Random rand = new Random();

        for (int i = 0; i < 3; i++) {
            int random = rand.nextInt(999);
            DecimalFormat formatter = new DecimalFormat("000");
            yourFormattedString += formatter.format(random) + "  ";
        }

        for (int i = 0; i < 3; i++) {
            int random = rand.nextInt(999);
            DecimalFormat formatter = new DecimalFormat("000");
            yourFormattedString2 += formatter.format(random) + "  ";
        }

        for (int i = 0; i < 3; i++) {
            Random rand2 = new Random();
            int random = rand2.nextInt(99);
            DecimalFormat formatter = new DecimalFormat("00");
            yourFormattedString3 += formatter.format(random) + "  ";
        }
    }

    private void setText() {
        tv.setText(Singleton.getInstance().getYourFormattedString());
        tv2.setText(Singleton.getInstance().getYourFormattedString2());
        tv3.setText(Singleton.getInstance().getYourFormattedString3());
    }
}




























