package com.promptnow.econprice.fragment.oil;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.oil.data_dummy.Dummy;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Admin on 9/9/2559.
 */

public class DatePickerFragmentDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {


    static final Calendar calendar = Calendar.getInstance();
    static int year = calendar.get(Calendar.YEAR);
    static int month = calendar.get(Calendar.MONTH);
    static int day = calendar.get(Calendar.DAY_OF_MONTH);
    double vs1_day_10 = 23.45, vs2_day_10 = 25.77;
    double vs1_day_18 = 31.56, vs2_day_18 = 29.91;
    double vs1_day_27 = 26.77, vs2_day_27 = 26.56;

    TextView show_vs1, show_vs2;
    double result;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



            /*
                Initialize a new DatePickerDialog

                DatePickerDialog(Context context, DatePickerDialog.OnDateSetListener callBack,
                    int year, int monthOfYear, int dayOfMonth)
             */
        DatePickerDialog dpd = new DatePickerDialog(getActivity(), this, year, month, day);
        return dpd;
    }

    public void onDateSet(DatePicker view, int year, int month, int day) {
        // Do something with the chosen date
        this.day = day;
        this.month = month;
        this.year = year;


        TextView tv_date_oil_price = (TextView) getActivity().findViewById(R.id.tv_date_oil_price);
        TextView tv_date_oil_vs = (TextView) getActivity().findViewById(R.id.tv_date_oil_vs);

        // Create a Date variable/object with user chosen date
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(0);
        cal.set(year, month, day, 0, 0, 0);
        Date chosenDate = cal.getTime();

        // Format the date using style and locale
        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT);
        String formattedDate = day + "/" + (month + 1) + "/" + year;

        // Display the chosen date to app interface
        tv_date_oil_price.setText(formattedDate);
        tv_date_oil_vs.setText(formattedDate);


        if (day == 10)

        {

            // Row1
            TextView tv_bs_colum1 = (TextView) getActivity().findViewById(R.id.tv_bs_colum1);
            tv_bs_colum1.setText(Dummy.getInstance().ptt_day_10.get(0) + " ");

            TextView tv_bs_colum2 = (TextView) getActivity().findViewById(R.id.tv_bs_colum2);
            tv_bs_colum2.setText(Dummy.getInstance().bangjak_day_10.get(0) + " ");

            TextView tv_bs_colum3 = (TextView) getActivity().findViewById(R.id.tv_bs_colum3);
            tv_bs_colum3.setText(Dummy.getInstance().shell_day_10.get(0) + " ");

            TextView tv_bs_colum4 = (TextView) getActivity().findViewById(R.id.tv_bs_colum4);
            tv_bs_colum4.setText(Dummy.getInstance().esso_day_10.get(0) + " ");

            // Row2
            TextView tv_gsh95_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum1);
            tv_gsh95_colum1.setText(Dummy.getInstance().ptt_day_10.get(1) + " ");

            TextView tv_gsh95_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum2);
            tv_gsh95_colum2.setText(Dummy.getInstance().bangjak_day_10.get(1) + " ");

            TextView tv_gsh95_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum3);
            tv_gsh95_colum3.setText(Dummy.getInstance().shell_day_10.get(1) + " ");

            TextView tv_gsh95_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum4);
            tv_gsh95_colum4.setText(Dummy.getInstance().esso_day_10.get(1) + " ");

            //Row3
            TextView tv_gsh91_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum1);
            tv_gsh91_colum1.setText(Dummy.getInstance().ptt_day_10.get(2) + " ");

            TextView tv_gsh91_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum2);
            tv_gsh91_colum2.setText(Dummy.getInstance().bangjak_day_10.get(2) + " ");

            TextView tv_gsh91_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum3);
            tv_gsh91_colum3.setText(Dummy.getInstance().shell_day_10.get(2) + " ");

            TextView tv_gsh91_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum4);
            tv_gsh91_colum4.setText(Dummy.getInstance().esso_day_10.get(2) + " ");


            // Row4
            TextView tv_e20_colum1 = (TextView) getActivity().findViewById(R.id.tv_e20_colum1);
            tv_e20_colum1.setText(Dummy.getInstance().ptt_day_10.get(3) + " ");

            TextView tv_e20_colum2 = (TextView) getActivity().findViewById(R.id.tv_e20_colum2);
            tv_e20_colum2.setText(Dummy.getInstance().bangjak_day_10.get(3) + " ");

            TextView tv_e20_colum3 = (TextView) getActivity().findViewById(R.id.tv_e20_colum3);
            tv_e20_colum3.setText(Dummy.getInstance().shell_day_10.get(3) + " ");

            TextView tv_e20_colum4 = (TextView) getActivity().findViewById(R.id.tv_e20_colum4);
            tv_e20_colum4.setText(Dummy.getInstance().esso_day_10.get(3) + " ");

            //Row5
            TextView tv_e85_colum1 = (TextView) getActivity().findViewById(R.id.tv_e85_colum1);
            tv_e85_colum1.setText(Dummy.getInstance().ptt_day_10.get(4) + " ");

            TextView tv_e85_colum2 = (TextView) getActivity().findViewById(R.id.tv_e85_colum2);
            tv_e85_colum2.setText(Dummy.getInstance().bangjak_day_10.get(4) + " ");

            TextView tv_e85_colum3 = (TextView) getActivity().findViewById(R.id.tv_e85_colum3);
            tv_e85_colum3.setText(Dummy.getInstance().shell_day_10.get(4) + " ");

            TextView tv_e85_colum4 = (TextView) getActivity().findViewById(R.id.tv_e85_colum4);
            tv_e85_colum4.setText(Dummy.getInstance().esso_day_10.get(4) + " ");

            //Row6

            TextView tv_ds_colum1 = (TextView) getActivity().findViewById(R.id.tv_disel_colum1);
            tv_ds_colum1.setText(Dummy.getInstance().ptt_day_10.get(5) + " ");

            TextView tv_ds_colum2 = (TextView) getActivity().findViewById(R.id.tv_disel_colum2);
            tv_ds_colum2.setText(Dummy.getInstance().bangjak_day_10.get(5) + " ");

            TextView tv_ds_colum3 = (TextView) getActivity().findViewById(R.id.tv_disel_colum3);
            tv_ds_colum3.setText(Dummy.getInstance().shell_day_10.get(5) + " ");

            TextView tv_ds_colum4 = (TextView) getActivity().findViewById(R.id.tv_disel_colum4);
            tv_ds_colum4.setText(Dummy.getInstance().esso_day_10.get(5) + " ");


////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Oil VS Price
            TextView show_vs1 = (TextView) getActivity().findViewById(R.id.show_vs1);
            show_vs1.setText("" + vs1_day_10);

            TextView show_vs2 = (TextView) getActivity().findViewById(R.id.show_vs2);
            show_vs2.setText("" + vs2_day_10);

            result = vs1_day_10 - vs2_day_10;

            TextView tv_show_result = (TextView) getActivity().findViewById(R.id.tv_show_result);
            tv_show_result.setText("" + result);
            tv_show_result.setText(new DecimalFormat("0.00").format(+result));
            if (result < 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            } else if (result > 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            }

        }


        if (day == 18) {

            // Row1
            TextView tv_bs_colum1 = (TextView) getActivity().findViewById(R.id.tv_bs_colum1);
            tv_bs_colum1.setText(Dummy.getInstance().ptt_day_18.get(0) + " ");

            TextView tv_bs_colum2 = (TextView) getActivity().findViewById(R.id.tv_bs_colum2);
            tv_bs_colum2.setText(Dummy.getInstance().bangjak_day_18.get(0) + " ");

            TextView tv_bs_colum3 = (TextView) getActivity().findViewById(R.id.tv_bs_colum3);
            tv_bs_colum3.setText(Dummy.getInstance().shell_day_18.get(0) + " ");

            TextView tv_bs_colum4 = (TextView) getActivity().findViewById(R.id.tv_bs_colum4);
            tv_bs_colum4.setText(Dummy.getInstance().esso_day_18.get(0) + " ");

            // Row2
            TextView tv_gsh95_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum1);
            tv_gsh95_colum1.setText(Dummy.getInstance().ptt_day_18.get(1) + " ");

            TextView tv_gsh95_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum2);
            tv_gsh95_colum2.setText(Dummy.getInstance().bangjak_day_18.get(1) + " ");

            TextView tv_gsh95_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum3);
            tv_gsh95_colum3.setText(Dummy.getInstance().shell_day_18.get(1) + " ");

            TextView tv_gsh95_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum4);
            tv_gsh95_colum4.setText(Dummy.getInstance().esso_day_18.get(1) + " ");

            //Row3
            TextView tv_gsh91_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum1);
            tv_gsh91_colum1.setText(Dummy.getInstance().ptt_day_18.get(2) + " ");

            TextView tv_gsh91_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum2);
            tv_gsh91_colum2.setText(Dummy.getInstance().bangjak_day_18.get(2) + " ");

            TextView tv_gsh91_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum3);
            tv_gsh91_colum3.setText(Dummy.getInstance().shell_day_18.get(2) + " ");

            TextView tv_gsh91_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum4);
            tv_gsh91_colum4.setText(Dummy.getInstance().esso_day_18.get(2) + " ");


            // Row4
            TextView tv_e20_colum1 = (TextView) getActivity().findViewById(R.id.tv_e20_colum1);
            tv_e20_colum1.setText(Dummy.getInstance().ptt_day_18.get(3) + " ");

            TextView tv_e20_colum2 = (TextView) getActivity().findViewById(R.id.tv_e20_colum2);
            tv_e20_colum2.setText(Dummy.getInstance().bangjak_day_18.get(3) + " ");

            TextView tv_e20_colum3 = (TextView) getActivity().findViewById(R.id.tv_e20_colum3);
            tv_e20_colum3.setText(Dummy.getInstance().shell_day_18.get(3) + " ");

            TextView tv_e20_colum4 = (TextView) getActivity().findViewById(R.id.tv_e20_colum4);
            tv_e20_colum4.setText(Dummy.getInstance().esso_day_18.get(3) + " ");

            //Row5
            TextView tv_e85_colum1 = (TextView) getActivity().findViewById(R.id.tv_e85_colum1);
            tv_e85_colum1.setText(Dummy.getInstance().ptt_day_18.get(4) + " ");

            TextView tv_e85_colum2 = (TextView) getActivity().findViewById(R.id.tv_e85_colum2);
            tv_e85_colum2.setText(Dummy.getInstance().bangjak_day_18.get(4) + " ");

            TextView tv_e85_colum3 = (TextView) getActivity().findViewById(R.id.tv_e85_colum3);
            tv_e85_colum3.setText(Dummy.getInstance().shell_day_18.get(4) + " ");

            TextView tv_e85_colum4 = (TextView) getActivity().findViewById(R.id.tv_e85_colum4);
            tv_e85_colum4.setText(Dummy.getInstance().esso_day_18.get(4) + " ");

            //Row6

            TextView tv_ds_colum1 = (TextView) getActivity().findViewById(R.id.tv_disel_colum1);
            tv_ds_colum1.setText(Dummy.getInstance().ptt_day_18.get(5) + " ");

            TextView tv_ds_colum2 = (TextView) getActivity().findViewById(R.id.tv_disel_colum2);
            tv_ds_colum2.setText(Dummy.getInstance().bangjak_day_18.get(5) + " ");

            TextView tv_ds_colum3 = (TextView) getActivity().findViewById(R.id.tv_disel_colum3);
            tv_ds_colum3.setText(Dummy.getInstance().shell_day_18.get(5) + " ");

            TextView tv_ds_colum4 = (TextView) getActivity().findViewById(R.id.tv_disel_colum4);
            tv_ds_colum4.setText(Dummy.getInstance().esso_day_18.get(05) + " ");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Oil VS Price
            TextView show_vs1 = (TextView) getActivity().findViewById(R.id.show_vs1);
            show_vs1.setText("" + vs1_day_18);

            TextView show_vs2 = (TextView) getActivity().findViewById(R.id.show_vs2);
            show_vs2.setText("" + vs2_day_18);

            result = vs1_day_18 - vs2_day_18;

            TextView tv_show_result = (TextView) getActivity().findViewById(R.id.tv_show_result);
            tv_show_result.setText("" + result);
            tv_show_result.setText(new DecimalFormat("0.00").format(+result));
            if (result < 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            } else if (result > 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            }


        }

        if (day == 27) {

            // Row1
            TextView tv_bs_colum1 = (TextView) getActivity().findViewById(R.id.tv_bs_colum1);
            tv_bs_colum1.setText(Dummy.getInstance().ptt_day_27.get(0) + " ");

            TextView tv_bs_colum2 = (TextView) getActivity().findViewById(R.id.tv_bs_colum2);
            tv_bs_colum2.setText(Dummy.getInstance().bangjak_day_27.get(0) + " ");

            TextView tv_bs_colum3 = (TextView) getActivity().findViewById(R.id.tv_bs_colum3);
            tv_bs_colum3.setText(Dummy.getInstance().shell_day_27.get(0) + " ");

            TextView tv_bs_colum4 = (TextView) getActivity().findViewById(R.id.tv_bs_colum4);
            tv_bs_colum4.setText(Dummy.getInstance().esso_day_27.get(0) + " ");

            // Row2
            TextView tv_gsh95_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum1);
            tv_gsh95_colum1.setText(Dummy.getInstance().ptt_day_27.get(1) + " ");

            TextView tv_gsh95_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum2);
            tv_gsh95_colum2.setText(Dummy.getInstance().bangjak_day_27.get(1) + " ");

            TextView tv_gsh95_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum3);
            tv_gsh95_colum3.setText(Dummy.getInstance().shell_day_27.get(1) + " ");

            TextView tv_gsh95_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum4);
            tv_gsh95_colum4.setText(Dummy.getInstance().esso_day_27.get(1) + " ");

            //Row3
            TextView tv_gsh91_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum1);
            tv_gsh91_colum1.setText(Dummy.getInstance().ptt_day_27.get(2) + " ");

            TextView tv_gsh91_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum2);
            tv_gsh91_colum2.setText(Dummy.getInstance().bangjak_day_27.get(2) + " ");

            TextView tv_gsh91_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum3);
            tv_gsh91_colum3.setText(Dummy.getInstance().shell_day_27.get(2) + " ");

            TextView tv_gsh91_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum4);
            tv_gsh91_colum4.setText(Dummy.getInstance().esso_day_27.get(2) + " ");


            // Row4
            TextView tv_e20_colum1 = (TextView) getActivity().findViewById(R.id.tv_e20_colum1);
            tv_e20_colum1.setText(Dummy.getInstance().ptt_day_27.get(3) + " ");

            TextView tv_e20_colum2 = (TextView) getActivity().findViewById(R.id.tv_e20_colum2);
            tv_e20_colum2.setText(Dummy.getInstance().bangjak_day_27.get(3) + " ");

            TextView tv_e20_colum3 = (TextView) getActivity().findViewById(R.id.tv_e20_colum3);
            tv_e20_colum3.setText(Dummy.getInstance().shell_day_27.get(3) + " ");

            TextView tv_e20_colum4 = (TextView) getActivity().findViewById(R.id.tv_e20_colum4);
            tv_e20_colum4.setText(Dummy.getInstance().esso_day_27.get(3) + " ");

            //Row5
            TextView tv_e85_colum1 = (TextView) getActivity().findViewById(R.id.tv_e85_colum1);
            tv_e85_colum1.setText(Dummy.getInstance().ptt_day_27.get(4) + " ");

            TextView tv_e85_colum2 = (TextView) getActivity().findViewById(R.id.tv_e85_colum2);
            tv_e85_colum2.setText(Dummy.getInstance().bangjak_day_27.get(4) + " ");

            TextView tv_e85_colum3 = (TextView) getActivity().findViewById(R.id.tv_e85_colum3);
            tv_e85_colum3.setText(Dummy.getInstance().shell_day_27.get(4) + " ");

            TextView tv_e85_colum4 = (TextView) getActivity().findViewById(R.id.tv_e85_colum4);
            tv_e85_colum4.setText(Dummy.getInstance().esso_day_27.get(4) + " ");

            //Row6

            TextView tv_ds_colum1 = (TextView) getActivity().findViewById(R.id.tv_disel_colum1);
            tv_ds_colum1.setText(Dummy.getInstance().ptt_day_27.get(5) + " ");

            TextView tv_ds_colum2 = (TextView) getActivity().findViewById(R.id.tv_disel_colum2);
            tv_ds_colum2.setText(Dummy.getInstance().bangjak_day_27.get(5) + " ");

            TextView tv_ds_colum3 = (TextView) getActivity().findViewById(R.id.tv_disel_colum3);
            tv_ds_colum3.setText(Dummy.getInstance().shell_day_27.get(5) + " ");

            TextView tv_ds_colum4 = (TextView) getActivity().findViewById(R.id.tv_disel_colum4);
            tv_ds_colum4.setText(Dummy.getInstance().esso_day_27.get(5) + " ");

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            //Oil VS Price
            TextView show_vs1 = (TextView) getActivity().findViewById(R.id.show_vs1);
            show_vs1.setText("" + vs1_day_27);

            TextView show_vs2 = (TextView) getActivity().findViewById(R.id.show_vs2);
            show_vs2.setText("" + vs2_day_27);

            result = vs1_day_27 - vs2_day_27;

            TextView tv_show_result = (TextView) getActivity().findViewById(R.id.tv_show_result);
            tv_show_result.setText("" + result);
            tv_show_result.setText(new DecimalFormat("0.00").format(+result));
            if (result < 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            } else if (result > 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            }


        }

    }


}

