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
            tv21, tv22, tv23, tv24, tv25, tv26, tv27, tv28, tv29, tv30, tv31, tv32,
            tv33, tv34, tv35, tv36,

//    รางวัลที่ 4 , รางวัลที่ 5
            t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19,
            t20, t21, t22, t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, t33, t34, t35, t36, t37,
            t38, t39, t40, t41, t42, t43, t44, t45, t46, t47, t48, t49, t50, t51, t52, t53, t54, t55,
            t56, t57, t58, t59, t60, t61, t62, t63, t64, t65, t66, t67, t68, t69, t70, t71, t72, t73,
            t74, t75, t76, t77, t78, t79, t80, t81, t82, t83, t84, t85, t86, t87, t88, t89, t90, t91,
            t92, t93, t94, t95, t96, t97, t98, t99, t100, t101, t102, t103, t104, t105, t106, t107,
            t108, t109, t110, t111, t112, t113, t114, t115, t116, t117, t118, t119, t120, t121, t122,
            t123, t124, t125, t126, t127, t128, t129, t130, t131, t132, t133, t134, t135, t136, t137,
            t138, t139, t140, t141, t142, t143, t144, t145, t146, t147, t148, t149, t150;

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
        t1 = (TextView) rootView.findViewById(R.id.lot_num8_);
        t2 = (TextView) rootView.findViewById(R.id.lot_num8_1);
        t3 = (TextView) rootView.findViewById(R.id.lot_num8_2);
        t4 = (TextView) rootView.findViewById(R.id.lot_num8_3);
        t5 = (TextView) rootView.findViewById(R.id.lot_num8_4);
        t6 = (TextView) rootView.findViewById(R.id.lot_num8_5);
        t7 = (TextView) rootView.findViewById(R.id.lot_num8_6);
        t8 = (TextView) rootView.findViewById(R.id.lot_num8_7);
        t9 = (TextView) rootView.findViewById(R.id.lot_num8_8);
        t10 = (TextView) rootView.findViewById(R.id.lot_num8_9);
        t11 = (TextView) rootView.findViewById(R.id.lot_num8_10);
        t12 = (TextView) rootView.findViewById(R.id.lot_num8_11);
        t13 = (TextView) rootView.findViewById(R.id.lot_num8_12);
        t14 = (TextView) rootView.findViewById(R.id.lot_num8_13);
        t15 = (TextView) rootView.findViewById(R.id.lot_num8_14);
        t16 = (TextView) rootView.findViewById(R.id.lot_num8_15);
        t17 = (TextView) rootView.findViewById(R.id.lot_num8_16);
        t18 = (TextView) rootView.findViewById(R.id.lot_num8_17);
        t19 = (TextView) rootView.findViewById(R.id.lot_num8_18);
        t20 = (TextView) rootView.findViewById(R.id.lot_num8_19);
        t21 = (TextView) rootView.findViewById(R.id.lot_num8_20);
        t22 = (TextView) rootView.findViewById(R.id.lot_num8_21);
        t23 = (TextView) rootView.findViewById(R.id.lot_num8_22);
        t24 = (TextView) rootView.findViewById(R.id.lot_num8_23);
        t25 = (TextView) rootView.findViewById(R.id.lot_num8_24);
        t26 = (TextView) rootView.findViewById(R.id.lot_num8_25);
        t27 = (TextView) rootView.findViewById(R.id.lot_num8_26);
        t28 = (TextView) rootView.findViewById(R.id.lot_num8_27);
        t29 = (TextView) rootView.findViewById(R.id.lot_num8_28);
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
        t1.setTypeface(font);
        t2.setTypeface(font);
        t3.setTypeface(font);
        t4.setTypeface(font);
        t5.setTypeface(font);
        t6.setTypeface(font);
        t7.setTypeface(font);
        t8.setTypeface(font);
        t9.setTypeface(font);
        t10.setTypeface(font);
        t11.setTypeface(font);
        t12.setTypeface(font);
        t13.setTypeface(font);
        t14.setTypeface(font);
        t15.setTypeface(font);
        t16.setTypeface(font);
        t17.setTypeface(font);
        t18.setTypeface(font);
        t19.setTypeface(font);
        t20.setTypeface(font);
        t21.setTypeface(font);
        t22.setTypeface(font);
        t23.setTypeface(font);
        t24.setTypeface(font);
        t25.setTypeface(font);
        t26.setTypeface(font);
        t27.setTypeface(font);
        t28.setTypeface(font);
        t29.setTypeface(font);

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
        t1.setText("435236");
        t2.setText("000946");
        t3.setText("377777");
        t4.setText("333946");
        t5.setText("176946");
        t6.setText("346546");
        t7.setText("300000");
        t8.setText("111111");
        t9.setText("123456");
        t10.setText("666666");
        t11.setText("000076");
        t12.setText("234567");
        t13.setText("876406");
        t14.setText("777777");
        t15.setText("555555");
        t16.setText("444444");
        t17.setText("327654");
        t18.setText("987432");
        t19.setText("555000");
        t20.setText("666666");
        t21.setText("987098");
        t22.setText("657333");
        t23.setText("432415");
        t24.setText("111144");
        t25.setText("000054");
        t26.setText("345672");
        t27.setText("111100");
        t28.setText("441166");
        t29.setText("784218");
        tv9.setText("460008");
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














