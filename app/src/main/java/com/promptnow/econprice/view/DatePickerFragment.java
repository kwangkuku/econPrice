package com.promptnow.econprice.view;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

/**
 * Created by Admin on 9/9/2559.
 */

public class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    private Typeface font;
    private Context mContext;
    private TextView txt_title;
    private NumberPicker piker_day;
    private NumberPicker piker_month;
    private NumberPicker piker_year;
    private TextView btn_cancel;
    private TextView btn_ok;
    private int day;
    private int month;
    private int year;
    public onSetDateListener mListener;
    private TextView txt_date;
    private Calendar calendar;
    private String[] arrayMonthTH = new String[]{"มกราคม","กุมภาพันธ์","มีนาคม","เมษายน","พฤษภาคม","มิถุนายน","กรกฎาคม","สิงหาคม","กันยายน","ตุลาคม","พฤศจิกายน","ธันวาคม"};
    private String[] arrayMonthEN = new String[]{"January","February", "March","April", "May", "June","July", "August", "September","October","November","December"};
    private Boolean isSetRangeYear = false;
    private int rang_year,rang_year_brith_date;
    private Boolean hideDay = false;
    private Boolean isSetRangeYearForBirthDate = false;

    public interface onSetDateListener {

        void setDate(int day, int month, int year, String date, String dateFormat);
    }

    public DatePickerFragment(Context mContext, int day, int month, int year){
        this.mContext = mContext;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");

        final Dialog piker = new Dialog(getActivity());
        calendar = Calendar.getInstance();
        piker.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        piker.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        piker.setContentView(R.layout.custom_date_piker_dialog);
        piker.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        piker.show();
        setCancelable(false);
        txt_title = (TextView)piker.findViewById(R.id.txt_title);
//        txt_title.setTypeface(font);
        txt_date = (TextView)piker.findViewById(R.id.txt_date);
//        txt_date.setTypeface(font);
        txt_date.setText(getDate());
        btn_cancel = (TextView)piker.findViewById(R.id.btn_cancel);
        btn_cancel.setTypeface(font);
        btn_cancel.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                piker.dismiss();
            }
        });
        btn_ok = (TextView)piker.findViewById(R.id.btn_ok);
        btn_ok.setTypeface(font);
        btn_ok.setOnClickListener(new android.view.View.OnClickListener() {

            @Override
            public void onClick(android.view.View v) {
                mListener.setDate(day, month, year, getDate(), getDateFormat());
                System.out.println("Output >> "+day+"/"+month+"/"+year);
                piker.dismiss();
            }
        });

        piker_day = (NumberPicker)piker.findViewById(R.id.piker_day);
        piker_day.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        updateDay();
        piker_day.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub
                day = newVal;
                txt_date.setText(getDate());
            }
        });

        if (hideDay) {
            piker_day.setVisibility(android.view.View.GONE);
        }


        piker_month = (NumberPicker)piker.findViewById(R.id.piker_month);
        piker_month.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);

//        if (DataForShared.getLanguage().equals("TH")) {
//            piker_month.setDisplayedValues(arrayMonthTH);
//            piker_month.setMaxValue(arrayMonthTH.length -1);
//        }else {
        piker_month.setDisplayedValues(arrayMonthEN);
        piker_month.setMaxValue(arrayMonthEN.length -1);



//        }
        piker_month.setValue(month);
        piker_month.setWrapSelectorWheel(false);
        piker_month.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub
                month = newVal;
                updateDay();
            }
        });

        piker_year = (NumberPicker)piker.findViewById(R.id.piker_year);
        piker_year.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
        piker_year.setMinValue(calendar.get(Calendar.YEAR));
        piker_year.setMaxValue(calendar.get(Calendar.YEAR));
        piker_year.setValue(year);
        piker_year.setWrapSelectorWheel(false);
        piker_year.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {

            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                // TODO Auto-generated method stub
                year = newVal;
                updateDay();
            }
        });

        if (isSetRangeYear) {
            piker_year.setMinValue(calendar.get(Calendar.YEAR));
            piker_year.setMaxValue(calendar.get(Calendar.YEAR) + rang_year);
            piker_year.setValue(year);
            piker_year.setWrapSelectorWheel(false);
        }

        if (isSetRangeYearForBirthDate) {
            piker_year.setValue(calendar.get(Calendar.YEAR) - rang_year_brith_date);
            piker_year.setWrapSelectorWheel(false);
        }

        return piker;

    }

    private void updateDay(){

        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        piker_day.setMinValue(1);
        int dayOfMonth = c.getActualMaximum(Calendar.DATE);
        piker_day.setMaxValue(dayOfMonth);
        piker_day.setFormatter(new NumberPicker.Formatter() {

            @Override
            public String format(int value) {
                // TODO Auto-generated method stub
                return String.format("%2d", value);
            }
        });
        if (day > dayOfMonth) {
            day = dayOfMonth;
        }
        piker_day.setValue(day);
        piker_day.setWrapSelectorWheel(false);
        txt_date.setText(getDate());
    }

    private String getDate(){
        final Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        Format formatter = new SimpleDateFormat("dd/MM/yyyy");
        String date = formatter.format(c.getTime());
        String dateResult = "";
//        if (DataForShared.getLanguage().equals("TH")) {
//            if (hideDay) {
//                dateResult = arrayMonthTH[month] + date.substring(5);
//            }else {
//                dateResult = date.substring(0,3) + arrayMonthTH[month] + date.substring(5);
//            }
//        }else {
        if (hideDay) {
            dateResult = arrayMonthEN[month] + date.substring(5);
        }else {
            dateResult = new DecimalFormat("0").format(Integer.valueOf(date.substring(0,2))) + "/"
                    + new DecimalFormat("0").format(Integer.valueOf(date.substring(3,5)))
                    + date.substring(5);
        }
//        }
        return dateResult;
    }


    private String getDateFormat(){
        final Calendar C = Calendar.getInstance(Locale.US);
        C.set(Calendar.YEAR, year);
        C.set(Calendar.MONTH, month);
        C.set(Calendar.DAY_OF_MONTH, day);
        Format formatter;
        if (hideDay) {
            formatter = new SimpleDateFormat("MM/yyyy");
        }else {
            formatter = new SimpleDateFormat("dd/MM/yyyy");
        }
        String date = formatter.format(C.getTime());
        return date;
    }
    public void setRangeYear(int range_year){
        isSetRangeYear = true;
        this.rang_year = range_year;
    }

    public void setRangeYearForBirthDate(int rang_year_brith_date){
        isSetRangeYearForBirthDate = true;
        this.rang_year_brith_date = rang_year_brith_date;
        year = year-rang_year_brith_date;
    }


    public void onDateSet(DatePicker view, int year, int month, int day) {


    }

}