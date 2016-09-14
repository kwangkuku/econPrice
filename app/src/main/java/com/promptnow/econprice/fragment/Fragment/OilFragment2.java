package com.promptnow.econprice.fragment.Fragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.view.DatePickerFragment;

import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Whankung on 7/9/2559.
 */

public class OilFragment2 extends Fragment implements DatePickerFragment.onSetDateListener {
    private View rootView;
    private Spinner oilTypeSpinner;
    //private ArrayList<String> oil_Type = new ArrayList<String>();
    private TextView tv_date_oil_vs;
    private TextView show_vs1, show_vs2, tv_show_result;
    double vs1, vs2;
    double result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil2, container, false);
        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);

        //setItem();
        setView();
        setOilTypeSpiner();
//        setResult();
        //setTextView();
        setType();
        return rootView;

    }


    private void setType() {
//        oilTypeSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                oilTypeSpinner.performClick();
//
//            }
//        });
    }

//    private void setTextView() {
//        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
//        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
//        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);
//    }


    private void setOilTypeSpiner() {
        oilTypeSpinner = (Spinner) rootView.findViewById(R.id.oilTypeSpinner);
        //  oilTypeSpinner.setEnabled(false);

        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.add("เบนซิล 95");
        arrayList.add("แก๊สโซฮอล์ 95");
        arrayList.add("E20");
        arrayList.add("E85");
        arrayList.add("ดีเซล");


        ArrayAdapter<String> oilAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_dropdown_item_1line, arrayList);
        oilTypeSpinner.setAdapter(oilAdapter);


        oilTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
//                setResult();
                if (i == 0) {
                    vs1 = 31.76;
                    vs2 = 32.21;
                    result = vs1 - vs2;
                } else if (i == 1) {
                    vs1 = 35.76;
                    vs2 = 31.21;
                    result = vs1 - vs2;

                } else if (i == 2) {
                    vs1 = 38.36;
                    vs2 = 37.11;
                    result = vs1 - vs2;

                } else if (i == 3) {
                    vs1 = 11.54;
                    vs2 = 23.55;
                    result = vs1 - vs2;

                } else if (i == 4) {
                    vs1 = 52.54;
                    vs2 = 35.86;
                    result = vs1 - vs2;

                }
                setResult();
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

    }

//    public class DecimalFormatDemo {
//
//         public void customFormat(String pattern, double value ) {
//            DecimalFormat myFormatter = new DecimalFormat(pattern);
//            String output = myFormatter.format(value);
//            System.out.println(value + "  " + pattern + "  " + output);
//        }
//
//         public void main(String[] args) {
//
//            customFormat("###,###.###", 123456.789);
//            customFormat("###.##", 123456.789);
//            customFormat("000000.000", 123.78);
//            customFormat("$###,###.###", 12345.67);
//        }
//    }

    private void setResult() {
//
//        DecimalFormat myFormatter = new DecimalFormat(vs1);
//        Double result = myFormatter.format(vs2);

        show_vs1.setText("" + vs1);
        show_vs2.setText(" " + vs2);
        tv_show_result.setText(" " + result);
    }


    //Date Picker
    private void setView() {
        tv_date_oil_vs = (TextView) rootView.findViewById(R.id.tv_date_oil_vs);
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        month += 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String stringOfDate = day + "/" + month + "/" + year;

        tv_date_oil_vs.setText(stringOfDate);
        tv_date_oil_vs.setOnClickListener(new View.OnClickListener()

        {
            //call Date Picker
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new DatePickerFragment();
                newFragment.show(getActivity().getFragmentManager(), "Date Picker");
            }

        });
    }

    public void setDate(int year, int month, int day) {

        tv_date_oil_vs.setText(year + month + day);
    }


}

