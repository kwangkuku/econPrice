package com.promptnow.econprice.fragment.oil;

import android.app.Dialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
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
    //popup
    double vs1_ptt = 10, vs2_ptt = 10;
    double vs1_bangjak = 20, vs2_bangjak = 20;
    double vs1_shell = 30, vs2_shell = 30;
    double vs1_esso = 40, vs2_esso = 40;
    double result_vs_popup;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil2, container, false);

        setView();
        setOilTypeSpiner();
        setVSpopup();
        //setShowResult();
        return rootView;

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
            setData(date);

        }
    }

    private void setData(String date) {
        // reset text กดปฏิทินแล้วเปลี่ยนค่าที่ไหนบ้าง

        String d = date.substring(0, 2);

        if (d.equals("10")) {
            show_vs1.setText("" + vs1_day_10);
            show_vs2.setText("" + vs2_day_10);

            result_change_spinner_and_datepicker = vs1_day_10 - vs2_day_10;

            tv_show_result.setText("" + result_change_spinner_and_datepicker);
            tv_show_result.setText(new DecimalFormat("0.00").format(+result_change_spinner_and_datepicker));
            if (result_change_spinner_and_datepicker < 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            } else if (result_change_spinner_and_datepicker > 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            }

        } else if (d.equals("18")) {
            show_vs1.setText("" + vs1_day_18);
            show_vs2.setText("" + vs2_day_18);
            result_change_spinner_and_datepicker = vs1_day_18 - vs2_day_18;

            tv_show_result.setText("" + result_change_spinner_and_datepicker);
            tv_show_result.setText(new DecimalFormat("0.00").format(+result_change_spinner_and_datepicker));
            if (result_change_spinner_and_datepicker < 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            } else if (result_change_spinner_and_datepicker > 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            }
        } else if (d.equals("27")) {
            show_vs1.setText("" + vs1_day_27);
            show_vs2.setText("" + vs2_day_27);

            result_change_spinner_and_datepicker = vs1_day_27 - vs2_day_27;

            tv_show_result.setText("" + result_change_spinner_and_datepicker);
            tv_show_result.setText(new DecimalFormat("0.00").format(+result_change_spinner_and_datepicker));
            if (result_change_spinner_and_datepicker < 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            } else if (result_change_spinner_and_datepicker > 0) {
                show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
                show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            }

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

                img_vs1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dialog.show();


                    }
                });


                final ImageView b1 = (ImageView) dialog.findViewById(R.id.b1);
                b1.setImageResource(Dummy.getInstance().popup.get(0));

                final ImageView b2 = (ImageView) dialog.findViewById(R.id.b2);
                b2.setImageResource(Dummy.getInstance().popup.get(1));

                final ImageView b3 = (ImageView) dialog.findViewById(R.id.b3);
                b3.setImageResource(Dummy.getInstance().popup.get(2));

                final ImageView b4 = (ImageView) dialog.findViewById(R.id.b4);
                b4.setImageResource(Dummy.getInstance().popup.get(3));


                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        img_vs1.setImageResource(Dummy.getInstance().popup.get(0));
                        show_vs1.setText("" + vs1_ptt);

                        tv_show_result.setText("" + result_vs_popup);
                        tv_show_result.setText(new DecimalFormat("0.00").format(+result_vs_popup));


//                        img_vs2.setImageResource(Dummy.getInstance().popup.get(0));
//
//                        img_vs1.setImageResource(Dummy.getInstance().popup.get(1));
//                        img_vs2.setImageResource(Dummy.getInstance().popup.get(0));
//
//                        b1.setImageResource(Dummy.getInstance().popup.get(0));
//                        b1.setImageResource(Dummy.getInstance().popup.get(2));
//                        b1.setImageResource(Dummy.getInstance().popup.get(3));

                        dialog.dismiss();

                    }

                });


                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs1.setImageResource(Dummy.getInstance().popup.get(1));
                        show_vs1.setText("" + vs1_bangjak);
                        tv_show_result.setText("" + result_vs_popup);
                        tv_show_result.setText(new DecimalFormat("0.00").format(+result_vs_popup));
                        dialog.dismiss();
                        //   img_vs2.setImageResource(R.drawable.ic_bangjak);

                        // img_vs2.setImageResource(R.drawable.ic_bangjak);


                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs1.setImageResource(Dummy.getInstance().popup.get(2));
                        show_vs1.setText("" + vs1_shell);
                        tv_show_result.setText("" + result_vs_popup);
                        dialog.dismiss();
                    }
                });
                dialog.show();

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs1.setImageResource(Dummy.getInstance().popup.get(3));
                        show_vs1.setText("" + vs1_esso);
                        tv_show_result.setText("" + result_vs_popup);
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


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

                b1.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(0));
                        show_vs2.setText("" + vs2_ptt);
                        tv_show_result.setText("" + result_vs_popup);
                        dialog.dismiss();

                    }
                });


                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(1));
                        show_vs2.setText("" + vs2_bangjak);
                        tv_show_result.setText("" + result_vs_popup);
                        dialog.dismiss();

                    }
                });


                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(2));
                        show_vs2.setText("" + vs2_shell);
                        tv_show_result.setText("" + result_vs_popup);
                        dialog.dismiss();
                    }
                });


                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(3));
                        show_vs2.setText("" + vs2_esso);
                        tv_show_result.setText("" + result_vs_popup);
                        dialog.dismiss();
                    }
                });
                dialog.show();

            }
        });


    }

//    private void setShowResult() {
//
//    }



    private void setOilTypeSpiner() {
        oilTypeSpinner = (Spinner) rootView.findViewById(R.id.oilTypeSpinner);
        //  oilTypeSpinner.setEnabled(false);
        String[] List = {"เบนซิล 95", "แก๊สโซฮอล์ 95", "E20", "E85", "ดีเซล"};
        CustomAdapterOil oilAdapter = new CustomAdapterOil(getActivity(), List);
        oilTypeSpinner.setAdapter(oilAdapter);


        oilTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {

                if (i == 0) {
                    vs1 = 31.76;
                    vs2 = 32.21;

                } else if (i == 1) {
                    vs1 = 35.76;
                    vs2 = 31.21;


                } else if (i == 2) {
                    vs1 = 38.36;
                    vs2 = 37.11;


                } else if (i == 3) {
                    vs1 = 11.54;
                    vs2 = 23.55;


                } else if (i == 4) {
                    vs1 = 52.54;
                    vs2 = 35.86;


                }
                setResult();
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

    }


    private void setResult() {
        show_vs1.setText("" + vs1);
        show_vs2.setText(" " + vs2);
        result_change_spinner_and_datepicker = vs1 - vs2;
        tv_show_result.setText(new DecimalFormat("0.00").format(+result_change_spinner_and_datepicker));
        tv_show_result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);


        if (result_change_spinner_and_datepicker < 0) {
            show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
        } else if (result_change_spinner_and_datepicker > 0) {
            show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
        }


    }


}







