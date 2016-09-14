package com.promptnow.econprice.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.Calendar;

/**
 * Created by Admin on 9/9/2559.
 */


public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener  {
    public onSetDateListener mListener;
    private String stringOfDate;


    public interface onSetDateListener{

        void setDate(int year, int month, int day);
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this, year, month, day);

    }

    public void onDateSet(DatePicker view, int year, int month, int day) {

        TextView tv_date_oil_price = (TextView) getActivity().findViewById(R.id.tv_date_oil_price);
        TextView tv_date_oil_vs = (TextView) getActivity().findViewById(R.id.tv_date_oil_vs);

        stringOfDate = day + "/" + month + "/" + year;

        tv_date_oil_price.setText(stringOfDate);
        tv_date_oil_vs.setText(stringOfDate);

    }

}