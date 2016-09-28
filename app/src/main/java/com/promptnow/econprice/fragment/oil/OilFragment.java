package com.promptnow.econprice.fragment.oil;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.oil.data_dummy.Dummy;
import com.promptnow.econprice.view.DatePickerFragment;
import com.promptnow.econprice.view.UtilCalendar;

import java.util.Calendar;

import static android.content.ContentValues.TAG;

/**
 * Created by Whankung on 7/9/2559.
 */

public class OilFragment extends android.support.v4.app.DialogFragment implements DatePickerFragment.onSetDateListener {
    private View rootView;
    private Typeface font;
    private TextView tv_date_oil_price, date, tv, tv2, tv3, tv4, tv5, tv6, tv7,
            tv_bs_colum1, tv_bs_colum2, tv_bs_colum3, tv_bs_colum4, tv_gsh95_colum1, tv_gsh95_colum2,
            tv_gsh95_colum3, tv_gsh95_colum4, tv_gsh91_colum1, tv_gsh91_colum2, tv_gsh91_colum3, tv_gsh91_colum4,
            tv_e20_colum1, tv_e20_colum2, tv_e20_colum3, tv_e20_colum4, tv_e85_colum1, tv_e85_colum2, tv_e85_colum3, tv_e85_colum4,
            tv_ds_colum1, tv_ds_colum2, tv_ds_colum3, tv_ds_colum4, show_vs1, show_vs2, tv_show_result;
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

//        row
        tv_bs_colum1 = (TextView) rootView.findViewById(R.id.tv_bs_colum1);
        tv_bs_colum2 = (TextView) rootView.findViewById(R.id.tv_bs_colum2);
        tv_bs_colum3 = (TextView) rootView.findViewById(R.id.tv_bs_colum3);
        tv_bs_colum4 = (TextView) rootView.findViewById(R.id.tv_bs_colum4);
        tv_gsh95_colum1 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum1);
        tv_gsh95_colum2 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum2);
        tv_gsh95_colum3 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum3);
        tv_gsh95_colum4 = (TextView) rootView.findViewById(R.id.tv_gsh95_colum4);
        tv_gsh91_colum1 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum1);
        tv_gsh91_colum2 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum2);
        tv_gsh91_colum3 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum3);
        tv_gsh91_colum4 = (TextView) rootView.findViewById(R.id.tv_gsh91_colum4);
        tv_e20_colum1 = (TextView) rootView.findViewById(R.id.tv_e20_colum1);
        tv_e20_colum2 = (TextView) rootView.findViewById(R.id.tv_e20_colum2);
        tv_e20_colum3 = (TextView) rootView.findViewById(R.id.tv_e20_colum3);
        tv_e20_colum4 = (TextView) rootView.findViewById(R.id.tv_e20_colum4);
        tv_e85_colum1 = (TextView) rootView.findViewById(R.id.tv_e85_colum1);
        tv_e85_colum2 = (TextView) rootView.findViewById(R.id.tv_e85_colum2);
        tv_e85_colum3 = (TextView) rootView.findViewById(R.id.tv_e85_colum3);
        tv_e85_colum4 = (TextView) rootView.findViewById(R.id.tv_e85_colum4);
        tv_ds_colum1 = (TextView) rootView.findViewById(R.id.tv_disel_colum1);
        tv_ds_colum2 = (TextView) rootView.findViewById(R.id.tv_disel_colum2);
        tv_ds_colum3 = (TextView) rootView.findViewById(R.id.tv_disel_colum3);
        tv_ds_colum4 = (TextView) rootView.findViewById(R.id.tv_disel_colum4);
        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);

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
        setCurrentDate();

        tv_date_oil_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showDatePikkerDialog();

            }
        });

    }

    private void showDatePikkerDialog() {

        DatePickerFragment picker = new DatePickerFragment(getActivity(), day, month, year);
        picker.mListener = OilFragment.this;
//        if (tv_date_oil_price.length()==0){
//            picker.setRangeYear(20);
//        }
        picker.show(getActivity().getFragmentManager(), "");
    }

    private void setCurrentDate() {
        final Calendar c = UtilCalendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);  //0;
        day = c.get(Calendar.DAY_OF_MONTH); //1;
    }

    @Override
    public void setDate(int day, int month, int year, String date, String dateFormat) {
        final Calendar c = Calendar.getInstance();
        Boolean isTrue = false;
        if (year >= c.get(Calendar.YEAR)) {
            if (month < c.get(Calendar.MONTH)) {
                isTrue = true;
            } else if (month == c.get(Calendar.MONTH)) {
                if (day <= c.get(Calendar.DATE)) {
                    isTrue = true;
                }
            }
        } else {
            isTrue = true;
        }
        if (isTrue) {
            this.year = year;
            this.month = month;
            this.day = day;
//            str_fromdate = dateFormat.substring(6,10)+dateFormat.substring(3,5)+dateFormat.substring(0,2);
//            UtilLog.i("Boom", str_fromdate);
            tv_date_oil_price.setText(date);
            setData(date);

        }
    }

    private void setData(String date) {

        String day[] = date.split("/");

        Log.d("Show Day" ,day[0]);
        Log.d("Show Month" ,day[1]);
        Log.d("Show Year" ,day[2]);
//       String d = date.substring(0, 2); ใช้ในกรณีที่วันที่มีค่าเป็น 23/1/2016 9 หลัก
// แต่ถ้าเป็น case ที่        วันที่มีค่าเป็น 8/1/2016  8 หลัก จะใช้   String d = date.substring(0, ๅ);

        Log.d(TAG, "perfeact day : " + day[0]);

        if (day[0].equals("10")) {

//            // Row1
            tv_bs_colum1.setText(Dummy.getInstance().ptt_day_10.get(0) + " ");
            tv_bs_colum2.setText(Dummy.getInstance().bangjak_day_10.get(0) + " ");
            tv_bs_colum3.setText(Dummy.getInstance().shell_day_10.get(0) + " ");
            tv_bs_colum4.setText(Dummy.getInstance().esso_day_10.get(0) + " ");

            // Row2
            tv_gsh95_colum1.setText(Dummy.getInstance().ptt_day_10.get(1) + " ");
            tv_gsh95_colum2.setText(Dummy.getInstance().bangjak_day_10.get(1) + " ");
            tv_gsh95_colum3.setText(Dummy.getInstance().shell_day_10.get(1) + " ");
            tv_gsh95_colum4.setText(Dummy.getInstance().esso_day_10.get(1) + " ");

            //Row3
            tv_gsh91_colum1.setText(Dummy.getInstance().ptt_day_10.get(2) + " ");
            tv_gsh91_colum2.setText(Dummy.getInstance().bangjak_day_10.get(2) + " ");
            tv_gsh91_colum3.setText(Dummy.getInstance().shell_day_10.get(2) + " ");
            tv_gsh91_colum4.setText(Dummy.getInstance().esso_day_10.get(2) + " ");

            // Row4
            tv_e20_colum1.setText(Dummy.getInstance().ptt_day_10.get(3) + " ");
            tv_e20_colum2.setText(Dummy.getInstance().bangjak_day_10.get(3) + " ");
            tv_e20_colum3.setText(Dummy.getInstance().shell_day_10.get(3) + " ");
            tv_e20_colum4.setText(Dummy.getInstance().esso_day_10.get(3) + " ");

            //Row5
            tv_e85_colum1.setText(Dummy.getInstance().ptt_day_10.get(4) + " ");
            tv_e85_colum2.setText(Dummy.getInstance().bangjak_day_10.get(4) + " ");
            tv_e85_colum3.setText(Dummy.getInstance().shell_day_10.get(4) + " ");
            tv_e85_colum4.setText(Dummy.getInstance().esso_day_10.get(4) + " ");

            //Row6
            tv_ds_colum1.setText(Dummy.getInstance().ptt_day_10.get(5) + " ");
            tv_ds_colum2.setText(Dummy.getInstance().bangjak_day_10.get(5) + " ");
            tv_ds_colum3.setText(Dummy.getInstance().shell_day_10.get(5) + " ");
            tv_ds_colum4.setText(Dummy.getInstance().esso_day_10.get(5) + " ");


        } else if (day[0].equals("18")) {

            // Row1
            tv_bs_colum1.setText(Dummy.getInstance().ptt_day_18.get(0) + " ");
            tv_bs_colum2.setText(Dummy.getInstance().bangjak_day_18.get(0) + " ");
            tv_bs_colum3.setText(Dummy.getInstance().shell_day_18.get(0) + " ");
            tv_bs_colum4.setText(Dummy.getInstance().esso_day_18.get(0) + " ");

            // Row2
            tv_gsh95_colum1.setText(Dummy.getInstance().ptt_day_18.get(1) + " ");
            tv_gsh95_colum2.setText(Dummy.getInstance().bangjak_day_18.get(1) + " ");
            tv_gsh95_colum3.setText(Dummy.getInstance().shell_day_18.get(1) + " ");
            tv_gsh95_colum4.setText(Dummy.getInstance().esso_day_18.get(1) + " ");

            //Row3
            tv_gsh91_colum1.setText(Dummy.getInstance().ptt_day_18.get(2) + " ");
            tv_gsh91_colum2.setText(Dummy.getInstance().bangjak_day_18.get(2) + " ");
            tv_gsh91_colum3.setText(Dummy.getInstance().shell_day_18.get(2) + " ");
            tv_gsh91_colum4.setText(Dummy.getInstance().esso_day_18.get(2) + " ");

            // Row4
            tv_e20_colum1.setText(Dummy.getInstance().ptt_day_18.get(3) + " ");
            tv_e20_colum2.setText(Dummy.getInstance().bangjak_day_18.get(3) + " ");
            tv_e20_colum3.setText(Dummy.getInstance().shell_day_18.get(3) + " ");
            tv_e20_colum4.setText(Dummy.getInstance().esso_day_18.get(3) + " ");

            //Row5
            tv_e85_colum1.setText(Dummy.getInstance().ptt_day_18.get(4) + " ");
            tv_e85_colum2.setText(Dummy.getInstance().bangjak_day_18.get(4) + " ");
            tv_e85_colum3.setText(Dummy.getInstance().shell_day_18.get(4) + " ");
            tv_e85_colum4.setText(Dummy.getInstance().esso_day_18.get(4) + " ");

            //Row6
            tv_ds_colum1.setText(Dummy.getInstance().ptt_day_18.get(5) + " ");
            tv_ds_colum2.setText(Dummy.getInstance().bangjak_day_18.get(5) + " ");
            tv_ds_colum3.setText(Dummy.getInstance().shell_day_18.get(5) + " ");
            tv_ds_colum4.setText(Dummy.getInstance().esso_day_18.get(05) + " ");


        } else if (day[0].equals("27")) {


            // Row1
            tv_bs_colum1.setText(Dummy.getInstance().ptt_day_27.get(0) + " ");
            tv_bs_colum2.setText(Dummy.getInstance().bangjak_day_27.get(0) + " ");
            tv_bs_colum3.setText(Dummy.getInstance().shell_day_27.get(0) + " ");
            tv_bs_colum4.setText(Dummy.getInstance().esso_day_27.get(0) + " ");

            // Row2
            tv_gsh95_colum1.setText(Dummy.getInstance().ptt_day_27.get(1) + " ");
            tv_gsh95_colum2.setText(Dummy.getInstance().bangjak_day_27.get(1) + " ");
            tv_gsh95_colum3.setText(Dummy.getInstance().shell_day_27.get(1) + " ");
            tv_gsh95_colum4.setText(Dummy.getInstance().esso_day_27.get(1) + " ");

            //Row3
            tv_gsh91_colum1.setText(Dummy.getInstance().ptt_day_27.get(2) + " ");
            tv_gsh91_colum2.setText(Dummy.getInstance().bangjak_day_27.get(2) + " ");
            tv_gsh91_colum3.setText(Dummy.getInstance().shell_day_27.get(2) + " ");
            tv_gsh91_colum4.setText(Dummy.getInstance().esso_day_27.get(2) + " ");


            // Row4
            tv_e20_colum1.setText(Dummy.getInstance().ptt_day_27.get(3) + " ");
            tv_e20_colum2.setText(Dummy.getInstance().bangjak_day_27.get(3) + " ");
            tv_e20_colum3.setText(Dummy.getInstance().shell_day_27.get(3) + " ");
            tv_e20_colum4.setText(Dummy.getInstance().esso_day_27.get(3) + " ");

            //Row5
            tv_e85_colum1.setText(Dummy.getInstance().ptt_day_27.get(4) + " ");
            tv_e85_colum2.setText(Dummy.getInstance().bangjak_day_27.get(4) + " ");
            tv_e85_colum3.setText(Dummy.getInstance().shell_day_27.get(4) + " ");
            tv_e85_colum4.setText(Dummy.getInstance().esso_day_27.get(4) + " ");

            //Row6
            tv_ds_colum1.setText(Dummy.getInstance().ptt_day_27.get(5) + " ");
            tv_ds_colum2.setText(Dummy.getInstance().bangjak_day_27.get(5) + " ");
            tv_ds_colum3.setText(Dummy.getInstance().shell_day_27.get(5) + " ");
            tv_ds_colum4.setText(Dummy.getInstance().esso_day_27.get(5) + " ");

        }
    }
}






