package com.promptnow.econprice.fragment.lottery;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.view.HideKeyboard;
import com.promptnow.econprice.view.View_popup;


/**
 * Created by Whankung on 7/9/2559.
 */

// หน้าตรวจรางวัล
public class LotteryFragment extends Fragment implements View_popup.onSubmitAlertDialogListener {
    private View rootView;
    EditText input, seach;
    private Typeface font;
    private TextView tv, tv2, tv3, tv4, tv5, tv6, tv7, tv8, tv9, tv10,
            tv11, tv12, tv13, tv14, tv15, tv16, tv17, tv18, tv19, tv20,
            tv21,tv22,tv23,tv24,tv25,tv26,tv27,tv28,tv29,tv30,tv31,tv32,
            tv33,tv34,tv35,tv36,tv37;
    private Spinner spin;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.checklottery, container, false);
        LottoSpinner();
        setView();
        setNumber();
        setDummy();

        return rootView;
    }

    private void LottoSpinner() {
        String[] List = {"1/9/2016", "16/8/2016", "1/8/2016", "16/7/2016"};
        CustomAdapterLotto lottoAdapter = new CustomAdapterLotto(getActivity(), List);
        spin = (Spinner) rootView.findViewById(R.id.spin);
//        ArrayList<String> arrayList = new ArrayList<String>();
//        arrayList.add("1/9/2016");
//        arrayList.add("16/8/2016");
//        arrayList.add("1/8/2016");
//        arrayList.add("16/7/2016");
//        ArrayAdapter<String> lottoAdapter = new ArrayAdapter<String>(getActivity(),
//                //เปลี่ยนlayout
//                android.R.layout.simple_list_item_1, arrayList);
        spin.setAdapter(lottoAdapter);

        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {
                setDummy();
                if (i == 1) {
                    setContent();
                } else if (i == 2) {
                    setContent2();
                } else if (i == 3) {
                    setContent3();
                }
            }

            @Override
            public void onNothingSelected(AdapterView arg0) {

            }
        });
    }

    private void setView() {

//        ค้นหาผลสลาก
        seach = (EditText) rootView.findViewById(R.id.seach_num);
//        รางวัลที่1
        tv = (TextView) rootView.findViewById(R.id.lot_num);
//        เลขท้าย 2 ตัว
        tv2 = (TextView) rootView.findViewById(R.id.lot_num2);
//        เลขหน้า 3 ตัว
        tv3 = (TextView) rootView.findViewById(R.id.lot_num3);
        tv21 = (TextView) rootView.findViewById(R.id.lot_num3_);
//         เลขท้าย 3 ตัว
        tv4 = (TextView) rootView.findViewById(R.id.lot_num4);
        tv22 = (TextView) rootView.findViewById(R.id.lot_num4_);
//        รางวัลใกล้เคียงรางวัลที่1
        tv5 = (TextView) rootView.findViewById(R.id.lot_num5);
        tv23 = (TextView) rootView.findViewById(R.id.lot_num5_);
//        รางวัลที่2
        tv6 = (TextView) rootView.findViewById(R.id.lot_num6);
        tv24 = (TextView) rootView.findViewById(R.id.lot_num6_);
        tv25 = (TextView) rootView.findViewById(R.id.lot_num6_1);
        tv26 = (TextView) rootView.findViewById(R.id.lot_num6_2);
        tv27 = (TextView) rootView.findViewById(R.id.lot_num6_3_);
//        รางวัลที่3
        tv7 = (TextView) rootView.findViewById(R.id.lot_num7);
        tv28 = (TextView) rootView.findViewById(R.id.lot_num7_);
        tv29 = (TextView) rootView.findViewById(R.id.lot_num7_1);
        tv30 = (TextView) rootView.findViewById(R.id.lot_num7_2);
        tv31 = (TextView) rootView.findViewById(R.id.lot_num7_3);
        tv32 = (TextView) rootView.findViewById(R.id.lot_num7_4);
        tv33 = (TextView) rootView.findViewById(R.id.lot_num7_5);
        tv34 = (TextView) rootView.findViewById(R.id.lot_num7_6);
        tv35 = (TextView) rootView.findViewById(R.id.lot_num7_7);
        tv36 = (TextView) rootView.findViewById(R.id.lot_num7_8);
//        รางวัลที่4
        tv8 = (TextView) rootView.findViewById(R.id.lot_num8);
//        รางวัลที่5
        tv9 = (TextView) rootView.findViewById(R.id.lot_num9);
//        เลือกวันที่ย้อนหลัง
        tv10 = (TextView) rootView.findViewById(R.id.tv_date_show);
//        งวดที่หน้า spinner
        tv11 = (TextView) rootView.findViewById(R.id.check_date);
//         รางวัลที่1
        tv12 = (TextView) rootView.findViewById(R.id.lotto);
//         เลขท้าย 2 ตัว
        tv13 = (TextView) rootView.findViewById(R.id.lotto2);
//        เลขหน้า 3 ตัว
        tv14 = (TextView) rootView.findViewById(R.id.lotto3);
//         เลขท้าย 3 ตัว
        tv15 = (TextView) rootView.findViewById(R.id.lotto4);
//        รางวัลใกล้เคียงรางวัลที่1
        tv16 = (TextView) rootView.findViewById(R.id.lotto5);
//        รางวัลที่2
        tv17 = (TextView) rootView.findViewById(R.id.lotto6);
//         รางวัลที่3
        tv18 = (TextView) rootView.findViewById(R.id.lotto7);
//         รางวัลที่4
        tv19 = (TextView) rootView.findViewById(R.id.lotto8);
//         รางวัลที่5
        tv20 = (TextView) rootView.findViewById(R.id.lotto9);

//        เปลี่ยน font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        seach.setTypeface(font);
        tv.setTypeface(font);
        tv2.setTypeface(font);
        tv3.setTypeface(font);
        tv4.setTypeface(font);
        tv5.setTypeface(font);
        tv6.setTypeface(font);
        tv7.setTypeface(font);
        tv8.setTypeface(font);
        tv9.setTypeface(font);
        tv10.setTypeface(font);
        tv11.setTypeface(font);
        tv12.setTypeface(font);
        tv13.setTypeface(font);
        tv14.setTypeface(font);
        tv15.setTypeface(font);
        tv16.setTypeface(font);
        tv17.setTypeface(font);
        tv18.setTypeface(font);
        tv19.setTypeface(font);
        tv20.setTypeface(font);
        tv21.setTypeface(font);
        tv22.setTypeface(font);
        tv23.setTypeface(font);
        tv24.setTypeface(font);
        tv25.setTypeface(font);
        tv26.setTypeface(font);
        tv27.setTypeface(font);
        tv28.setTypeface(font);
        tv29.setTypeface(font);
        tv30.setTypeface(font);
        tv31.setTypeface(font);
        tv32.setTypeface(font);
        tv33.setTypeface(font);
        tv34.setTypeface(font);
        tv35.setTypeface(font);
        tv36.setTypeface(font);
    }

    private void setDummy() {
        tv.setText("254004");
        tv2.setText("33");
        tv3.setText("994");
        tv21.setText("341");
        tv4.setText("654");
        tv22.setText("764");
        tv5.setText("114505");
        tv23.setText("000503");
        tv6.setText("674107");
        tv24.setText("002226");
        tv25.setText("199098");
        tv26.setText("454211");
        tv27.setText("642000");
        tv7.setText("000245");
        tv28.setText("222148");
        tv29.setText("110008");
        tv30.setText("436321");
        tv31.setText("562907");
        tv32.setText("111222");
        tv33.setText("333444");
        tv34.setText("642665");
        tv35.setText("324563");
        tv36.setText("000742                                  ");
        tv8.setText("348946");
        tv9.setText("435451");
    }

    private void setContent() {
        tv.setText("209067");
        tv2.setText("01");
        tv3.setText("574");
        tv21.setText("211");
        tv4.setText("004");
        tv22.setText("164");
        tv5.setText("004505");
        tv23.setText("100503");
        tv6.setText("344107");
        tv24.setText("112226");
        tv25.setText("000098");
        tv26.setText("243211");
        tv27.setText("611000");
        tv7.setText("009845");
        tv28.setText("999148");
        tv29.setText("666008");
        tv30.setText("097321");
        tv31.setText("750907");
        tv32.setText("110022");
        tv33.setText("375444");
        tv34.setText("640965");
        tv35.setText("000063");
        tv36.setText("000042                                  ");
        tv8.setText("348006");
        tv9.setText("435881");
    }

    private void setContent2() {
        tv.setText("454567");
        tv2.setText("11");
        tv3.setText("004");
        tv21.setText("311");
        tv4.setText("114");
        tv22.setText("664");
        tv5.setText("666505");
        tv23.setText("440503");
        tv6.setText("309107");
        tv24.setText("552226");
        tv25.setText("440098");
        tv26.setText("763211");
        tv27.setText("981000");
        tv7.setText("055545");
        tv28.setText("099148");
        tv29.setText("766008");
        tv30.setText("097377");
        tv31.setText("750900");
        tv32.setText("110055");
        tv33.setText("375434");
        tv34.setText("640455");
        tv35.setText("000443");
        tv36.setText("124542                                  ");
        tv8.setText("003393 008533 118999");
        tv9.setText("276699 211146 211739");
    }

    private void setContent3() {
        tv.setText("111147");
        tv2.setText("67");
        tv3.setText("000");
        tv21.setText("656");
        tv4.setText("666");
        tv22.setText("876");
        tv5.setText("087655");
        tv23.setText("106563");
        tv6.setText("355507");
        tv24.setText("000006");
        tv25.setText("764368");
        tv26.setText("000211");
        tv27.setText("665480");
        tv7.setText("007689");
        tv28.setText("456788");
        tv29.setText("678908");
        tv30.setText("890661");
        tv31.setText("546707");
        tv32.setText("178962");
        tv33.setText("546794");
        tv34.setText("999965");
        tv35.setText("999993");
        tv36.setText("888042                                  ");
        tv8.setText("323393 008533 118999");
        tv9.setText("765699 111467 673739");
    }

//    private void setDate() {
//        spin = (Spinner) rootView.findViewById(R.id.spin);
//
//        spin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//    spin.performClick();
//
//            }
//        });
//    }


    private void setNumber() {
//        แถบค้นหาผลสลากกินแบ่งรัฐบาล
        input = (EditText) rootView.findViewById(R.id.seach_num);
        input.addTextChangedListener(watch);
        input.clearFocus();

// hide keyboard
        input.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                getActivity().getWindow().setSoftInputMode(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
                HideKeyboard.hideKeyboard(getActivity());
            }
        });

    }

    private TextWatcher watch = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable arg0) {

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {

        }

//            pop up
        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {
            Log.d("log", "123");
//            ตัวเลขถูกรางวัล
            String prefix = "000000";

            String strMsg = "";
            if (s.toString().endsWith(prefix)) {
                strMsg = getResources().getString(R.string.str_msgTrue);
                View_popup alertDialog = new View_popup(strMsg, "ตกลง");
                alertDialog.mListener = LotteryFragment.this;
                alertDialog.show(getFragmentManager(), "");
            } else if (s.toString().length() == 6) {
                strMsg = getResources().getString(R.string.str_msgFail);

                View_popup alertDialog = new View_popup(strMsg, "ตกลง");
                alertDialog.mListener = LotteryFragment.this;
                alertDialog.show(getFragmentManager(), "");
            }
        }
    };

    @Override
    public void setOnSubmitAlertDialogListener() {

    }




}














