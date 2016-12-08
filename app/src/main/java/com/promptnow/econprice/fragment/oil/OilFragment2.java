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
import com.promptnow.econprice.service.HttpManager;
import com.promptnow.econprice.service.OilExcelModel;
import com.promptnow.econprice.service.OilModel;
import com.promptnow.econprice.service.OilUserRequest;
import com.promptnow.econprice.view.DatePickerFragment;
import com.promptnow.econprice.view.UtilCalendar;

import java.text.DecimalFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class OilFragment2 extends Fragment implements DatePickerFragment.onSetDateListener {
    private View rootView;
    private Typeface font;
    private Spinner oilTypeSpinner;
    private TextView tv_date_oil_vs, tv, tv2, tv3, tv4, tv5, tv6, tv7;
    private TextView show_vs1, show_vs2, tv_show_result, remark, tv_dot_remark_right, tv_dot_remark_left;
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
    private String check_choice_popup1 = "1"; //ค่าแรก ptt = 1; ค่าที่สอง bangchak = 2; ค่าที่สาม shell = 3; ค่าที่สี่ esso = 4;  ซ้าย
    private String check_choice_popup2 = "1"; // ขวา

    public static final String BASE_URL = "http://192.168.1.174:8080/API_Econ-master/";
    private static final String TAG = "log";
    private OilModel oilModel;
    private OilExcelModel oilExcelModel;

    //private Response<OilModel> response;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil2, container, false);
        setService();
         // All By id


//        setVSpopup();

        return rootView;

    }

    private void setOilExcelService(final String date, final Integer spinner_oil_type) {
        Call<OilExcelModel> call = HttpManager.getInstance().getOilExcelUser().loadJson();
        call.enqueue(new Callback<OilExcelModel>() {
            @Override
            public void onResponse(Call<OilExcelModel> call, Response<OilExcelModel> response) {
                oilExcelModel = response.body();
                Log.d(TAG, "onResponse: " + response.body().getOilExcelModel());

//bensin 95 bangchak
                if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //bensin , ptt , ptt
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //bensin , ptt , bangchak
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    show_vs2.setText("0"); //banchak
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //bensin , ptt , shell
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //bensin , ptt , esso
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//bensin 95 bangchak
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //bensin , bangchak , ptt
                    show_vs1.setText("0"); //bangchak
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //bensin , bangchak , bangchak
                    show_vs1.setText("0"); //bangchak
                    show_vs2.setText("0"); //bangchak
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //bensin , bangchak , shell
                    show_vs1.setText("0"); //bangchak
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //bensin , bangchak , esso
                    show_vs1.setText("0"); //bangchak
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("");
                    setCompair();
//bensin 95 shell
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //bensin , shell , ptt
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //bensin , shell , bangchak
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("0"); //bangchak
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //bensin , shell , shell
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //bensin , shell , esso
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("");
                    setCompair();
                    //bensin 95 esso
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //bensin , esso , ptt
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(0).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //bensin , esso , bangchak
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    show_vs2.setText("0"); //bangchak
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //bensin , esso , shell
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //bensin , esso , esso
                    show_vs1.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    show_vs2.setText("" + oilExcelModel.getOilExcelModel().get(18).getOilPrice()); //esso
                    setCompair();
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                }

//                //////////////////////////////////////////////////////////////////////////////////////
//sohol 95 ptt
                if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //sohol 95 , ptt , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //sohol 95  , ptt , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //banchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //sohol 95  , ptt , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //sohol 95  , ptt , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//sohol 95 bangchak
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //sohol 95  , bangchak , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //sohol 95  , bangchak , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //sohol 95  , bangchak , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //sohol 95  , bangchak , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//sohol 95 shell
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //sohol 95  , shell , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //sohol 95  , shell , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //sohol 95  , shell , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //sohol 95  , shell , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                    //sohol 95 esso
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //sohol 95  , esso , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //sohol 95  , esso , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(7).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //sohol 95  , esso , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(13).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //sohol 95  , esso , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                }

                //////////////////////////////////////////////////////////////////////////////////////
//sohol 91 ptt
                if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //sohol 91 , ptt , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //sohol 91  , ptt , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //banchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //sohol 91  , ptt , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //sohol 91  , ptt , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//sohol 91 bangchak
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //sohol 91  , bangchak , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //sohol 91  , bangchak , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //sohol 91  , bangchak , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //sohol 91  , bangchak , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//sohol 91 shell
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //sohol 91  , shell , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //sohol 91  , shell , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //sohol 91  , shell , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //sohol 91  , shell , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//sohol 91 esso
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //sohol 91  , esso , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //sohol 91  , esso , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(8).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //sohol 91  , esso , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(14).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //sohol 91  , esso , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(20).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                }

                //////////////////////////////////////////////////////////////////////////////////////
//e20 ptt
                if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //e20 , ptt , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //e20  , ptt , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //banchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //e20  , ptt , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //e20  , ptt , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//e20 bangchak
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //e20   , bangchak , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //e20   , bangchak , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //e20   , bangchak , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //e20   , bangchak , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//e20  shell
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //e20  , shell , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //e20  , shell , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //e20  , shell , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //e20  , shell , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//e20 esso
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //e20 , esso , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //e20  , esso , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //e20  , esso , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //e20  , esso , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                }

                //////////////////////////////////////////////////////////////////////////////////////
//e85 ptt
                if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //e85 , ptt , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //e85  , ptt , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //banchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //e85  , ptt , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");

                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //e85  , ptt , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    show_vs2.setText("0"); //esso
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("");
                    setCompair();
//e85 bangchak
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //e85   , bangchak , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //e85   , bangchak , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //e85   , bangchak , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //e85   , bangchak , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
                    show_vs2.setText("0"); //esso
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("");
                    setCompair();
//e85  shell
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //e85  , shell , ptt
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //e85  , shell , bangchak
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //e85  , shell , shell
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //e85  , shell , esso
                    show_vs1.setText("0"); //shell
                    show_vs2.setText("0"); //esso
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
//e85 esso
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //e85 , esso , ptt
                    show_vs1.setText("0"); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //e85  , esso , bangchak
                    show_vs1.setText("0"); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //e85  , esso , shell
                    show_vs1.setText("0"); //esso
                    show_vs2.setText("0"); //shell
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //e85  , esso , esso
                    show_vs1.setText("0"); //esso
                    show_vs2.setText("0"); //esso
                    remark.setText("*   ไม่พบราคาน้ำมัน");
                    tv_dot_remark_right.setText("*");
                    tv_dot_remark_left.setText("*");
                    setCompair();
                }
//////////////////////////////////////////////////////////////////////////////////////
//disel ptt
                if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //disel , ptt , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //disel  , ptt , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //banchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //disel  , ptt , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //disel  , ptt , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    show_vs2.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//disel bangchak
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //disel   , bangchak , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //disel  , bangchak , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //disel   , bangchak , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //disel   , bangchak , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
                    show_vs2.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//disel  shell
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //disel  , shell , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //disel  , shell , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //disel  , shell , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //disel  , shell , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    show_vs2.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
//disel esso
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //disel , esso , ptt
                    show_vs1.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(5).getOilPrice()); //ptt
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //disel  , esso , bangchak
                    show_vs1.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //disel  , esso , shell
                    show_vs1.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(17).getOilPrice()); //shell
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //disel  , esso , esso
                    show_vs1.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    show_vs2.setText("" + oilModel.getOilModel().get(23).getOilPrice()); //esso
                    remark.setText("");
                    tv_dot_remark_right.setText("");
                    tv_dot_remark_left.setText("");
                    setCompair();
                }

            }

            @Override
            public void onFailure(Call<OilExcelModel> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });


    }

    private void setService() {
        OilUserRequest user = new OilUserRequest();
        Call<OilModel> call = HttpManager.getInstance().getOilUser().loadJson();

        call.enqueue(new Callback<OilModel>() {
            @Override
            public void onResponse(Call<OilModel> call, Response<OilModel> response) {
                oilModel = response.body();

                Log.d(TAG, "onResponse: " + response.body().getOilModel());

                setView();
//ค่าเริ่มต้น ของ app
                show_vs1.setText(response.body().getOilModel().get(4).getOilPrice());  // ptt เบนซิล 95
                show_vs2.setText(response.body().getOilModel().get(4).getOilPrice());

                setCompair();
                setOilTypeSpiner();
                setVSpopup();


            }

            @Override
            public void onFailure(Call<OilModel> call, Throwable t) {
                Log.d(TAG, "onFailure:  " + t.toString());
            }
        });

    }

    //Date Picker
    private void setView() {

        tv_date_oil_vs = (TextView) rootView.findViewById(R.id.tv_date_oil_vs);
        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);
        img_vs1 = (ImageView) rootView.findViewById(R.id.img_vs1);
        img_vs2 = (ImageView) rootView.findViewById(R.id.img_vs2);
        remark = (TextView) rootView.findViewById(R.id.remark);
        tv_dot_remark_right = (TextView) rootView.findViewById(R.id.tv_dot_remark_right);
        tv_dot_remark_left = (TextView) rootView.findViewById(R.id.tv_dot_remark_left);

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

            setDataWhenDateChange(date, oilTypeSpinner.getSelectedItemPosition());


        }
    }

    private void setDataWhenDateChange(String date, Integer spinner_oil_type) {
        // reset text กดปฏิทินแล้วเปลี่ยนค่าที่ไหนบ้าง

        String d = date.substring(0, 9);

        Log.d(TAG, "setData: test");
        String day[] = date.split("/"); //split คือการแยก "ข้อความ"
        Log.d("show result", day[0]);
        Log.d("show spinner", spinner_oil_type.toString());

        Log.d("Show Day", day[0]);
        Log.d("Show Month", day[1]);
        Log.d("Show Year", day[2]);

        if (day[0].equals("23") && day[1].equals("11") && day[2].equals("2016")) {
            Log.d(TAG, "setDataWhenDateChange: ");
            setOilExcelService(date, spinner_oil_type);

            // RESET TEXT #SERVICE
            // ค่าข้อมูลจาก service เมื่อค่า Spinner(oil type) และะ Pop-up (Oil Pump) เปลี่ยนแปลง

//SERVICE TODAY OILMODEL OILACTION
//bensin 95 ptt

        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //bensin , ptt , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //bensin , ptt , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            show_vs2.setText("0"); //banchak
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //bensin , ptt , shell
            show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //bensin , ptt , esso
            show_vs1.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//bensin 95 bangchak
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //bensin , bangchak , ptt
            show_vs1.setText("0"); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //bensin , bangchak , bangchak
            show_vs1.setText("0"); //bangchak
            show_vs2.setText("0"); //bangchak
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //bensin , bangchak , shell
            show_vs1.setText("0"); //bangchak
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //bensin , bangchak , esso
            show_vs1.setText("0"); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
//bensin 95 shell
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //bensin , shell , ptt
            show_vs1.setText("0"); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //bensin , shell , bangchak
            show_vs1.setText("0"); //shell
            show_vs2.setText("0"); //bangchak
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //bensin , shell , shell
            show_vs1.setText("0"); //shell
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //bensin , shell , esso
            show_vs1.setText("0"); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
            //bensin 95 esso
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //bensin , esso , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(4).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //bensin , esso , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            show_vs2.setText("0"); //bangchak
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //bensin , esso , shell
            show_vs1.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 0 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //bensin , esso , esso
            show_vs1.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(30).getOilPrice()); //esso
            setCompair();
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
        }

        //////////////////////////////////////////////////////////////////////////////////////

//sohol 95 ptt
        if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //sohol 95 , ptt , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //sohol 95  , ptt , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //banchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //sohol 95  , ptt , shell
            show_vs1.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //sohol 95  , ptt , esso
            show_vs1.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//sohol 95 bangchak
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //sohol 95  , bangchak , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //sohol 95  , bangchak , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //sohol 95  , bangchak , shell
            show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //sohol 95  , bangchak , esso
            show_vs1.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//sohol 95 shell
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //sohol 95  , shell , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //sohol 95  , shell , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //sohol 95  , shell , shell
            show_vs1.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //sohol 95  , shell , esso
            show_vs1.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
            //sohol 95 esso
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //sohol 95  , esso , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(0).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //sohol 95  , esso , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(9).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //sohol 95  , esso , shell
            show_vs1.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(18).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 1 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //sohol 95  , esso , esso
            show_vs1.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(26).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        }

        //////////////////////////////////////////////////////////////////////////////////////
//sohol 91 ptt
        if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //sohol 91 , ptt , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //sohol 91  , ptt , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //banchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //sohol 91  , ptt , shell
            show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //sohol 91  , ptt , esso
            show_vs1.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//sohol 91 bangchak
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //sohol 91  , bangchak , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //sohol 91  , bangchak , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //sohol 91  , bangchak , shell
            show_vs1.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //sohol 91  , bangchak , esso
            show_vs1.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//sohol 91 shell
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //sohol 91  , shell , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //sohol 91  , shell , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //sohol 91  , shell , shell
            show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //sohol 91  , shell , esso
            show_vs1.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//sohol 91 esso
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //sohol 91  , esso , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(3).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //sohol 91  , esso , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(12).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //sohol 91  , esso , shell
            show_vs1.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(21).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 2 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //sohol 91  , esso , esso
            show_vs1.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(29).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        }

        //////////////////////////////////////////////////////////////////////////////////////
//e20 ptt
        if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //e20 , ptt , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //e20  , ptt , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //banchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //e20  , ptt , shell
            show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //e20  , ptt , esso
            show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//e20 bangchak
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //e20   , bangchak , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //e20   , bangchak , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //e20   , bangchak , shell
            show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //e20   , bangchak , esso
            show_vs1.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//e20  shell
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //e20  , shell , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //e20  , shell , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //e20  , shell , shell
            show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //e20  , shell , esso
            show_vs1.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//e20 esso
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //e20 , esso , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //e20  , esso , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(10).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //e20  , esso , shell
            show_vs1.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(19).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 3 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //e20  , esso , esso
            show_vs1.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(27).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        }

        //////////////////////////////////////////////////////////////////////////////////////
//e85 ptt
        if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //e85 , ptt , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //e85  , ptt , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //banchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //e85  , ptt , shell
            show_vs1.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //e85  , ptt , esso
            show_vs1.setText("" + oilModel.getOilModel().get(1).getOilPrice()); //ptt
            show_vs2.setText("0"); //esso
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("");
            setCompair();
//e85 bangchak
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //e85   , bangchak , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //e85   , bangchak , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //e85   , bangchak , shell
            show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //e85   , bangchak , esso
            show_vs1.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
            show_vs2.setText("0"); //esso
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("");
            setCompair();
//e85  shell
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //e85  , shell , ptt
            show_vs1.setText("0"); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //e85  , shell , bangchak
            show_vs1.setText("0"); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //e85  , shell , shell
            show_vs1.setText("0"); //shell
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //e85  , shell , esso
            show_vs1.setText("0"); //shell
            show_vs2.setText("0"); //esso
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
//e85 esso
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //e85 , esso , ptt
            show_vs1.setText("0"); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(2).getOilPrice()); //ptt
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //e85  , esso , bangchak
            show_vs1.setText("0"); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(11).getOilPrice()); //bangchak
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //e85  , esso , shell
            show_vs1.setText("0"); //esso
            show_vs2.setText("0"); //shell
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
        } else if (spinner_oil_type == 4 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //e85  , esso , esso
            show_vs1.setText("0"); //esso
            show_vs2.setText("0"); //esso
            remark.setText("*   ไม่พบราคาน้ำมัน");
            tv_dot_remark_right.setText("*");
            tv_dot_remark_left.setText("*");
            setCompair();
        }
//////////////////////////////////////////////////////////////////////////////////////
//disel ptt
        if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("1")) { //disel , ptt , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("2")) { //disel  , ptt , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //banchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("3")) { //disel  , ptt , shell
            show_vs1.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("1") && check_choice_popup2.equals("4")) { //disel  , ptt , esso
            show_vs1.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            show_vs2.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//disel bangchak
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("1")) { //disel   , bangchak , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("2")) { //disel  , bangchak , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("3")) { //disel   , bangchak , shell
            show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("2") && check_choice_popup2.equals("4")) { //disel   , bangchak , esso
            show_vs1.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //bangchak
            show_vs2.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//disel  shell
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("1")) { //disel  , shell , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("2")) { //disel  , shell , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("3")) { //disel  , shell , shell
            show_vs1.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("3") && check_choice_popup2.equals("4")) { //disel  , shell , esso
            show_vs1.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            show_vs2.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
//disel esso
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("1")) { //disel , esso , ptt
            show_vs1.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(6).getOilPrice()); //ptt
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("2")) { //disel  , esso , bangchak
            show_vs1.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(15).getOilPrice()); //bangchak
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("3")) { //disel  , esso , shell
            show_vs1.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(24).getOilPrice()); //shell
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        } else if (spinner_oil_type == 5 && check_choice_popup1.equals("4") && check_choice_popup2.equals("4")) { //disel  , esso , esso
            show_vs1.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            show_vs2.setText("" + oilModel.getOilModel().get(32).getOilPrice()); //esso
            remark.setText("");
            tv_dot_remark_right.setText("");
            tv_dot_remark_left.setText("");
            setCompair();
        }

        Log.d(TAG, spinner_oil_type + " spinner " + "\n"
                + check_click_popup + " Pop-up[left-right]" + "\n"
                + check_choice_popup1 + " LEFT pump" + "\n"
                + check_choice_popup2 + " RIGHT pump");

//        //ขึ้นอยุ่กับ ประเภทของน้ำมัน
//        if (spinner_oil_type == 0 && check_click_popup.equals("1")) { //ถ้าประเภทน้ำมันเป็น เบนซิล95 และ เลือก pop-up ตัวแรก ซ้ายมือ
//            if (check_choice_popup1.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//               show_vs1.setText(""+oilModel.getOilModel().get(4).getOilPrice());  // ptt เบนซิล 95
//                remark.setText("");
//                Log.d(TAG, "setData: "+oilModel.getOilModel().get(4).getOilPrice());
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//              //ไม่ขาย
//                //show_vs1.setText(oilModel.getOilModel().get(13).getOilPrice());  // bangchak เบนซิล 95
//                show_vs1.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_left.setText("*");
//            } else if (check_choice_popup1.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                //ไม่ขาย
//                //show_vs1.setText(oilModel.getOilModel().get(22).getOilPrice());  // shell เบนซิล 95
//                show_vs1.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_left.setText("*");
//            } else if (check_choice_popup1.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs1.setText(oilModel.getOilModel().get(30).getOilPrice());  // esso เบนซิล 95\
//                //show_vs2.setText(oilModel.getOilModel().get(30).getOilPrice());
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            }
//             setCompair();
//
//        } else if (spinner_oil_type == 1 && check_click_popup.equals("1")) { //ถ้าประเภทน้ำมันเป็น แก๊สโซฮอล 95 และ เลือก pop-up ตัวแรก ซ้ายมือ
//            if (check_choice_popup1.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs1.setText(oilModel.getOilModel().get(0).getOilPrice());  // ptt แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs1.setText(oilModel.getOilModel().get(9).getOilPrice());  // bangchak แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs1.setText(oilModel.getOilModel().get(18).getOilPrice());  // shell แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs1.setText(oilModel.getOilModel().get(26).getOilPrice());  // esso แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            }
//             setCompair();
//
//        } else if (spinner_oil_type == 2 && check_click_popup.equals("1")) { //ถ้าประเภทน้ำมันเป็น แก๊สโซฮอล 91 และ เลือก pop-up ตัวแรก ซ้ายมือ
//            if (check_choice_popup1.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs1.setText(oilModel.getOilModel().get(3).getOilPrice());  // ptt แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs1.setText(oilModel.getOilModel().get(12).getOilPrice());  // bangchak แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs1.setText(oilModel.getOilModel().get(21).getOilPrice());  // shell แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs1.setText(oilModel.getOilModel().get(29).getOilPrice());  // esso แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            }
//              setCompair();
//
//        } else if (spinner_oil_type == 3 && check_click_popup.equals("1")) { //ถ้าประเภทน้ำมันเป็น E20 และ เลือก pop-up ตัวแรก ซ้ายมือ
//            if (check_choice_popup1.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs1.setText(oilModel.getOilModel().get(1).getOilPrice());  // ptt E20
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs1.setText(oilModel.getOilModel().get(10).getOilPrice());  // bangchak E20
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs1.setText(oilModel.getOilModel().get(19).getOilPrice());  // shell E20
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs1.setText(oilModel.getOilModel().get(27).getOilPrice());  // esso E20
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            }
//              setCompair();
//
//        } else if (spinner_oil_type == 4 && check_click_popup.equals("1")) { //ถ้าประเภทน้ำมันเป็น E85 และ เลือก pop-up ตัวแรก ซ้ายมือ
//            if (check_choice_popup1.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs1.setText(oilModel.getOilModel().get(2).getOilPrice());  // ptt E85
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs1.setText(oilModel.getOilModel().get(11).getOilPrice());  // bangchak E85
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                //ไม่ขาย
//                //show_vs1.setText(oilModel.getOilModel().get(20).getOilPrice());  // shell E85
//                show_vs1.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_left.setText("*");
//            } else if (check_choice_popup1.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                //ไม่ขาย
//                //show_vs1.setText(oilModel.getOilModel().get(28).getOilPrice());  // esso E85
//                show_vs1.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_left.setText("*");
//            }
//             setCompair();
//        } else if (spinner_oil_type == 5 && check_click_popup.equals("1")) { //ถ้าประเภทน้ำมันเป็น DiSEL และ เลือก pop-up ตัวแรก ซ้ายมือ
//            if (check_choice_popup1.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs1.setText(oilModel.getOilModel().get(6).getOilPrice());  // ptt ดีเซล
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs1.setText(oilModel.getOilModel().get(15).getOilPrice());  // bangchak ดีเซล
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs1.setText(oilModel.getOilModel().get(24).getOilPrice());  // shell ดีเซล
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            } else if (check_choice_popup1.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs1.setText(oilModel.getOilModel().get(32).getOilPrice());  // esso ดีเซล
//                remark.setText("");
//                tv_dot_remark_left.setText("");
//            }
//             setCompair();
//        }
//
//        if (spinner_oil_type == 0 && check_click_popup.equals("2")) { //ถ้าประเภทน้ำมันเป็น เบนซิล95 และ เลือก pop-up ตัวที่สอง ขวามือ
//            if (check_choice_popup2.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs2.setText(oilModel.getOilModel().get(4).getOilPrice());  // ptt เบนซิล 95
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                //ไม่ขาย
//                //show_vs2.setText(oilModel.getOilModel().get(13).getOilPrice());  // bangchak เบนซิล 95
//                show_vs2.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_right.setText("*");
//            } else if (check_choice_popup2.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                //ไม่ขาย
//                //show_vs2.setText(oilModel.getOilModel().get(22).getOilPrice());  // shell เบนซิล 95
//                show_vs2.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_right.setText("*");
//            } else if (check_choice_popup2.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs2.setText(oilModel.getOilModel().get(30).getOilPrice());  // esso เบนซิล 95
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            }
//             setCompair();
//
//        } else if (spinner_oil_type == 1 && check_click_popup.equals("2")) { //ถ้าประเภทน้ำมันเป็น แก๊สโซฮอล 95 และ เลือก pop-up ตัวที่สอง ขวามือ
//            if (check_choice_popup2.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs2.setText(oilModel.getOilModel().get(0).getOilPrice());  // ptt แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs2.setText(oilModel.getOilModel().get(9).getOilPrice());  // bangchak แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs2.setText(oilModel.getOilModel().get(18).getOilPrice());  // shell แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs2.setText(oilModel.getOilModel().get(26).getOilPrice());  // esso แก๊สโซฮอล 95
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            }
//             setCompair();
//
//        } else if (spinner_oil_type == 2 && check_click_popup.equals("2")) { //ถ้าประเภทน้ำมันเป็น แก๊สโซฮอล 91 และ เลือก pop-up ตัวที่สอง ขวามือ
//            if (check_choice_popup2.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs2.setText(oilModel.getOilModel().get(3).getOilPrice());  // ptt แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs2.setText(oilModel.getOilModel().get(12).getOilPrice());  // bangchak แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs2.setText(oilModel.getOilModel().get(21).getOilPrice());  // shell แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs2.setText(oilModel.getOilModel().get(29).getOilPrice());  // esso แก๊สโซฮอล 91
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            }
//              setCompair();
//
//        } else if (spinner_oil_type == 3 && check_click_popup.equals("2")) { //ถ้าประเภทน้ำมันเป็น E20 และ เลือก pop-up ตัวที่สอง ขวามือ
//            if (check_choice_popup2.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs2.setText(oilModel.getOilModel().get(1).getOilPrice());  // ptt E20
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs2.setText(oilModel.getOilModel().get(10).getOilPrice());  // bangchak E20
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs2.setText(oilModel.getOilModel().get(19).getOilPrice());  // shell E20
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs2.setText(oilModel.getOilModel().get(27).getOilPrice());  // esso E20
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            }
//              setCompair();
//
//        } else if (spinner_oil_type == 4 && check_click_popup.equals("2")) { //ถ้าประเภทน้ำมันเป็น E85 และ เลือก pop-up ตัวที่สอง ขวามือ
//            if (check_choice_popup2.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs2.setText(oilModel.getOilModel().get(2).getOilPrice());  // ptt E85
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs2.setText(oilModel.getOilModel().get(11).getOilPrice());  // bangchak E85
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                //ไม่ขาย
//                //show_vs2.setText(oilModel.getOilModel().get(20).getOilPrice());  // shell E85
//                show_vs2.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_right.setText("*");
//            } else if (check_choice_popup2.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                //ไม่ขาย
//                //show_vs2.setText(oilModel.getOilModel().get(28).getOilPrice());  // esso E85
//                show_vs2.setText("0");
//                remark.setText("*   ไม่พบราคาน้ำมัน");
//                tv_dot_remark_right.setText("*");
//            }
//             setCompair();
//        } else if (spinner_oil_type == 5 && check_click_popup.equals("2")) { //ถ้าประเภทน้ำมันเป็น DiSEL และ เลือก pop-up ตัวที่สอง ขวามือ
//            if (check_choice_popup2.equals("1")) {  //เลือกค่าใน pop-up ตัวแรก PTT
//                show_vs2.setText(oilModel.getOilModel().get(6).getOilPrice());  // ptt ดีเซล
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("2")) {   //เลือกค่าใน pop-up ตัวที่สอง Bangchak
//                show_vs2.setText(oilModel.getOilModel().get(15).getOilPrice());  // bangchak ดีเซล
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("3")) {   //เลือกค่าใน pop-up ตัวที่สอง Shell
//                show_vs2.setText(oilModel.getOilModel().get(24).getOilPrice());  // shell ดีเซล
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            } else if (check_choice_popup2.equals("4")) {   //เลือกค่าใน pop-up ตัวที่สอง Esso
//                show_vs2.setText(oilModel.getOilModel().get(32).getOilPrice());  // esso ดีเซล
//                remark.setText("");
//                tv_dot_remark_right.setText("");
//            }
//             setCompair();
//        }


//----------------------------------------------------------------------------------------------------------------------------------------
//        //RESET TEXT เมื่อมีค่าเปลี่ยนแปลง ( DatePicker , Spinner , Pop-up)ข้อมูลที่แสดงจะต้องเปลี่ยนค่าด้วย (show_vs1 , show_vs2 ,tv_show_result )
//        //<1>   DatePicker -->   Day10 , Day18 , Day27
//        //<2>   Spinner    -->   [0]Bensin  , [1]Sohol95  , [2]Sohol96  , [3]E20  , [4]E85  , [5]Disel
//        //<3>   Pop-up     -->   [0]ptt , [1]bangchak, [2]shell , [3]esso
//        //check ค่า สามอย่างแล้วเอามาแสดงผล <1> + <2> + <3> = SHOW!!!
//        // * ใช้ DAY เป็นหลัก
//
////DAY 10
//        //Day 10 , Spinner = [0]Bensin
//        if ((day[0].equals("10")) && (spinner_oil_type == 0)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(0) + " "); // ptt เบนซิล
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(0) + " "); // bangchak เบนซฺล
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(0) + " "); // shell เบนซิล
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(0) + " "); // esso เบนซิล
//                }
//                //setCompair();
//
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(0) + " "); // ptt เบนซิล
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(0) + " "); // bangchak เบนซฺล
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(0) + " "); // shell เบนซิล
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(0) + " "); // esso เบนซิล
//                }
//
//            }
//
//            setCompair();
//        }
//        //Day 10 , Spinner = [1]Sohol95
//        else if ((day[0].equals("10")) && (spinner_oil_type == 1)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(1) + " "); // ptt  Sohol95
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(1) + " "); // bangchak  Sohol95
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(1) + " "); // shell  Sohol95
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(1) + " "); // esso  Sohol95
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(1) + " "); // ptt  Sohol95
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(1) + " "); // bangchak  Sohol95
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(1) + " "); // shell  Sohol95
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(1) + " "); // esso  Sohol95
//                }
//
//            }
//            setCompair();
//
//            //Day 10 , Spinner = [2]Sohol96
//        } else if ((day[0].equals("10")) && (spinner_oil_type == 2)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(2) + " "); // ptt Sohol96
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(2) + " "); // bangchak  Sohol96
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(2) + " "); // shell  Sohol96
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(2) + " "); // esso  Sohol96
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) {
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(2) + " "); // ptt  Sohol96
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(2) + " "); // bangchak  Sohol96
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(2) + " "); // shell  Sohol96
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(2) + " "); // esso  Sohol96
//                }
//                setCompair();
//            }
//
//        } //Day 10 , Spinner = [3]E20
//        else if ((day[0].equals("10")) && (spinner_oil_type == 3)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(3) + " "); // ptt E20
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(3) + " "); // bangchak E20
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(3) + " "); // shell E20
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(3) + " "); // esso E20
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(3) + " "); // ptt E20
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(3) + " "); // bangchak  E20
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(3) + " "); // shell  E20
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(3) + " "); // esso  E20
//                }
//                setCompair();
//            }
//
//        } else if ((day[0].equals("10")) && (spinner_oil_type == 4)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(4) + " "); // ptt E85
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(4) + " "); // bangchak E85
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(4) + " "); // shell E85
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(4) + " "); // esso E85
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(4) + " "); // ptt E85
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(4) + " "); // bangchak  E85
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(4) + " "); // shell  E85
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(4) + " "); // esso  E85
//                }
//                setCompair();
//            }
//        }
//        //Day 10 , Spinner = [5]Disel
//        else if ((day[0].equals("10")) && (spinner_oil_type == 5)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_10.get(5) + " "); // ptt Disel
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_10.get(5) + " "); // bangchak Disel
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_10.get(5) + " "); // shell Disel
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_10.get(5) + " "); // esso Disel
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_10.get(5) + " "); // ptt Disel
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_10.get(5) + " "); // bangchak  Disel
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_10.get(5) + " "); // shell  Disel
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_10.get(5) + " "); // esso  Disel
//                }
//                setCompair();
//            }
//        }
//
////DAY 18
//        //Day 18 , Spinner = [0]Bensin
//        if ((day[0].equals("10")) && (spinner_oil_type == 0)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(0) + " "); // ptt เบนซิล
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(0) + " "); // bangchak เบนซฺล
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(0) + " "); // shell เบนซิล
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(0) + " "); // esso เบนซิล
//                }
//                //setCompair();
//
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(0) + " "); // ptt เบนซิล
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(0) + " "); // bangchak เบนซฺล
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(0) + " "); // shell เบนซิล
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(0) + " "); // esso เบนซิล
//                }
//
//            }
//
//            setCompair();
//        }
//        //Day 18 , Spinner = [1]Sohol95
//        else if ((day[0].equals("18")) && (spinner_oil_type == 1)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(1) + " "); // ptt  Sohol95
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(1) + " "); // bangchak  Sohol95
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(1) + " "); // shell  Sohol95
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(1) + " "); // esso  Sohol95
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(1) + " "); // ptt  Sohol95
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(1) + " "); // bangchak  Sohol95
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(1) + " "); // shell  Sohol95
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(1) + " "); // esso  Sohol95
//                }
//
//            }
//            setCompair();
//
//            //Day 18 , Spinner = [2]Sohol96
//        } else if ((day[0].equals("18")) && (spinner_oil_type == 2)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(2) + " "); // ptt Sohol96
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(2) + " "); // bangchak  Sohol96
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(2) + " "); // shell  Sohol96
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(2) + " "); // esso  Sohol96
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) {
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(2) + " "); // ptt  Sohol96
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(2) + " "); // bangchak Sohol96
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(2) + " "); // shell  Sohol96
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(2) + " "); // esso  Sohol96
//                }
//                setCompair();
//            }
//
//        } //Day 18 , Spinner = [3]E20
//        else if ((day[0].equals("18")) && (spinner_oil_type == 3)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(3) + " "); // ptt E20
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(3) + " "); // bangchak E20
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(3) + " "); // shell E20
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(3) + " "); // esso E20
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(3) + " "); // ptt E20
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(3) + " "); // bangchak  E20
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(3) + " "); // shell  E20
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(3) + " "); // esso  E20
//                }
//                setCompair();
//            }
//
//        } else if ((day[0].equals("18")) && (spinner_oil_type == 4)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(4) + " "); // ptt E85
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(4) + " "); // bangchak E85
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(4) + " "); // shell E85
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(4) + " "); // esso E85
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(4) + " "); // ptt E85
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(4) + " "); // bangchak  E85
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(4) + " "); // shell  E85
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(4) + " "); // esso  E85
//                }
//                setCompair();
//            }
//        }
//        //Day 18 , Spinner = [5]Disel
//        else if ((day[0].equals("18")) && (spinner_oil_type == 5)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_18.get(5) + " "); // ptt Disel
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_18.get(5) + " "); // bangchak Disel
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_18.get(5) + " "); // shell Disel
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_18.get(5) + " "); // esso Disel
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_18.get(5) + " "); // ptt Disel
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_18.get(5) + " "); // bangchak Disel
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_18.get(5) + " "); // shell  Disel
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_18.get(5) + " "); // esso  Disel
//                }
//                setCompair();
//            }
//        }
//        //DAY 27
//        //Day 27 , Spinner = [0]Bensin
//        if ((day[0].equals("27")) && (spinner_oil_type == 0)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(0) + " "); // ptt เบนซิล
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(0) + " "); // bangchak เบนซฺล
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(0) + " "); // shell เบนซิล
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(0) + " "); // esso เบนซิล
//                }
//                //setCompair();
//
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(0) + " "); // ptt เบนซิล
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(0) + " "); // bangchak เบนซฺล
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(0) + " "); // shell เบนซิล
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(0) + " "); // esso เบนซิล
//                }
//
//            }
//
//            setCompair();
//        }
//        //Day 27 , Spinner = [1]Sohol95
//        else if ((day[0].equals("27")) && (spinner_oil_type == 1)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(1) + " "); // ptt  Sohol95
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(1) + " "); // bangchak  Sohol95
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(1) + " "); // shell  Sohol95
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(1) + " "); // esso  Sohol95
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(1) + " "); // ptt  Sohol95
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(1) + " "); // bangchak  Sohol95
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(1) + " "); // shell  Sohol95
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(1) + " "); // esso  Sohol95
//                }
//
//            }
//            setCompair();
//
//            //Day 27 , Spinner = [2]Sohol96
//        } else if ((day[0].equals("27")) && (spinner_oil_type == 2)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(2) + " "); // ptt Sohol96
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(2) + " "); // bangchak  Sohol96
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(2) + " "); // shell  Sohol96
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(2) + " "); // esso  Sohol96
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) {
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(2) + " "); // ptt  Sohol96
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(2) + " "); // bangchak  Sohol96
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(2) + " "); // shell  Sohol96
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(2) + " "); // esso  Sohol96
//                }
//                setCompair();
//            }
//
//        } //Day 27 , Spinner = [3]E20
//        else if ((day[0].equals("27")) && (spinner_oil_type == 3)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(3) + " "); // ptt E20
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(3) + " "); // bangchak E20
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(3) + " "); // shell E20
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(3) + " "); // esso E20
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(3) + " "); // ptt E20
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(3) + " "); // bangchak  E20
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(3) + " "); // shell  E20
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(3) + " "); // esso  E20
//                }
//                setCompair();
//            }
//
//        } else if ((day[0].equals("27")) && (spinner_oil_type == 4)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(4) + " "); // ptt E85
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(4) + " "); // bangchak E85
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(4) + " "); // shell E85
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(4) + " "); // esso E85
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(4) + " "); // ptt E85
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(4) + " "); // bangchak  E85
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(4) + " "); // shell  E85
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(4) + " "); // esso  E85
//                }
//                setCompair();
//            }
//        }
//        //Day 27 , Spinner = [5]Disel
//        else if ((day[0].equals("27")) && (spinner_oil_type == 5)) {
//            if (check_click_popup.equals("1")) { //เลือก Pop-up ตัวไหน --> เลือกอันแรกฝั่งซ้าย
//                //เลือกค่าไหนใน Pop-up
//                if (check_choice_popup1.equals("1")) {
//                    show_vs1.setText(Dummy.getInstance().ptt_day_27.get(5) + " "); // ptt Disel
//                } else if (check_choice_popup1.equals("2")) {
//                    show_vs1.setText(Dummy.getInstance().bangchak_day_27.get(5) + " "); // bangchak Disel
//                } else if (check_choice_popup1.equals("3")) {
//                    show_vs1.setText(Dummy.getInstance().shell_day_27.get(5) + " "); // shell Disel
//                } else if (check_choice_popup1.equals("4")) {
//                    show_vs1.setText(Dummy.getInstance().esso_day_27.get(5) + " "); // esso Disel
//                }
//                // setCompair();
//            } else if (check_click_popup.equals("2")) { //Pop-up ตัวที่สอง ฝั่งขวา
//                if (check_choice_popup2.equals("1")) {
//                    show_vs2.setText(Dummy.getInstance().ptt_day_27.get(5) + " "); // ptt Disel
//                } else if (check_choice_popup2.equals("2")) {
//                    show_vs2.setText(Dummy.getInstance().bangchak_day_27.get(5) + " "); // bangchak  Disel
//                } else if (check_choice_popup2.equals("3")) {
//                    show_vs2.setText(Dummy.getInstance().shell_day_27.get(5) + " "); // shell  Disel
//                } else if (check_choice_popup2.equals("4")) {
//                    show_vs2.setText(Dummy.getInstance().esso_day_27.get(5) + " "); // esso  Disel
//                }
//                setCompair();
//            }
//        }
//
    }


    private void setCompair() {
//เมธอด setCompair จะเอา ตัวแปร show_vs1 และ show_vs2 ที่มีชิดตัวแปรเป็น String มา getText() ให้เป็น Double

        double vs1 = Double.parseDouble(show_vs1.getText().toString());
        double vs2 = Double.parseDouble(show_vs2.getText().toString());


// เพื่อจะได้เอามาหา ผลต่างได้
// แล้วเราจะหาผลต่าง จากการเอาค่า vs1 vs2 มาลบกัน โดยจะเก็บค่าที่ได้มาไว้ใน ตัวแปร result_num  ที่มีค่าเป็น double
        double result_num = vs1 - vs2;

        if (result_num > 0) {
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp)); //green
        } else if (result_num < 0) {
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
        } else if (result_num == 0) {
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
        }

        if (show_vs1.getText().toString().equals("0")) {
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
        } else if (show_vs2.getText().toString().equals("0")) {
            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
        }


        Log.d("Show ", show_vs1.getText().toString());
        Log.d("Show ", show_vs2.getText().toString());
        Log.d("Show ", String.valueOf(vs1 - vs2));

// หลังจากนั้น เราก็จะเอา result_num ที่ได้จากการหาผลต่างมา set format ให้เป็นค่าทศนิยมสองตำปหน่ง หลังจากนั้น ให้ set ค่านี้ลงไปที่ textview tv_show_result (แสดงค่า)
        tv_show_result.setText(new DecimalFormat("0.00").format(+result_num));


//        if (tv_show_result.getText().length() < 0) {
//            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
//            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
//        } else if (tv_show_result.getText().length() > 0) {
//            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape_sp));
//            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
//
//            // ในกรณีที่ค่าที่เปรียบเทียบทั้งสองฝั่งเท่ากัน ไม่มีการแสดงสีที่ล่าง pop-up
//        } else if (tv_show_result.getText().length() == 0) {
//            show_vs1.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
//            show_vs2.setBackground(rootView.getResources().getDrawable(R.drawable.result_shape));
//        }


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
                                                   setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                                                   img_vs1.setImageResource(Dummy.getInstance().popup.get(0));
                                                   dialog.dismiss();
                                               }
                                           });


                                           b2.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   check_choice_popup1 = "2";
                                                   setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                                                   img_vs1.setImageResource(Dummy.getInstance().popup.get(1));

                                                   tv_show_result.setText(new DecimalFormat("0.00").format(+result_vs_popup));
                                                   dialog.dismiss();
                                                   //   img_vs2.setImageResource(R.drawable.ic_bangchak);
                                                   // img_vs2.setImageResource(R.drawable.ic_bangchak);
                                               }
                                           });

                                           b3.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   check_choice_popup1 = "3";
                                                   setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                                                   img_vs1.setImageResource(Dummy.getInstance().popup.get(2));
                                                   dialog.dismiss();
                                               }
                                           });

                                           dialog.show();

                                           b4.setOnClickListener(new View.OnClickListener() {
                                               @Override
                                               public void onClick(View view) {
                                                   check_choice_popup1 = "4";
                                                   setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
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
                        setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(0));

                        dialog.dismiss();

                    }
                });


                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check_choice_popup2 = "2";
                        setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(1));

                        dialog.dismiss();

                    }
                });


                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check_choice_popup2 = "3";
                        setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(2));

                        dialog.dismiss();
                    }
                });


                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        check_choice_popup2 = "4";
                        setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
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

                setDataWhenDateChange(tv_date_oil_vs.getText().toString(), oilTypeSpinner.getSelectedItemPosition());
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });

    }

}













