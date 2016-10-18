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

public class OilFragment2 extends Fragment implements DatePickerFragment.onSetDateListener {
    private View rootView;
    private Typeface font;
    private Spinner oilTypeSpinner;
    private TextView tv_date_oil_vs, tv, tv2, tv3, tv4, tv5, tv6, tv7;
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
    double resuit;

    double result_vs_popup;
    //ผู้ใช้เลือกค่าใน pop-up ตัวไหน
    private String check_click_popup = "1"; //ฝั่งขวา img_vs1 = 1 ; ฝั่งซ้าย img_vs2 = 2;
    private String check_choice_popup1 = "1"; //ค่าแรก ptt = 1; ค่าที่สอง bangjak = 2; ค่าที่สาม shell = 3; ค่าที่สี่ esso = 4;  ซ้าย
    private String check_choice_popup2 = "1"; // ขวา


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil2, container, false);

        setView(); // All By id
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

        //        เปลี่ยน font
        tv = (TextView) rootView.findViewById(R.id.date);
        tv2 = (TextView) rootView.findViewById(R.id.txt_oil_type);
        tv3 = (TextView) rootView.findViewById(R.id.tv3);
        tv4 = (TextView) rootView.findViewById(R.id.bath);
        tv5 = (TextView) rootView.findViewById(R.id.show_vs1);
        tv6 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv7 = (TextView) rootView.findViewById(R.id.tv_show_result);

        //        เปลี่ยน font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        tv.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font);
        tv5.setTypeface(font);
        tv6.setTypeface(font);
        tv7.setTypeface(font);
        tv_date_oil_vs.setTypeface(font);

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

        //ค่าเริ่มต้น defalf
        //Day = ToDay
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

        String day[] = date.split("/"); //split คือการแยก "ข้อความ"
        Log.d("show result", day[0]);
        Log.d("show spinner", spinner_oil_type.toString());

        Log.d("Show Day", day[0]);
        Log.d("Show Month", day[1]);
        Log.d("Show Year", day[2]);

        //RESET TEXT เมื่อมีค่าเปลี่ยนแปลง ( DatePicker , Spinner , Pop-up)ข้อมูลที่แสดงจะต้องเปลี่ยนค่าด้วย (show_vs1 , show_vs2 ,tv_show_result )
        //<1>   DatePicker -->   Day10 , Day18 , Day27
        //<2>   Spinner    -->   [0]Bensin  , [1]Sohol95  , [2]Sohol96  , [3]E20  , [4]E85  , [5]Disel
        //<3>   Pop-up     -->   [0]ptt , [1]bangjak , [2]shell , [3]esso
        //check ค่า สามอย่างแล้วเอามาแสดงผล <1> + <2> + <3> = SHOW!!!
        // * ใช้ DAY เป็นหลัก

//DAY 10
        //Day 10 , Spinner = [0]Bensin
        if ((day[0].equals("10")) && (spinner_oil_type == 0)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(0) + " "); // ptt เบนซิล
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(0) + " "); // bangjak เบนซฺล
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(0) + " "); // shell เบนซิล
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(0) + " "); // esso เบนซิล
                }
                //setCompair();

            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(0) + " "); // ptt เบนซิล
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(0) + " "); // bangchakak เบนซฺล
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(0) + " "); // shell เบนซิล
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(0) + " "); // esso เบนซิล
                }

            }

            setCompair();
        }
        //Day 10 , Spinner = [1]Sohol95
        else if ((day[0].equals("10")) && (spinner_oil_type == 1)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(1) + " "); // ptt  Sohol95
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(1) + " "); // bangchak  Sohol95
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(1) + " "); // shell  Sohol95
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(1) + " "); // esso  Sohol95
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(1) + " "); // ptt  Sohol95
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(1) + " "); // bangchak  Sohol95
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(1) + " "); // shell  Sohol95
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(1) + " "); // esso  Sohol95
                }

            }
            setCompair();

            //Day 10 , Spinner = [2]Sohol96
        } else if ((day[0].equals("10")) && (spinner_oil_type == 2)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(2) + " "); // ptt Sohol96
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(2) + " "); // bangchak  Sohol96
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(2) + " "); // shell  Sohol96
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(2) + " "); // esso  Sohol96
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) {
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(2) + " "); // ptt  Sohol96
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(2) + " "); // bangchak  Sohol96
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(2) + " "); // shell  Sohol96
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(2) + " "); // esso  Sohol96
                }
                setCompair();
            }

        } //Day 10 , Spinner = [3]E20
        else if ((day[0].equals("10")) && (spinner_oil_type == 3)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(3) + " "); // ptt E20
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(3) + " "); // bangchak E20
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(3) + " "); // shell E20
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(3) + " "); // esso E20
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(3) + " "); // ptt E20
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(3) + " "); // bangchak  E20
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(3) + " "); // shell  E20
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(3) + " "); // esso  E20
                }
                setCompair();
            }

        } else if ((day[0].equals("10")) && (spinner_oil_type == 4)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(4) + " "); // ptt E85
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(4) + " "); // bangchak E85
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(4) + " "); // shell E85
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(4) + " "); // esso E85
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(4) + " "); // ptt E85
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(4) + " "); // bangchak  E85
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(4) + " "); // shell  E85
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(4) + " "); // esso  E85
                }
                setCompair();
            }
        }
        //Day 10 , Spinner = [5]Disel
        else if ((day[0].equals("10")) && (spinner_oil_type == 5)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(5) + " "); // ptt Disel
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(5) + " "); // bangchak Disel
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(5) + " "); // shell Disel
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(5) + " "); // esso Disel
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(5) + " "); // ptt Disel
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(5) + " "); // bangchak  Disel
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(5) + " "); // shell  Disel
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(5) + " "); // esso  Disel
                }
                setCompair();
            }
        }

//DAY 18
        //Day 18 , Spinner = [0]Bensin
        if ((day[0].equals("10")) && (spinner_oil_type == 0)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(0) + " "); // ptt เบนซิล
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(0) + " "); // bangchak เบนซฺล
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(0) + " "); // shell เบนซิล
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(0) + " "); // esso เบนซิล
                }
                //setCompair();

            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(0) + " "); // ptt เบนซิล
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(0) + " "); // bangchak เบนซฺล
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(0) + " "); // shell เบนซิล
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(0) + " "); // esso เบนซิล
                }

            }

            setCompair();
        }
        //Day 18 , Spinner = [1]Sohol95
        else if ((day[0].equals("18")) && (spinner_oil_type == 1)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(1) + " "); // ptt  Sohol95
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(1) + " "); // bangchak  Sohol95
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(1) + " "); // shell  Sohol95
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(1) + " "); // esso  Sohol95
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(1) + " "); // ptt  Sohol95
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(1) + " "); // bangchak  Sohol95
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(1) + " "); // shell  Sohol95
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(1) + " "); // esso  Sohol95
                }

            }
            setCompair();

            //Day 18 , Spinner = [2]Sohol96
        } else if ((day[0].equals("18")) && (spinner_oil_type == 2)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(2) + " "); // ptt Sohol96
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(2) + " "); // bangchak  Sohol96
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(2) + " "); // shell  Sohol96
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(2) + " "); // esso  Sohol96
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) {
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(2) + " "); // ptt  Sohol96
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(2) + " "); // bangchak Sohol96
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(2) + " "); // shell  Sohol96
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(2) + " "); // esso  Sohol96
                }
                setCompair();
            }

        } //Day 18 , Spinner = [3]E20
        else if ((day[0].equals("18")) && (spinner_oil_type == 3)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(3) + " "); // ptt E20
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(3) + " "); // bangchak E20
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(3) + " "); // shell E20
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(3) + " "); // esso E20
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(3) + " "); // ptt E20
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(3) + " "); // bangchak  E20
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(3) + " "); // shell  E20
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(3) + " "); // esso  E20
                }
                setCompair();
            }

        } else if ((day[0].equals("18")) && (spinner_oil_type == 4)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(4) + " "); // ptt E85
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(4) + " "); // bangchak E85
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(4) + " "); // shell E85
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(4) + " "); // esso E85
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(4) + " "); // ptt E85
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(4) + " "); // bangchak  E85
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(4) + " "); // shell  E85
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(4) + " "); // esso  E85
                }
                setCompair();
            }
        }
        //Day 18 , Spinner = [5]Disel
        else if ((day[0].equals("18")) && (spinner_oil_type == 5)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(5) + " "); // ptt Disel
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(5) + " "); // bangchak Disel
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(5) + " "); // shell Disel
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(5) + " "); // esso Disel
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(5) + " "); // ptt Disel
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(5) + " "); // bangchak Disel
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(5) + " "); // shell  Disel
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(5) + " "); // esso  Disel
                }
                setCompair();
            }
        }
        //DAY 27
        //Day 27 , Spinner = [0]Bensin
        if ((day[0].equals("27")) && (spinner_oil_type == 0)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(0) + " "); // ptt เบนซิล
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(0) + " "); // bangchak เบนซฺล
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(0) + " "); // shell เบนซิล
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(0) + " "); // esso เบนซิล
                }
                //setCompair();

            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(0) + " "); // ptt เบนซิล
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(0) + " "); // bangchak เบนซฺล
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(0) + " "); // shell เบนซิล
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(0) + " "); // esso เบนซิล
                }

            }

            setCompair();
        }
        //Day 27 , Spinner = [1]Sohol95
        else if ((day[0].equals("27")) && (spinner_oil_type == 1)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(1) + " "); // ptt  Sohol95
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(1) + " "); // bangchak  Sohol95
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(1) + " "); // shell  Sohol95
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(1) + " "); // esso  Sohol95
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(1) + " "); // ptt  Sohol95
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(1) + " "); // bangchak  Sohol95
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(1) + " "); // shell  Sohol95
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(1) + " "); // esso  Sohol95
                }

            }
            setCompair();

            //Day 27 , Spinner = [2]Sohol96
        } else if ((day[0].equals("27")) && (spinner_oil_type == 2)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(2) + " "); // ptt Sohol96
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(2) + " "); // bangchak  Sohol96
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(2) + " "); // shell  Sohol96
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(2) + " "); // esso  Sohol96
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) {
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(2) + " "); // ptt  Sohol96
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(2) + " "); // bangchak  Sohol96
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(2) + " "); // shell  Sohol96
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(2) + " "); // esso  Sohol96
                }
                setCompair();
            }

        } //Day 27 , Spinner = [3]E20
        else if ((day[0].equals("27")) && (spinner_oil_type == 3)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(3) + " "); // ptt E20
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(3) + " "); // bangchak E20
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(3) + " "); // shell E20
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(3) + " "); // esso E20
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(3) + " "); // ptt E20
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(3) + " "); // bangchak  E20
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(3) + " "); // shell  E20
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(3) + " "); // esso  E20
                }
                setCompair();
            }

        } else if ((day[0].equals("27")) && (spinner_oil_type == 4)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(4) + " "); // ptt E85
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(4) + " "); // bangchak E85
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(4) + " "); // shell E85
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(4) + " "); // esso E85
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(4) + " "); // ptt E85
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(4) + " "); // bangchak  E85
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(4) + " "); // shell  E85
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(4) + " "); // esso  E85
                }
                setCompair();
            }
        }
        //Day 27 , Spinner = [5]Disel
        else if ((day[0].equals("27")) && (spinner_oil_type == 5)) {
            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
                //เลือกค่าไหนใน Pop-up
                if (check_choice_popup1.equals("1")) {
                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(5) + " "); // ptt Disel
                } else if (check_choice_popup1.equals("2")) {
                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(5) + " "); // bangchak Disel
                } else if (check_choice_popup1.equals("3")) {
                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(5) + " "); // shell Disel
                } else if (check_choice_popup1.equals("4")) {
                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(5) + " "); // esso Disel
                }
                // setCompair();
            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
                if (check_choice_popup2.equals("1")) {
                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(5) + " "); // ptt Disel
                } else if (check_choice_popup2.equals("2")) {
                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(5) + " "); // bangchak  Disel
                } else if (check_choice_popup2.equals("3")) {
                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(5) + " "); // shell  Disel
                } else if (check_choice_popup2.equals("4")) {
                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(5) + " "); // esso  Disel
                }
                setCompair();
            }
        }

    }


    private void setCompair() {
//เมธอด setCompair จะเอา ตัวแปร show_vs1 และ show_vs2 ที่มีชิดตัวแปรเป็น String มา getText() ให้เป็น Double

        double vs1 = Double.parseDouble(show_vs1.getText().toString());
        double vs2 = Double.parseDouble(show_vs2.getText().toString());
// เพื่อจะได้เอามาหา ผลต่างได้
// แล้วเราจะหาผลต่าง จากการเอาค่า vs1 vs2 มาลบกัน โดยจะเก็บค่าที่ได้มาไว้ใน ตัวแปร result_num  ที่มีค่าเป็น double
        double result_num = vs1 - vs2;

        Log.d("Show ", show_vs1.getText().toString());
        Log.d("Show ", show_vs2.getText().toString());
        Log.d("Show ", String.valueOf(vs1 - vs2));

// หลังจากนั้น เราก็จะเอา result_num ที่ได้จากการหาผลต่างมา set format ให้เป็นค่าทศนิยมสองตำปหน่ง หลังจากนั้น ให้ set ค่านี้ลงไปที่ textview tv_show_result (แสดงค่า)
        tv_show_result.setText(new DecimalFormat("0.00").format(+result_num));


        if (tv_show_result.getText().length() < 0) {
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
        } else if (tv_show_result.getText().length() > 0) {
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));

            // ในกรณีที่ค่าที่เปรียบเทียบทั้งสองฝั่งเท่ากัน ไม่มีการแสดงสีที่ล่าง pop-up
        }else if (tv_show_result.getText().length() == 0){
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));

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













