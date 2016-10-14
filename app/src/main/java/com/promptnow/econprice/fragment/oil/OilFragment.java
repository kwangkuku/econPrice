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
public class OilFragment extends android.support.v4.app.DialogFragment implements DatePickerFragment.onSetDateListener {
    private View rootView;
    private Typeface font;
    private TextView tv_date_oil_price, date, tv, tv2, tv3, tv4, tv5, tv6, tv7,
            tv_bensin_ptt, tv_bensin_bangjak, tv_bensin_shell, tv_bensin_esso,
            tv_gasohol95_ptt, tv_gasohol95_bangjak, tv_gasohol95_shell, tv_gasohol95_esso,
            tv_gasohol91_ptt, tv_gasohol91_bangjak, tv_gasohol91_shell, tv_gasohol91_esso,
            tv_e20_ptt, tv_e20_bangjak, tv_e20_shell, tv_e20_esso,
            tv_e85_ptt, tv_e85_bangjak, tv_e85_shell, tv_e85_esso,
            tv_diesel_ptt, tv_diesel_bangjak, tv_diesel_shell, tv_diesel_esso,
            show_vs1, show_vs2, tv_show_result,
    //เปลี่ยน font
            colum1, colum2, colum3, colum4, colum5, colum6, colum7, colum8, colum9, colum10,
            colum11, colum12, colum13, colum14,colum15, colum16, colum17, colum18, colum19,
            colum20, colum21, colum22, colum23, colum24;

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

//row
        tv_bensin_ptt = (TextView) rootView.findViewById(R.id.tv_bensin_ptt);
        tv_bensin_bangjak = (TextView) rootView.findViewById(R.id.tv_bensin_bangjak);
        tv_bensin_shell = (TextView) rootView.findViewById(R.id.tv_bensin_shell);
        tv_bensin_esso = (TextView) rootView.findViewById(R.id.tv_bensin_esso);

        tv_gasohol95_ptt = (TextView) rootView.findViewById(R.id.tv_gasohol95_ptt);
        tv_gasohol95_bangjak = (TextView) rootView.findViewById(R.id.tv_gasohol95_bangjak);
        tv_gasohol95_shell = (TextView) rootView.findViewById(R.id.tv_gasohol95_shell);
        tv_gasohol95_esso = (TextView) rootView.findViewById(R.id.tv_gasohol95_esso);

        tv_gasohol91_ptt = (TextView) rootView.findViewById(R.id.tv_gasohol91_ptt);
        tv_gasohol91_bangjak = (TextView) rootView.findViewById(R.id.tv_gasohol91_bangjak);
        tv_gasohol91_shell = (TextView) rootView.findViewById(R.id.tv_gasohol91_shell);
        tv_gasohol91_esso = (TextView) rootView.findViewById(R.id.tv_gasohol91_esso);

        tv_e20_ptt = (TextView) rootView.findViewById(R.id.tv_e20_ptt);
        tv_e20_bangjak = (TextView) rootView.findViewById(R.id.tv_e20_bangjak);
        tv_e20_shell = (TextView) rootView.findViewById(R.id.tv_e20_shell);
        tv_e20_esso = (TextView) rootView.findViewById(R.id.tv_e20_esso);

        tv_e85_ptt = (TextView) rootView.findViewById(R.id.tv_e85_ptt);
        tv_e85_bangjak = (TextView) rootView.findViewById(R.id.tv_e85_bangjak);
        tv_e85_shell = (TextView) rootView.findViewById(R.id.tv_e85_shell);
        tv_e85_esso = (TextView) rootView.findViewById(R.id.tv_e85_esso);

        tv_diesel_ptt = (TextView) rootView.findViewById(R.id.tv_diesel_ptt);
        tv_diesel_bangjak = (TextView) rootView.findViewById(R.id.tv_diesel_bangjak);
        tv_diesel_shell = (TextView) rootView.findViewById(R.id.tv_diesel_shell);
        tv_diesel_esso = (TextView) rootView.findViewById(R.id.tv_diesel_esso);

        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);

//เปลี่ยน font
        colum1 = (TextView) rootView.findViewById(R.id.tv_bensin_ptt);
        colum2 = (TextView) rootView.findViewById(R.id.tv_bensin_bangjak);
        colum3 = (TextView) rootView.findViewById(R.id.tv_bensin_shell);
        colum4 = (TextView) rootView.findViewById(R.id.tv_bensin_esso);

        colum5 = (TextView) rootView.findViewById(R.id.tv_gasohol95_ptt);
        colum6 = (TextView) rootView.findViewById(R.id.tv_gasohol95_bangjak);
        colum7 = (TextView) rootView.findViewById(R.id.tv_gasohol95_shell);
        colum8 = (TextView) rootView.findViewById(R.id.tv_gasohol95_esso);

        colum9 = (TextView) rootView.findViewById(R.id.tv_gasohol91_ptt);
        colum10 = (TextView) rootView.findViewById(R.id.tv_gasohol91_bangjak);
        colum11 = (TextView) rootView.findViewById(R.id.tv_gasohol91_shell);
        colum12 = (TextView) rootView.findViewById(R.id.tv_gasohol91_esso);

        colum13 = (TextView) rootView.findViewById(R.id.tv_e20_ptt);
        colum14 = (TextView) rootView.findViewById(R.id.tv_e20_bangjak);
        colum15 = (TextView) rootView.findViewById(R.id.tv_e20_shell);
        colum16 = (TextView) rootView.findViewById(R.id.tv_e20_esso);

        colum17 = (TextView) rootView.findViewById(R.id.tv_e85_ptt);
        colum18 = (TextView) rootView.findViewById(R.id.tv_e85_bangjak);
        colum19 = (TextView) rootView.findViewById(R.id.tv_e85_shell);
        colum20 = (TextView) rootView.findViewById(R.id.tv_e85_esso);

        colum21 = (TextView) rootView.findViewById(R.id.tv_diesel_ptt);
        colum22 = (TextView) rootView.findViewById(R.id.tv_diesel_bangjak);
        colum23 = (TextView) rootView.findViewById(R.id.tv_diesel_shell);
        colum24 = (TextView) rootView.findViewById(R.id.tv_diesel_esso);

//เปลี่ยน font
        date = (TextView) rootView.findViewById(R.id.date);
        tv = (TextView) rootView.findViewById(R.id.oil);
        tv2 = (TextView) rootView.findViewById(R.id.txt_bensin);
        tv3 = (TextView) rootView.findViewById(R.id.txt_gasohol95);
        tv4 = (TextView) rootView.findViewById(R.id.txt_gasohol91);
        tv5 = (TextView) rootView.findViewById(R.id.txt_e20);
        tv6 = (TextView) rootView.findViewById(R.id.txt_e85);
        tv7 = (TextView) rootView.findViewById(R.id.txt_diesel);
//เปลี่ยน font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        date.setTypeface(font);
        tv.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font);
        tv5.setTypeface(font);
        tv6.setTypeface(font);
        tv7.setTypeface(font);
        tv_date_oil_price.setTypeface(font);
        colum1.setTypeface(font);
        colum2.setTypeface(font);
        colum3.setTypeface(font);
        colum4.setTypeface(font);
        colum5.setTypeface(font);
        colum6.setTypeface(font);
        colum7.setTypeface(font);
        colum8.setTypeface(font);
        colum9.setTypeface(font);
        colum10.setTypeface(font);
        colum11.setTypeface(font);
        colum12.setTypeface(font);
        colum13.setTypeface(font);
        colum14.setTypeface(font);
        colum15.setTypeface(font);
        colum16.setTypeface(font);
        colum17.setTypeface(font);
        colum18.setTypeface(font);
        colum19.setTypeface(font);
        colum20.setTypeface(font);
        colum21.setTypeface(font);
        colum22.setTypeface(font);
        colum23.setTypeface(font);
        colum24.setTypeface(font);

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

        Log.d("Show Day", day[0]);
        Log.d("Show Month", day[1]);
        Log.d("Show Year", day[2]);
//       String d = date.substring(0, 2); ใช้ในกรณีที่วันที่มีค่าเป็น 23/1/2016 9 หลัก
// แต่ถ้าเป็น case ที่       วันที่มีค่าเป็น 8/1/2016  8 หลัก จะใช้   String d = date.substring(0, ๅ);

        Log.d(TAG, "perfeact day : " + day[0]);

        if (day[0].equals("10")) {

            // Row1
            tv_bensin_ptt.setText(Dummy.getInstance().ptt_day_10.get(0) + " ");
            tv_bensin_bangjak.setText(Dummy.getInstance().bangjak_day_10.get(0) + " ");
            tv_bensin_shell.setText(Dummy.getInstance().shell_day_10.get(0) + " ");
            tv_bensin_esso.setText(Dummy.getInstance().esso_day_10.get(0) + " ");

            // Row2
            tv_gasohol95_ptt.setText(Dummy.getInstance().ptt_day_10.get(1) + " ");
            tv_gasohol95_bangjak.setText(Dummy.getInstance().bangjak_day_10.get(1) + " ");
            tv_gasohol95_shell.setText(Dummy.getInstance().shell_day_10.get(1) + " ");
            tv_gasohol95_esso.setText(Dummy.getInstance().esso_day_10.get(1) + " ");

            //Row3
            tv_gasohol91_ptt.setText(Dummy.getInstance().ptt_day_10.get(2) + " ");
            tv_gasohol91_bangjak.setText(Dummy.getInstance().bangjak_day_10.get(2) + " ");
            tv_gasohol91_shell.setText(Dummy.getInstance().shell_day_10.get(2) + " ");
            tv_gasohol91_esso.setText(Dummy.getInstance().esso_day_10.get(2) + " ");

            // Row4
            tv_e20_ptt.setText(Dummy.getInstance().ptt_day_10.get(3) + " ");
            tv_e20_bangjak.setText(Dummy.getInstance().bangjak_day_10.get(3) + " ");
            tv_e20_shell.setText(Dummy.getInstance().shell_day_10.get(3) + " ");
            tv_e20_esso.setText(Dummy.getInstance().esso_day_10.get(3) + " ");

            //Row5
            tv_e85_ptt.setText(Dummy.getInstance().ptt_day_10.get(4) + " ");
            tv_e85_bangjak.setText(Dummy.getInstance().bangjak_day_10.get(4) + " ");
            tv_e85_shell.setText(Dummy.getInstance().shell_day_10.get(4) + " ");
            tv_e85_esso.setText(Dummy.getInstance().esso_day_10.get(4) + " ");

            //Row6
            tv_diesel_ptt.setText(Dummy.getInstance().ptt_day_10.get(5) + " ");
            tv_diesel_bangjak.setText(Dummy.getInstance().bangjak_day_10.get(5) + " ");
            tv_diesel_shell.setText(Dummy.getInstance().shell_day_10.get(5) + " ");
            tv_diesel_esso.setText(Dummy.getInstance().esso_day_10.get(5) + " ");


        } else if (day[0].equals("18")) {

            // Row1
            tv_bensin_ptt.setText(Dummy.getInstance().ptt_day_18.get(0) + " ");
            tv_bensin_bangjak.setText(Dummy.getInstance().bangjak_day_18.get(0) + " ");
            tv_bensin_shell.setText(Dummy.getInstance().shell_day_18.get(0) + " ");
            tv_bensin_esso.setText(Dummy.getInstance().esso_day_18.get(0) + " ");

            // Row2
            tv_gasohol95_ptt.setText(Dummy.getInstance().ptt_day_18.get(1) + " ");
            tv_gasohol95_bangjak.setText(Dummy.getInstance().bangjak_day_18.get(1) + " ");
            tv_gasohol95_shell.setText(Dummy.getInstance().shell_day_18.get(1) + " ");
            tv_gasohol95_esso.setText(Dummy.getInstance().esso_day_18.get(1) + " ");

            //Row3
            tv_gasohol91_ptt.setText(Dummy.getInstance().ptt_day_18.get(2) + " ");
            tv_gasohol91_bangjak.setText(Dummy.getInstance().bangjak_day_18.get(2) + " ");
            tv_gasohol91_shell.setText(Dummy.getInstance().shell_day_18.get(2) + " ");
            tv_gasohol91_esso.setText(Dummy.getInstance().esso_day_18.get(2) + " ");

            // Row4
            tv_e20_ptt.setText(Dummy.getInstance().ptt_day_18.get(3) + " ");
            tv_e20_bangjak.setText(Dummy.getInstance().bangjak_day_18.get(3) + " ");
            tv_e20_shell.setText(Dummy.getInstance().shell_day_18.get(3) + " ");
            tv_e20_esso.setText(Dummy.getInstance().esso_day_18.get(3) + " ");

            //Row5
            tv_e85_ptt.setText(Dummy.getInstance().ptt_day_18.get(4) + " ");
            tv_e85_bangjak.setText(Dummy.getInstance().bangjak_day_18.get(4) + " ");
            tv_e85_shell.setText(Dummy.getInstance().shell_day_18.get(4) + " ");
            tv_e85_esso.setText(Dummy.getInstance().esso_day_18.get(4) + " ");

            //Row6
            tv_diesel_ptt.setText(Dummy.getInstance().ptt_day_18.get(5) + " ");
            tv_diesel_bangjak.setText(Dummy.getInstance().bangjak_day_18.get(5) + " ");
            tv_diesel_shell.setText(Dummy.getInstance().shell_day_18.get(5) + " ");
            tv_diesel_esso.setText(Dummy.getInstance().esso_day_18.get(5) + " ");


        } else if (day[0].equals("27")) {


            // Row1
            tv_bensin_ptt.setText(Dummy.getInstance().ptt_day_27.get(0) + " ");
            tv_bensin_bangjak.setText(Dummy.getInstance().bangjak_day_27.get(0) + " ");
            tv_bensin_shell.setText(Dummy.getInstance().shell_day_27.get(0) + " ");
            tv_bensin_esso.setText(Dummy.getInstance().esso_day_27.get(0) + " ");

            // Row2
            tv_gasohol95_ptt.setText(Dummy.getInstance().ptt_day_27.get(1) + " ");
            tv_gasohol95_bangjak.setText(Dummy.getInstance().bangjak_day_27.get(1) + " ");
            tv_gasohol95_shell.setText(Dummy.getInstance().shell_day_27.get(1) + " ");
            tv_gasohol95_esso.setText(Dummy.getInstance().esso_day_27.get(1) + " ");

            //Row3
            tv_gasohol91_ptt.setText(Dummy.getInstance().ptt_day_27.get(2) + " ");
            tv_gasohol91_bangjak.setText(Dummy.getInstance().bangjak_day_27.get(2) + " ");
            tv_gasohol91_shell.setText(Dummy.getInstance().shell_day_27.get(2) + " ");
            tv_gasohol91_esso.setText(Dummy.getInstance().esso_day_27.get(2) + " ");


            // Row4
            tv_e20_ptt.setText(Dummy.getInstance().ptt_day_27.get(3) + " ");
            tv_e20_bangjak.setText(Dummy.getInstance().bangjak_day_27.get(3) + " ");
            tv_e20_shell.setText(Dummy.getInstance().shell_day_27.get(3) + " ");
            tv_e20_esso.setText(Dummy.getInstance().esso_day_27.get(3) + " ");

            //Row5
            tv_e85_ptt.setText(Dummy.getInstance().ptt_day_27.get(4) + " ");
            tv_e85_bangjak.setText(Dummy.getInstance().bangjak_day_27.get(4) + " ");
            tv_e85_shell.setText(Dummy.getInstance().shell_day_27.get(4) + " ");
            tv_e85_esso.setText(Dummy.getInstance().esso_day_27.get(4) + " ");

            //Row6
            tv_diesel_ptt.setText(Dummy.getInstance().ptt_day_27.get(5) + " ");
            tv_diesel_bangjak.setText(Dummy.getInstance().bangjak_day_27.get(5) + " ");
            tv_diesel_shell.setText(Dummy.getInstance().shell_day_27.get(5) + " ");
            tv_diesel_esso.setText(Dummy.getInstance().esso_day_27.get(5) + " ");

        }
    }
}






