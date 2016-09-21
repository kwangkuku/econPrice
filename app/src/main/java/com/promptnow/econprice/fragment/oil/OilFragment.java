package com.promptnow.econprice.fragment.oil;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.Calendar;

/**
 * Created by Whankung on 7/9/2559.
 */

public class OilFragment extends android.support.v4.app.DialogFragment implements DatePickerDialog.OnDateSetListener {
    private View rootView;
    private Typeface font;
    private TextView tv_date_oil_price, date,tv,tv2,tv3,tv4,tv5,tv6,tv7;
    public DatePickerFragment.onSetDateListener mListener;
    private String stringOfDate;


    public interface onSetDateListener {

        void setDate(int year, int month, int day);
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);


    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil, container, false);
        setView();

        return rootView;
    }


    private void setView() {
        tv_date_oil_price = (TextView) rootView.findViewById(R.id.tv_date_oil_price);
        date = (TextView) rootView.findViewById(R.id.date);
        tv=(TextView) rootView.findViewById(R.id.oil);
        tv2=(TextView) rootView.findViewById(R.id.txt_bensin);
        tv3=(TextView) rootView.findViewById(R.id.txt_gassohol95);
        tv4=(TextView) rootView.findViewById(R.id.txt_gassohol91);
        tv5=(TextView) rootView.findViewById(R.id.txt_e20);
        tv6=(TextView) rootView.findViewById(R.id.txt_e85);
        tv7=(TextView) rootView.findViewById(R.id.txt_disel);
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
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        month += 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String stringOfDate = day + "/" + month + "/" + year;


        tv_date_oil_price.setText(stringOfDate);
        tv_date_oil_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        tv_date_oil_price.setOnClickListener(new View.OnClickListener() {


                                                 @Override
                                                 public void onClick(View v) {
                                                     DialogFragment newFragment = new DatePickerFragment();
                                                     newFragment.show(getActivity().getFragmentManager(), "Date Picker");


                                                 }


                                             }

        );


    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        TextView tv_date_oil_price = (TextView) getActivity().findViewById(R.id.tv_date_oil_price);
        TextView tv_date_oil_vs = (TextView) getActivity().findViewById(R.id.tv_date_oil_vs);


        stringOfDate = day + "/" + month + "/" + year;

        tv_date_oil_price.setText(stringOfDate);
        tv_date_oil_vs.setText(stringOfDate);


    }
}
