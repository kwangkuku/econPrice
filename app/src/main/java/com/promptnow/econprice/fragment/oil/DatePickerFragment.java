package com.promptnow.econprice.fragment.oil;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.oil.data_dummy.Dummy;

import java.util.Calendar;

/**
 * Created by Admin on 9/9/2559.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private String stringOfDate;
    private double vs1 = 23.79;
    private double vs2 = 22.45;
    private double result = vs1 - vs2;

    public interface onSetDateListener {

        void setDate(int year, int month, int day);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);


    }


    public void onDateSet(DatePicker view, int year, int month, int day) {

        TextView tv_date_oil_price = (TextView) getActivity().findViewById(R.id.tv_date_oil_price);
        TextView tv_date_oil_vs = (TextView) getActivity().findViewById(R.id.tv_date_oil_vs);

        stringOfDate = day + "/" + month + "/" + year;

        tv_date_oil_price.setText(stringOfDate);
        tv_date_oil_vs.setText(stringOfDate);

        //0 ---> Bensin            bs_colum1  bs_colum2  bs_colum3 bs_colum4
        //1 ---> Sohol95
        //2 ---> Sohol96
        //3 ---> E20
        //4 ---> E85
        //5 ---> Disel


//       Oil Type   |      PTT      |    BangJak   |       Shell        ESSO
// _________________|_______________|______________|__________________________
//        bansin    |  bs_colum1    |  bs_colum2   |                                    0
//        sohol95   |  sh95_colum1  |              |                                    1
//        sohol91   |               |              |                                    2
//        E20       |               |              |                                    3
//        E85       |               |              |                                    4
//        disel     |               |              |                                    5

//   --->

//Row1
        TextView tv_bs_colum1 = (TextView) getActivity().findViewById(R.id.tv_bs_colum1);
//      tv_bs_colum1.setText("32.11");
        tv_bs_colum1.setText(Dummy.newInstance().ptt.get(0) + " ");

        TextView tv_bs_colum2 = (TextView) getActivity().findViewById(R.id.tv_bs_colum2);
        //tv_bs_colum2.setText("30.61");
        tv_bs_colum2.setText(Dummy.newInstance().bangjak.get(0) + " ");

        TextView tv_bs_colum3 = (TextView) getActivity().findViewById(R.id.tv_bs_colum3);
        //tv_bs_colum3.setText("32.55");
        tv_bs_colum3.setText(Dummy.newInstance().shell.get(0) + " ");

        TextView tv_bs_colum4 = (TextView) getActivity().findViewById(R.id.tv_bs_colum4);
        //tv_bs_colum4.setText("32.11");
        tv_bs_colum4.setText(Dummy.newInstance().esso.get(0) + " ");

//Row2
        TextView tv_gsh95_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum1);
        //tv_gsh95_colum1.setText("22.25");
        tv_gsh95_colum1.setText(Dummy.newInstance().ptt.get(1)+" ");

        TextView tv_gsh95_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum2);
        //tv_gsh95_colum2.setText("-");
        tv_gsh95_colum2.setText(Dummy.newInstance().bangjak.get(1)+" ");

        TextView tv_gsh95_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum3);
        //tv_gsh95_colum3.setText("22.90");
        tv_gsh95_colum3.setText(Dummy.newInstance().shell.get(1)+" ");

        TextView tv_gsh95_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh95_colum4);
        //tv_gsh95_colum4.setText("23.12");
        tv_gsh95_colum4.setText(Dummy.newInstance().esso.get(1)+" ");

//Row3
        TextView tv_gsh91_colum1 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum1);
        //tv_gsh91_colum1.setText("23.26");
        tv_gsh91_colum1.setText(Dummy.newInstance().ptt.get(2)+" ");

        TextView tv_gsh91_colum2 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum2);
        //tv_gsh91_colum2.setText("-");
        tv_gsh91_colum2.setText(Dummy.newInstance().bangjak.get(2)+" ");

        TextView tv_gsh91_colum3 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum3);
        //tv_gsh91_colum3.setText("23.60");
        tv_gsh91_colum3.setText(Dummy.newInstance().shell.get(2)+" ");

        TextView tv_gsh91_colum4 = (TextView) getActivity().findViewById(R.id.tv_gsh91_colum4);
        //tv_gsh91_colum4.setText("24.11");
        tv_gsh91_colum4.setText(Dummy.newInstance().esso.get(2)+" ");


//Row4
        TextView tv_e20_colum1 = (TextView) getActivity().findViewById(R.id.tv_e20_colum1);
        //tv_e20_colum1.setText("21.29");
        tv_e20_colum1.setText(Dummy.newInstance().ptt.get(3)+" ");

        TextView tv_e20_colum2 = (TextView) getActivity().findViewById(R.id.tv_e20_colum2);
        //tv_e20_colum2.setText("21.81");
        tv_e20_colum2.setText(Dummy.newInstance().bangjak.get(3)+" ");

        TextView tv_e20_colum3 = (TextView) getActivity().findViewById(R.id.tv_e20_colum3);
        //tv_e20_colum3.setText("-");
        tv_e20_colum3.setText(Dummy.newInstance().shell.get(3)+" ");

        TextView tv_e20_colum4 = (TextView) getActivity().findViewById(R.id.tv_e20_colum4);
        //tv_e20_colum4.setText("21.61");
        tv_e20_colum4.setText(Dummy.newInstance().esso.get(3)+" ");

//Row5
        TextView tv_e85_colum1 = (TextView) getActivity().findViewById(R.id.tv_e85_colum1);
        //tv_e85_colum1.setText("17.83");
        tv_e85_colum1.setText(Dummy.newInstance().ptt.get(4)+" ");

        TextView tv_e85_colum2 = (TextView) getActivity().findViewById(R.id.tv_e85_colum2);
        //tv_e85_colum2.setText("17.18");
        tv_e85_colum2.setText(Dummy.newInstance().bangjak.get(4)+" ");

        TextView tv_e85_colum3 = (TextView) getActivity().findViewById(R.id.tv_e85_colum3);
        //tv_e85_colum3.setText("17.44");
        tv_e85_colum2.setText(Dummy.newInstance().shell.get(4)+" ");

        TextView tv_e85_colum4 = (TextView) getActivity().findViewById(R.id.tv_e85_colum4);
        //tv_e85_colum4.setText("-");
        tv_e85_colum2.setText(Dummy.newInstance().esso.get(4)+" ");

//Row6

        TextView tv_ds_colum1 = (TextView) getActivity().findViewById(R.id.tv_disel_colum1);
        //tv_ds_colum1.setText("23.23");
        tv_ds_colum1.setText(Dummy.newInstance().ptt.get(5)+" ");

        TextView tv_ds_colum2 = (TextView) getActivity().findViewById(R.id.tv_disel_colum2);
        //tv_ds_colum2.setText("23.44");
        tv_ds_colum2.setText(Dummy.newInstance().bangjak.get(5)+" ");

        TextView tv_ds_colum3 = (TextView) getActivity().findViewById(R.id.tv_disel_colum3);
        //tv_ds_colum3.setText("23.54");
        tv_ds_colum3.setText(Dummy.newInstance().shell.get(5)+" ");

        TextView tv_ds_colum4 = (TextView) getActivity().findViewById(R.id.tv_disel_colum4);
        //tv_ds_colum4.setText("23.09");
        tv_ds_colum4.setText(Dummy.newInstance().esso.get(5)+" ");


        TextView show_vs1 = (TextView) getActivity().findViewById(R.id.show_vs1);
        show_vs1.setText(Dummy.newInstance().ptt.get(3));


      TextView show_vs2 = (TextView) getActivity().findViewById(R.id.show_vs2);
        show_vs2.setText(Dummy.newInstance().shell.get(5));
//
//        TextView tv_show_result = (TextView) getActivity().findViewById(R.id.tv_show_result);
//        tv_show_result.setText(new DecimalFormat("0.00").format(+result));


    }


}