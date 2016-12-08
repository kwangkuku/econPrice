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
import com.promptnow.econprice.service.HttpManager;
import com.promptnow.econprice.service.OilExcelModel;
import com.promptnow.econprice.service.OilModel;
import com.promptnow.econprice.service.OilUserRequest;
import com.promptnow.econprice.view.DatePickerFragment;
import com.promptnow.econprice.view.UtilCalendar;

import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

public class OilFragment extends android.support.v4.app.DialogFragment implements DatePickerFragment.onSetDateListener {
    private View rootView;
    private Typeface font;
    private TextView tv_date_oil_price, date, tv, tv2, tv3, tv4, tv5, tv6, tv7,
            tv_bensin_ptt, tv_bensin_bangchak, tv_bensin_shell, tv_bensin_esso,
            tv_gasohol95_ptt, tv_gasohol95_bangchak, tv_gasohol95_shell, tv_gasohol95_esso,
            tv_gasohol91_ptt, tv_gasohol91_bangchak, tv_gasohol91_shell, tv_gasohol91_esso,
            tv_e20_ptt, tv_e20_bangchak, tv_e20_shell, tv_e20_esso,
            tv_e85_ptt, tv_e85_bangchak, tv_e85_shell, tv_e85_esso,
            tv_diesel_ptt, tv_diesel_bangchak, tv_diesel_shell, tv_diesel_esso,
            show_vs1, show_vs2, tv_show_result,
    //เปลี่ยน font
    colum1, colum2, colum3, colum4, colum5, colum6, colum7, colum8, colum9, colum10,
            colum11, colum12, colum13, colum14, colum15, colum16, colum17, colum18, colum19,
            colum20, colum21, colum22, colum23, colum24;

    private int selectedYear;
    private int selectedMonth;
    private int selectedDay;
    public DatePickerFragment.onSetDateListener mListener;
    private int year;
    private int month;
    private int day;
    private String stringOfDate;
    private OilExcelModel oilExcelModel;

    public interface onSetDateListener {
        void setDate(int year, int month, int day);
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil, container, false);
        setOilService();
        setView();

        setDataService();
        //setDataExcelService();


        return rootView;
    }


//    private void setDataExcelService() {
//        //call data by ExcelService
//        Call<OilExcelModel> call = HttpManager.getInstance().getOilExcelUser().loadJson();
//        call.enqueue(new Callback<OilExcelModel>() {
//            @Override
//            public void onResponse(Call<OilExcelModel> call, Response<OilExcelModel> response) {
//                 OilExcelModel oilExcelModel = response.body();
//                Log.d(TAG, "onResponse: " + response.body().getOilExcelModel());
//
//
//
//
//            }
//
//            @Override
//            public void onFailure(Call<OilExcelModel> call, Throwable t) {
//                Log.d(TAG, "onFailure:  " + t.toString());
//            }
//        });
//
//    }

    private void setOilExcelService(final String date) {
        Call<OilExcelModel> call = HttpManager.getInstance().getOilExcelUser().loadJson();
        call.enqueue(new Callback<OilExcelModel>() {
            @Override
            public void onResponse(Call<OilExcelModel> call, Response<OilExcelModel> response) {
                oilExcelModel = response.body();
                Log.d(TAG, "onResponse: " + response.body().getOilExcelModel());

                //PTT
                tv_bensin_ptt.setText(oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt //เบนซิล 95
                tv_gasohol95_ptt.setText(oilExcelModel.getOilExcelModel().get(1).getOilPrice());
                tv_gasohol91_ptt.setText(oilExcelModel.getOilExcelModel().get(2).getOilPrice());
                tv_e20_ptt.setText(oilExcelModel.getOilExcelModel().get(3).getOilPrice());
                tv_e85_ptt.setText(oilExcelModel.getOilExcelModel().get(4).getOilPrice());
                tv_diesel_ptt.setText(oilExcelModel.getOilExcelModel().get(5).getOilPrice());

                //BANGCHAK
                tv_bensin_bangchak.setText("-");//ไม่ขาย
                tv_gasohol95_bangchak.setText(oilExcelModel.getOilExcelModel().get(7).getOilPrice());
                tv_gasohol91_bangchak.setText(oilExcelModel.getOilExcelModel().get(8).getOilPrice());
                tv_e20_bangchak.setText(oilExcelModel.getOilExcelModel().get(9).getOilPrice());
                tv_e85_bangchak.setText(oilExcelModel.getOilExcelModel().get(10).getOilPrice());
                tv_diesel_bangchak.setText(oilExcelModel.getOilExcelModel().get(11).getOilPrice());

                //SHELL
                tv_bensin_shell.setText("-");//ไม่ขาย
                tv_gasohol95_shell.setText("-");
                tv_gasohol91_shell.setText(oilExcelModel.getOilExcelModel().get(14).getOilPrice());
                tv_e20_shell.setText(oilExcelModel.getOilExcelModel().get(15).getOilPrice());
                tv_e85_shell.setText("-"); // ไม่ขาย
                tv_diesel_shell.setText(oilExcelModel.getOilExcelModel().get(17).getOilPrice());

                //ESSO
                tv_bensin_esso.setText(oilExcelModel.getOilExcelModel().get(18).getOilPrice());
                tv_gasohol95_esso.setText(oilExcelModel.getOilExcelModel().get(19).getOilPrice());
                tv_gasohol91_esso.setText(oilExcelModel.getOilExcelModel().get(20).getOilPrice());
                tv_e20_esso.setText(oilExcelModel.getOilExcelModel().get(21).getOilPrice());
                tv_e85_esso.setText("-");// ไม่ขาย
                tv_diesel_esso.setText(oilExcelModel.getOilExcelModel().get(23).getOilPrice());


            }

            @Override
            public void onFailure(Call<OilExcelModel> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });


    }


    private void setDataService() {
        //call data by service

        Call<OilModel> call = HttpManager.getInstance().getOilUser().loadJson();
        call.enqueue(new Callback<OilModel>() {
            @Override
            public void onResponse(Call<OilModel> call, Response<OilModel> response) {

                OilModel oilModel = response.body();

                for (int i = 0; i < 34; i++) {
                    Log.d(TAG, "onResponse: " + oilModel.getOilModel().get(i).getOilPrice()

                    );
                }
                //PTT
                tv_bensin_ptt.setText(response.body().getOilModel().get(4).getOilPrice());
                tv_gasohol95_ptt.setText(response.body().getOilModel().get(0).getOilPrice());
                tv_gasohol91_ptt.setText(response.body().getOilModel().get(3).getOilPrice());
                tv_e20_ptt.setText(response.body().getOilModel().get(1).getOilPrice());
                tv_e85_ptt.setText(response.body().getOilModel().get(2).getOilPrice());
                tv_diesel_ptt.setText(response.body().getOilModel().get(6).getOilPrice());

                //BANGCHAK
                tv_bensin_bangchak.setText("-");
                //tv_bensin_bangchak.setText(response.body().getOilModel().get(13).getOilPrice());    //blank
                tv_gasohol95_bangchak.setText(response.body().getOilModel().get(9).getOilPrice());
                tv_gasohol91_bangchak.setText(response.body().getOilModel().get(12).getOilPrice());
                tv_e20_bangchak.setText(response.body().getOilModel().get(10).getOilPrice());
                tv_e85_bangchak.setText(response.body().getOilModel().get(11).getOilPrice());
                tv_diesel_bangchak.setText(response.body().getOilModel().get(15).getOilPrice());

                //SHELL
                tv_bensin_shell.setText("-");
                //tv_bensin_shell.setText(response.body().getOilModel().get(22).getOilPrice());   //blank
                tv_gasohol95_shell.setText(response.body().getOilModel().get(18).getOilPrice());
                tv_gasohol91_shell.setText(response.body().getOilModel().get(21).getOilPrice());
                tv_e20_shell.setText(response.body().getOilModel().get(19).getOilPrice());
                tv_e85_shell.setText("-");
                //tv_e85_shell.setText(response.body().getOilModel().get(20).getOilPrice());  //blank
                tv_diesel_shell.setText(response.body().getOilModel().get(24).getOilPrice());

                //ESSO
                tv_bensin_esso.setText(response.body().getOilModel().get(30).getOilPrice());
                tv_gasohol95_esso.setText(response.body().getOilModel().get(26).getOilPrice());
                tv_gasohol91_esso.setText(response.body().getOilModel().get(29).getOilPrice());
                tv_e20_esso.setText(response.body().getOilModel().get(27).getOilPrice());
                tv_e85_esso.setText("-");
                //tv_e85_esso.setText(response.body().getOilModel().get(28).getOilPrice());   //blank
                tv_diesel_esso.setText(response.body().getOilModel().get(32).getOilPrice());


            }

            @Override
            public void onFailure(Call<OilModel> call, Throwable t) {

            }
        });

    }

    private void setOilService() {
        OilUserRequest user = new OilUserRequest();
        Call<OilModel> call = HttpManager.getInstance().getOilUser().loadJson();

        call.enqueue(new Callback<OilModel>() {
            @Override
            public void onResponse(Call<OilModel> call, Response<OilModel> response) {
                Log.d(TAG, "onResponse: " + response.body().getOilModel());

            }

            @Override
            public void onFailure(Call<OilModel> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });
    }


    public void setView() {
        final LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.table);
        tv_date_oil_price = (TextView) rootView.findViewById(R.id.tv_date_oil_price);

//row
        tv_bensin_ptt = (TextView) rootView.findViewById(R.id.tv_bensin_ptt);
        tv_bensin_bangchak = (TextView) rootView.findViewById(R.id.tv_bensin_bangchak);
        tv_bensin_shell = (TextView) rootView.findViewById(R.id.tv_bensin_shell);
        tv_bensin_esso = (TextView) rootView.findViewById(R.id.tv_bensin_esso);

        tv_gasohol95_ptt = (TextView) rootView.findViewById(R.id.tv_gasohol95_ptt);
        tv_gasohol95_bangchak = (TextView) rootView.findViewById(R.id.tv_gasohol95_bangchak);
        tv_gasohol95_shell = (TextView) rootView.findViewById(R.id.tv_gasohol95_shell);
        tv_gasohol95_esso = (TextView) rootView.findViewById(R.id.tv_gasohol95_esso);

        tv_gasohol91_ptt = (TextView) rootView.findViewById(R.id.tv_gasohol91_ptt);
        tv_gasohol91_bangchak = (TextView) rootView.findViewById(R.id.tv_gasohol91_bangchak);
        tv_gasohol91_shell = (TextView) rootView.findViewById(R.id.tv_gasohol91_shell);
        tv_gasohol91_esso = (TextView) rootView.findViewById(R.id.tv_gasohol91_esso);

        tv_e20_ptt = (TextView) rootView.findViewById(R.id.tv_e20_ptt);
        tv_e20_bangchak = (TextView) rootView.findViewById(R.id.tv_e20_bangchak);
        tv_e20_shell = (TextView) rootView.findViewById(R.id.tv_e20_shell);
        tv_e20_esso = (TextView) rootView.findViewById(R.id.tv_e20_esso);

        tv_e85_ptt = (TextView) rootView.findViewById(R.id.tv_e85_ptt);
        tv_e85_bangchak = (TextView) rootView.findViewById(R.id.tv_e85_bangchak);
        tv_e85_shell = (TextView) rootView.findViewById(R.id.tv_e85_shell);
        tv_e85_esso = (TextView) rootView.findViewById(R.id.tv_e85_esso);

        tv_diesel_ptt = (TextView) rootView.findViewById(R.id.tv_diesel_ptt);
        tv_diesel_bangchak = (TextView) rootView.findViewById(R.id.tv_diesel_bangchak);
        tv_diesel_shell = (TextView) rootView.findViewById(R.id.tv_diesel_shell);
        tv_diesel_esso = (TextView) rootView.findViewById(R.id.tv_diesel_esso);

        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);

//เปลี่ยน font
        colum1 = (TextView) rootView.findViewById(R.id.tv_bensin_ptt);
        colum2 = (TextView) rootView.findViewById(R.id.tv_bensin_bangchak);
        colum3 = (TextView) rootView.findViewById(R.id.tv_bensin_shell);
        colum4 = (TextView) rootView.findViewById(R.id.tv_bensin_esso);

        colum5 = (TextView) rootView.findViewById(R.id.tv_gasohol95_ptt);
        colum6 = (TextView) rootView.findViewById(R.id.tv_gasohol95_bangchak);
        colum7 = (TextView) rootView.findViewById(R.id.tv_gasohol95_shell);
        colum8 = (TextView) rootView.findViewById(R.id.tv_gasohol95_esso);

        colum9 = (TextView) rootView.findViewById(R.id.tv_gasohol91_ptt);
        colum10 = (TextView) rootView.findViewById(R.id.tv_gasohol91_bangchak);
        colum11 = (TextView) rootView.findViewById(R.id.tv_gasohol91_shell);
        colum12 = (TextView) rootView.findViewById(R.id.tv_gasohol91_esso);

        colum13 = (TextView) rootView.findViewById(R.id.tv_e20_ptt);
        colum14 = (TextView) rootView.findViewById(R.id.tv_e20_bangchak);
        colum15 = (TextView) rootView.findViewById(R.id.tv_e20_shell);
        colum16 = (TextView) rootView.findViewById(R.id.tv_e20_esso);

        colum17 = (TextView) rootView.findViewById(R.id.tv_e85_ptt);
        colum18 = (TextView) rootView.findViewById(R.id.tv_e85_bangchak);
        colum19 = (TextView) rootView.findViewById(R.id.tv_e85_shell);
        colum20 = (TextView) rootView.findViewById(R.id.tv_e85_esso);

        colum21 = (TextView) rootView.findViewById(R.id.tv_diesel_ptt);
        colum22 = (TextView) rootView.findViewById(R.id.tv_diesel_bangchak);
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
        Log.d(TAG, "DATE: " + stringOfDate);
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
            setWhenDateChange(date);
            //เมื่อมีการเปลี่ยนแปลงวันที่

        }
    }

    private void setWhenDateChange(String date) {


        String d = date.substring(0,10);
        //String m = date.substring(3, 4);

        String day[] = date.split("/");

        Log.d("Show Day", day[0]);
        Log.d("Show Month", day[1]);
        Log.d("Show Year", day[2]);
        Log.d(TAG, "perfect day : " + d);

        if (d.equals("23/11/2016")) {
            setOilExcelService(date);

        }



    }


}






