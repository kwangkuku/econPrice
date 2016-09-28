package com.promptnow.econprice.fragment.oil;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.oil.data_dummy.Dummy;
import com.promptnow.econprice.view.DatePickerFragment;
import com.promptnow.econprice.view.UtilCalendar;

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by Whankung on 7/9/2559.
 */

public class OilFragment2 extends Fragment implements DatePickerFragment.onSetDateListener {
    private View rootView;
    private Typeface font;
    private Spinner oilTypeSpinner;
    private TextView tv_date_oil_vs, tv, tv2, tv3, tv4;
    private TextView show_vs1, show_vs2, tv_show_result;
    private ImageView img_vs1, img_vs2;
    private int year;
    private int month;
    private int day;
    double vs1, vs2;
    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    public DatePickerFragment.onSetDateListener mListener;
    //Date Picker
    double vs1_day_10 = 23.45, vs2_day_10 = 25.77;
    double vs1_day_18 = 31.56, vs2_day_18 = 29.91;
    double vs1_day_27 = 26.77, vs2_day_27 = 26.56;
    double result_change_spinner_and_datepicker;


    double result_vs_popup;
    //ผู้ใช้เลือกค่าใน pop-up ตัวไหน
    private String check_click_popup = "1"; //ฝั่งขวา img_vs1 = 1 ; ฝั่งซ้าย img_vs2 = 2;
    private String check_choice_popup1 = "1"; //ค่าแรก ptt = 1; ค่าที่สอง bangjak = 2; ค่าที่สาม shell = 3; ค่าที่สี่ esso = 4;  ซ้าย
    private String check_choice_popup2 = "1"; // ขวา
    //
    private TextView textView5;
    //


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil2, container, false);

        setView();
        setOilTypeSpiner();
        setVSpopup();
        setShowResult();
        setCompair();
        return rootView;

    }

    private void setShowResult() {

    }


    //Date Picker
    private void setView() {
        tv_date_oil_vs = (TextView) rootView.findViewById(R.id.tv_date_oil_vs);
        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);
        img_vs1 = (ImageView) rootView.findViewById(R.id.img_vs1);
        img_vs2 = (ImageView) rootView.findViewById(R.id.img_vs2);

        //
        textView5 = (TextView) rootView.findViewById(R.id.textView5);


        //        เปลี่ยน font
        tv = (TextView) rootView.findViewById(R.id.date);
        tv2 = (TextView) rootView.findViewById(R.id.txt_oil_type);
        tv3 = (TextView) rootView.findViewById(R.id.tv3);
        tv4 = (TextView) rootView.findViewById(R.id.bath);

        //        เปลี่ยน font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font);

        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH);
        month += 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String stringOfDate = day + "/" + month + "/" + year;

        tv_date_oil_vs.setText(stringOfDate);
        setCurrentDate();


        tv_date_oil_vs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePikkerDialog();

            }


        });
        show_vs1.setText("31.76");
        show_vs2.setText("33.33");

    }

    private void showDatePikkerDialog() {
        DatePickerFragment picker = new DatePickerFragment(getActivity(), day, month, year);
        picker.mListener = OilFragment2.this;
        picker.show(getActivity().getFragmentManager(), "");

    }


    private void setCurrentDate() {
        final Calendar c = UtilCalendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);  //0;
        day = c.get(Calendar.DAY_OF_MONTH); //1;
    }


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
            tv_date_oil_vs.setText(date);

            setData(date, oilTypeSpinner.getSelectedItemPosition());

        }
    }

    private void setData(String date, Integer spinner_oil_type) {
        // reset text กดปฏิทินแล้วเปลี่ยนค่าที่ไหนบ้าง

        String day[] = date.split("/");
        Log.d("show result", day[0]);
        Log.d("show spinner", spinner_oil_type.toString());


        Log.d("Show Day", day[0]);
        Log.d("Show Month", day[1]);
        Log.d("Show Year", day[2]);

        //if ((day[0].equals("10")) && (spinner_oil_type == 0)) {

// เมื่อเปลี่ยนค่า date ใน date picker
        //test case 1 : day = 10, spinner oil type = sohol 95 , popup = bg & ptt
        if (day[0].equals("10")) { // date in date picker = 10 เปลี่ยนค่าวันที่เป็นวันที่10 , แต่ค่าเริ่มต้นยังเป็น เบนซิล(0) , pop-up "ptt" & "bangjak" อยู่
            // ดังนั้นค่าที่ตะแสดงใน show_vs1 และ show_vs2 จะเป็น
            show_vs1.setText(Dummy.getInstance().ptt_day_10.get(0) + " "); //31.44 is ptt bansin day 10
            show_vs2.setText(Dummy.getInstance().bangjak_day_10.get(0) + " "); //32.25 is bangjak day10
            setCompair();
        }
        if ((spinner_oil_type == 1)) { // ค่าใน spinner เป็น sohol 95 [โดยที่ Day = 10 และค่า pop-up ยังเป็น pop-up "ptt" & "bangjak" อยู่ ตามค่าเริ่มต้นตั้งแต่แรก]
            show_vs1.setText(Dummy.getInstance().ptt_day_10.get(1) + " "); //22.25 is ptt sohol95 day 10
            show_vs2.setText(Dummy.getInstance().bangjak_day_10.get(1) + " "); //23.66 is bangjak sohol95 day10
            setCompair();
        }

        //เลือกค่าใน pop-up โดยที่ ค่า Day = 10 ,ค่าใน spinner เป็น sohol 95  ซึ่งค่าใน pop-up เป็น ค่า bangjak & ptt
        if (check_click_popup.equals("1")) { //left  เลือก pop-up ตัวไหน
            if (check_choice_popup1.equals("2")) { //เลือกอะไรใน pop-up //ptt pump
                show_vs1.setText(Dummy.getInstance().bangjak_day_10.get(1) + " "); //bangjak day10 sohol95
//                show_vs2.setText(Dummy.getInstance().ptt_day_10.get(1) + " "); // ptt dat10 sohol95
                setCompair();
            }
            



        }

    }
//เมื่อเปลี่ยนค่าใน spinner
//        if ((spinner_oil_type == 1)){
//            show_vs1.setText("31..67");
//            show_vs2.setText("27.77");
//        }
//
//            if (check_click_popup.equals("1")) { //left  เลือก pop-up ตัวไหน
//                if (check_choice_popup1.equals("2")) { //เลือกอะไรใน pop-up //ptt pump
//                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(0) + " "); //เอาค่ามาแสดง
//                    show_vs2.setText(Dummy.getInstance().bangjak_day_10.get(0)+" ");
//                }
//
//
//            }
//
//            if (check_click_popup.equals("3")) { //right
//                if (check_choice_popup2.equals("4"))
//                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(0) + " ");
//
//            }


//        if ((day[0].equals("18")) && (spinner_oil_type == 2)) {
//
//            if (check_click_popup.equals("1")) { //left  เลือก pop-up ตัวไหน
//                if (check_choice_popup1.equals("2")) { //เลือกอะไรใน pop-up
//                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(0) + " "); //เอาค่ามาแสดง //23.66
//                }
//
//            }
//
//            if (check_click_popup.equals("2")) { //right
//                if (check_choice_popup2.equals("4"))
//                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(0) + " "); //22.59
//
//            }
//
//            setCompair();
//
//        }


    private void setCompair() {
        double vs1 = Double.parseDouble(show_vs1.getText().toString());
        double vs2 = Double.parseDouble(show_vs2.getText().toString());

        tv_show_result.setText(Double.toString(vs1 - vs2));

        Log.d("Show ", show_vs1.getText().toString());
        Log.d("Show ", show_vs2.getText().toString());
        Log.d("Show ", String.valueOf(vs1 - vs2));


        if (result_change_spinner_and_datepicker < 0) {
            show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
        } else if (result_change_spinner_and_datepicker > 0) {
            show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
        }

    }


    private void setVSpopup() {

        img_vs1.setOnClickListener(new View.OnClickListener() {
                                       @Override
                                       public void onClick(View view) {

                                           final Dialog dialog = new Dialog(getActivity());
                                           dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                                           dialog.setContentView(R.layout.custom_dialog);
                                           dialog.setCancelable(true);

                                           final ImageView b1 = (ImageView) dialog.findViewById(R.id.b1);
                                           b1.setImageResource(Dummy.getInstance().popup.get(0));


                                           final ImageView b2 = (ImageView) dialog.findViewById(R.id.b2);
                                           b2.setImageResource(Dummy.getInstance().popup.get(1));


                                           final ImageView b3 = (ImageView) dialog.findViewById(R.id.b3);
                                           b3.setImageResource(Dummy.getInstance().popup.get(2));


                                           final ImageView b4 = (ImageView) dialog.findViewById(R.id.b4);
                                           b4.setImageResource(Dummy.getInstance().popup.get(3));

                                           check_click_popup = "1";

                                           b1.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   check_choice_popup1 = "1";
                                                   setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());

                                                   img_vs1.setImageResource(Dummy.getInstance().popup.get(0));
                                                   dialog.dismiss();


                                               }

                                           });


                                           b2.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   check_choice_popup1 = "2";
                                                   setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                                                   img_vs1.setImageResource(Dummy.getInstance().popup.get(1));

                                                   tv_show_result.setText(new DecimalFormat("0.00").format(+result_vs_popup));
                                                   dialog.dismiss();
                                                   //   img_vs2.setImageResource(R.drawable.ic_bangjak);
                                                   // img_vs2.setImageResource(R.drawable.ic_bangjak);


                                               }
                                           });

                                           b3.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   check_choice_popup1 = "3";
                                                   setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                                                   img_vs1.setImageResource(Dummy.getInstance().popup.get(2));

                                                   dialog.dismiss();
                                               }
                                           });
                                           dialog.show();

                                           b4.setOnClickListener(new View.OnClickListener() {

                                               @Override
                                               public void onClick(View view) {
                                                   check_choice_popup1 = "4";
                                                   setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                                                   img_vs1.setImageResource(Dummy.getInstance().popup.get(3));

                                                   dialog.dismiss();
                                               }
                                           });
                                           dialog.show();


                                       }
                                   }


        );


        img_vs2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                final Dialog dialog = new Dialog(getActivity());
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setCancelable(true);


                final ImageView b1 = (ImageView) dialog.findViewById(R.id.b1);
                b1.setImageResource(Dummy.getInstance().popup.get(0));

                final ImageView b2 = (ImageView) dialog.findViewById(R.id.b2);
                b2.setImageResource(Dummy.getInstance().popup.get(1));

                final ImageView b3 = (ImageView) dialog.findViewById(R.id.b3);
                b3.setImageResource(Dummy.getInstance().popup.get(2));

                final ImageView b4 = (ImageView) dialog.findViewById(R.id.b4);
                b4.setImageResource(Dummy.getInstance().popup.get(3));
                check_click_popup = "2";

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check_choice_popup2 = "1";
                        setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(0));

                        dialog.dismiss();

                    }
                });


                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check_choice_popup2 = "2";
                        setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(1));

                        dialog.dismiss();

                    }
                });


                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check_choice_popup2 = "3";
                        setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(2));

                        dialog.dismiss();
                    }
                });


                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check_choice_popup2 = "4";
                        setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(3));


                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });


    }

    private void getvalue() {
    }

//    private void setShowResult() {
//
//    }


    private void setOilTypeSpiner() {
        oilTypeSpinner = (Spinner) rootView.findViewById(R.id.oilTypeSpinner);
        //  oilTypeSpinner.setEnabled(false);
        String[] List = {"เบนซิล 95", "แก๊สโซฮอล์ 95", "แก๊สโซฮอล์ 91", "E20", "E85", "ดีเซล"};
        CustomAdapterOil oilAdapter = new CustomAdapterOil(getActivity(), List);
        oilTypeSpinner.setAdapter(oilAdapter);


        oilTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {

                setData(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

    }


}







