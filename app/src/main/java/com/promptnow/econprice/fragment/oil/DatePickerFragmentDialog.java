package com.promptnow.econprice.fragment.oil;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 9/9/2559.
 */

public  class DatePickerFragmentDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

            /*
                Initialize a new DatePickerDialog

                DatePickerDialog(Context context, DatePickerDialog.OnDateSetListener callBack,
                    int year, int monthOfYear, int dayOfMonth)
             */
        DatePickerDialog dpd = new DatePickerDialog(getActivity(),this,year,month,day);
        return  dpd;
    }

    public void onDateSet(DatePicker view, int year, int month, int day){
        // Do something with the chosen date
        TextView tv_date_oil_price = (TextView) getActivity().findViewById(R.id.tv_date_oil_price);

        // Create a Date variable/object with user chosen date
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day, 0, 0, 0);
        Date chosenDate = cal.getTime();

        // Format the date using style and locale
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
        String formattedDate = df.format(chosenDate);

        // Display the chosen date to app interface
        tv_date_oil_price.setText(formattedDate);
    }
}

