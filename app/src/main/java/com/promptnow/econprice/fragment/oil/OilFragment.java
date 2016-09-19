package com.promptnow.econprice.fragment.oil;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
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
    private TextView tv_date_oil_price;


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


    public void onDateSet(DatePicker view, int year, int month, int day) {

        TextView tv_date_oil_price = (TextView) getActivity().findViewById(R.id.tv_date_oil_price);
        TextView tv_date_oil_vs = (TextView) getActivity().findViewById(R.id.tv_date_oil_vs);


        stringOfDate = day + "/" + month + "/" + year;

        tv_date_oil_price.setText(stringOfDate);
        tv_date_oil_vs.setText(stringOfDate);


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







//button Search
        //Button btnClick = (Button) rootView.findViewById(R.id.btn_search);

        // button gone
        // btnClick.setVisibility(View.GONE);
        //

//        btnClick.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
////Row1
//                TextView tv_bs_colum1 = (TextView) rootView.findViewById(R.id.tv_bs_colum1);
//                tv_bs_colum1.setText("32.11");
//
//                TextView tv_bs_colum2 = (TextView) rootView.findViewById(R.id.tv_bs_colum2);
//                tv_bs_colum2.setText("30.61");
//
//                TextView tv_bs_colum3 = (TextView) rootView.findViewById(R.id.tv_bs_colum3);
//                tv_bs_colum3.setText("32.55");
//
//                TextView tv_bs_colum4 = (TextView) rootView.findViewById(R.id.tv_bs_colum4);
//                tv_bs_colum4.setText("32.11");
//
//
////Row2
//                TextView tv_gsh95_colum1 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum1);
//                tv_gsh95_colum1.setText("22.25");
//
//                TextView tv_gsh95_colum2 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum2);
//                tv_gsh95_colum2.setText("-");
//
//                TextView tv_gsh95_colum3 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum3);
//                tv_gsh95_colum3.setText("22.90");
//
//                TextView tv_gsh95_colum4 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum4);
//                tv_gsh95_colum4.setText("23.12");
//
////Row3
//                TextView tv_gsh91_colum1 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum1);
//                tv_gsh91_colum1.setText("23.26");
//
//                TextView tv_gsh91_colum2 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum2);
//                tv_gsh91_colum2.setText("-");
//
//                TextView tv_gsh91_colum3 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum3);
//                tv_gsh91_colum3.setText("23.60");
//
//                TextView tv_gsh91_colum4 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum4);
//                tv_gsh91_colum4.setText("24.11");
//
//
////Row4
//                TextView tv_e20_colum1 = (TextView) rootView.findViewById(R.id.tv_e20_colum1);
//                tv_e20_colum1.setText("21.29");
//
//                TextView tv_e20_colum2 = (TextView) rootView.findViewById(R.id.tv_e20_colum2);
//                tv_e20_colum2.setText("21.81");
//
//                TextView tv_e20_colum3 = (TextView) rootView.findViewById(R.id.tv_e20_colum3);
//                tv_e20_colum3.setText("-");
//
//                TextView tv_e20_colum4 = (TextView) rootView.findViewById(R.id.tv_e20_colum4);
//                tv_e20_colum4.setText("21.61");
//
////Row5
//                TextView tv_e85_colum1 = (TextView) rootView.findViewById(R.id.tv_e85_colum1);
//                tv_e85_colum1.setText("17.83");
//
//                TextView tv_e85_colum2 = (TextView) rootView.findViewById(R.id.tv_e85_colum2);
//                tv_e85_colum2.setText("17.18");
//
//                TextView tv_e85_colum3 = (TextView) rootView.findViewById(R.id.tv_e85_colum3);
//                tv_e85_colum3.setText("17.44");
//
//                TextView tv_e85_colum4 = (TextView) rootView.findViewById(R.id.tv_e85_colum4);
//                tv_e85_colum4.setText("-");
//
////Row6
//
//                TextView tv_ds_colum1 = (TextView) rootView.findViewById(R.id.tv_disel_colum1);
//                tv_ds_colum1.setText("23.23");
//
//                TextView tv_ds_colum2 = (TextView) rootView.findViewById(R.id.tv_disel_colum2);
//                tv_ds_colum2.setText("23.44");
//
//                TextView tv_ds_colum3 = (TextView) rootView.findViewById(R.id.tv_disel_colum3);
//                tv_ds_colum3.setText("23.54");
//
//                TextView tv_ds_colum4 = (TextView) rootView.findViewById(R.id.tv_disel_colum4);
//                tv_ds_colum4.setText("23.09");

//
//            }
//        });


//    @Override
//    public void setDate(int year, int month, int day) {
//
//        tv_date_oil_price.setText(year + month + day);
//
//


    }
}
