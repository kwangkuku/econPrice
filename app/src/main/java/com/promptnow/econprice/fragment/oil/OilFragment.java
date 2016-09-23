package com.promptnow.econprice.fragment.oil;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.view.DatePickerFragment;

import java.util.Calendar;

/**
 * Created by Whankung on 7/9/2559.
 */

public class OilFragment extends android.support.v4.app.DialogFragment {
    private View rootView;
    private Typeface font;
    private TextView tv_date_oil_price, date, tv, tv2, tv3, tv4, tv5, tv6, tv7;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    public DatePickerFragment.onSetDateListener mListener;
    private int year;
    private int month;
    private int day;
    private String stringOfDate;


    public interface onSetDateListener {

        void setDate(int year, int month, int day);


    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil, container, false);

        setView();


        return rootView;
    }


    public void setView() {
        final LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.table);
        tv_date_oil_price = (TextView) rootView.findViewById(R.id.tv_date_oil_price);


//        เปลี่ยน font
        date = (TextView) rootView.findViewById(R.id.date);
        tv = (TextView) rootView.findViewById(R.id.oil);
        tv2 = (TextView) rootView.findViewById(R.id.txt_bensin);
        tv3 = (TextView) rootView.findViewById(R.id.txt_gassohol95);
        tv4 = (TextView) rootView.findViewById(R.id.txt_gassohol91);
        tv5 = (TextView) rootView.findViewById(R.id.txt_e20);
        tv6 = (TextView) rootView.findViewById(R.id.txt_e85);
        tv7 = (TextView) rootView.findViewById(R.id.txt_disel);
//        เปลี่ยน font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        date.setTypeface(font);
        tv.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font);
        tv5.setTypeface(font);
        tv6.setTypeface(font);
        tv7.setTypeface(font);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        month += 1;
        day = c.get(Calendar.DAY_OF_MONTH);
        stringOfDate = day + "/" + month + "/" + year;

        tv_date_oil_price.setText(stringOfDate);


        tv_date_oil_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize a new date picker dialog fragment
                android.app.DialogFragment dFragment = new DatePickerFragmentDialog();

                // Show the date picker dialog fragment
                dFragment.show(getActivity().getFragmentManager(), "Date Picker");

            }
        });


    }

}






