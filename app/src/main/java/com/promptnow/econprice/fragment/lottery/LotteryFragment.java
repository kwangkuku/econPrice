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
        t30 = (TextView) rootView.findViewById(R.id.lot_num8_29);
        t31 = (TextView) rootView.findViewById(R.id.lot_num8_30);
        t32 = (TextView) rootView.findViewById(R.id.lot_num8_31);
        t33 = (TextView) rootView.findViewById(R.id.lot_num8_32);
        t34 = (TextView) rootView.findViewById(R.id.lot_num8_33);
        t35 = (TextView) rootView.findViewById(R.id.lot_num8_34);
        t36 = (TextView) rootView.findViewById(R.id.lot_num8_35);
        t37 = (TextView) rootView.findViewById(R.id.lot_num8_36);
        t38 = (TextView) rootView.findViewById(R.id.lot_num8_37);
        t39 = (TextView) rootView.findViewById(R.id.lot_num8_38);
        t40 = (TextView) rootView.findViewById(R.id.lot_num8_39);
        t41 = (TextView) rootView.findViewById(R.id.lot_num8_40);
        t42 = (TextView) rootView.findViewById(R.id.lot_num8_41);
        t43 = (TextView) rootView.findViewById(R.id.lot_num8_42);
        t44 = (TextView) rootView.findViewById(R.id.lot_num8_43);
        t45 = (TextView) rootView.findViewById(R.id.lot_num8_44);
        t46 = (TextView) rootView.findViewById(R.id.lot_num8_45);
        t47 = (TextView) rootView.findViewById(R.id.lot_num8_46);
        t48 = (TextView) rootView.findViewById(R.id.lot_num8_47);
        t49 = (TextView) rootView.findViewById(R.id.lot_num8_48);

//        รางวัลที่5
        tv9 = (TextView) rootView.findViewById(R.id.lot_num9);
        t50 = (TextView) rootView.findViewById(R.id.lot_num9_);
        t51= (TextView) rootView.findViewById(R.id.lot_num9_1);
        t52= (TextView) rootView.findViewById(R.id.lot_num9_2);
        t53= (TextView) rootView.findViewById(R.id.lot_num9_3);
        t54= (TextView) rootView.findViewById(R.id.lot_num9_4);
        t55= (TextView) rootView.findViewById(R.id.lot_num9_5);
        t56= (TextView) rootView.findViewById(R.id.lot_num9_6);
        t57= (TextView) rootView.findViewById(R.id.lot_num9_7);
        t58= (TextView) rootView.findViewById(R.id.lot_num9_8);
        t59 = (TextView) rootView.findViewById(R.id.lot_num9_9);
        t60 = (TextView) rootView.findViewById(R.id.lot_num9_10);
        t61 = (TextView) rootView.findViewById(R.id.lot_num9_11);
        t62 = (TextView) rootView.findViewById(R.id.lot_num9_12);
        t63 = (TextView) rootView.findViewById(R.id.lot_num9_13);
        t64 = (TextView) rootView.findViewById(R.id.lot_num9_14);
        t65 = (TextView) rootView.findViewById(R.id.lot_num9_15);
        t66 = (TextView) rootView.findViewById(R.id.lot_num9_16);
        t67 = (TextView) rootView.findViewById(R.id.lot_num9_17);
        t68 = (TextView) rootView.findViewById(R.id.lot_num9_18);
        t69 = (TextView) rootView.findViewById(R.id.lot_num9_19);
        t70 = (TextView) rootView.findViewById(R.id.lot_num9_20);
        t71 = (TextView) rootView.findViewById(R.id.lot_num9_21);
        t72 = (TextView) rootView.findViewById(R.id.lot_num9_22);
        t73 = (TextView) rootView.findViewById(R.id.lot_num9_23);
        t74 = (TextView) rootView.findViewById(R.id.lot_num9_24);
        t75 = (TextView) rootView.findViewById(R.id.lot_num9_25);
        t76 = (TextView) rootView.findViewById(R.id.lot_num9_26);
        t77 = (TextView) rootView.findViewById(R.id.lot_num9_27);
        t78 = (TextView) rootView.findViewById(R.id.lot_num9_28);
        t79 = (TextView) rootView.findViewById(R.id.lot_num9_29);
        t80 = (TextView) rootView.findViewById(R.id.lot_num9_30);
        t81 = (TextView) rootView.findViewById(R.id.lot_num9_31);
        t82 = (TextView) rootView.findViewById(R.id.lot_num9_32);
        t83 = (TextView) rootView.findViewById(R.id.lot_num9_33);
        t84 = (TextView) rootView.findViewById(R.id.lot_num9_34);
        t85 = (TextView) rootView.findViewById(R.id.lot_num9_35);
        t86 = (TextView) rootView.findViewById(R.id.lot_num9_36);
        t87 = (TextView) rootView.findViewById(R.id.lot_num9_37);
        t88 = (TextView) rootView.findViewById(R.id.lot_num9_38);
        t89 = (TextView) rootView.findViewById(R.id.lot_num9_39);
        t90 = (TextView) rootView.findViewById(R.id.lot_num9_40);
        t91 = (TextView) rootView.findViewById(R.id.lot_num9_41);
        t92 = (TextView) rootView.findViewById(R.id.lot_num9_42);
        t93 = (TextView) rootView.findViewById(R.id.lot_num9_43);
        t94 = (TextView) rootView.findViewById(R.id.lot_num9_44);
        t95 = (TextView) rootView.findViewById(R.id.lot_num9_45);
        t96 = (TextView) rootView.findViewById(R.id.lot_num9_46);
        t97 = (TextView) rootView.findViewById(R.id.lot_num9_47);
        t98 = (TextView) rootView.findViewById(R.id.lot_num9_48);
        t99 = (TextView) rootView.findViewById(R.id.lot_num9_49);
        t100= (TextView) rootView.findViewById(R.id.lot_num9_50);
        t101= (TextView) rootView.findViewById(R.id.lot_num9_51);
        t102 = (TextView) rootView.findViewById(R.id.lot_num9_52);
        t103= (TextView) rootView.findViewById(R.id.lot_num9_53);
        t104= (TextView) rootView.findViewById(R.id.lot_num9_54);
        t105= (TextView) rootView.findViewById(R.id.lot_num9_55);
        t106= (TextView) rootView.findViewById(R.id.lot_num9_56);
        t107= (TextView) rootView.findViewById(R.id.lot_num9_57);
        t108 = (TextView) rootView.findViewById(R.id.lot_num9_58);
        t109 = (TextView) rootView.findViewById(R.id.lot_num9_59);
        t110 = (TextView) rootView.findViewById(R.id.lot_num9_60);
        t111 = (TextView) rootView.findViewById(R.id.lot_num9_61);
        t112 = (TextView) rootView.findViewById(R.id.lot_num9_62);
        t113= (TextView) rootView.findViewById(R.id.lot_num9_63);
        t114 = (TextView) rootView.findViewById(R.id.lot_num9_64);
        t115= (TextView) rootView.findViewById(R.id.lot_num9_65);
        t116= (TextView) rootView.findViewById(R.id.lot_num9_66);
        t117= (TextView) rootView.findViewById(R.id.lot_num9_67);
        t118= (TextView) rootView.findViewById(R.id.lot_num9_68);
        t119= (TextView) rootView.findViewById(R.id.lot_num9_69);
        t120= (TextView) rootView.findViewById(R.id.lot_num9_70);
        t121 = (TextView) rootView.findViewById(R.id.lot_num9_71);
        t122= (TextView) rootView.findViewById(R.id.lot_num9_72);
        t123= (TextView) rootView.findViewById(R.id.lot_num9_73);
        t124= (TextView) rootView.findViewById(R.id.lot_num9_74);
        t125= (TextView) rootView.findViewById(R.id.lot_num9_75);
        t126= (TextView) rootView.findViewById(R.id.lot_num9_76);
        t127= (TextView) rootView.findViewById(R.id.lot_num9_77);
        t128= (TextView) rootView.findViewById(R.id.lot_num9_78);
        t129= (TextView) rootView.findViewById(R.id.lot_num9_79);
        t130= (TextView) rootView.findViewById(R.id.lot_num9_80);
        t131= (TextView) rootView.findViewById(R.id.lot_num9_81);
        t132= (TextView) rootView.findViewById(R.id.lot_num9_82);
        t133= (TextView) rootView.findViewById(R.id.lot_num9_83);
        t134= (TextView) rootView.findViewById(R.id.lot_num9_84);
        t135 = (TextView) rootView.findViewById(R.id.lot_num9_85);
        t136= (TextView) rootView.findViewById(R.id.lot_num9_86);
        t137= (TextView) rootView.findViewById(R.id.lot_num9_87);
        t138= (TextView) rootView.findViewById(R.id.lot_num9_88);
        t139= (TextView) rootView.findViewById(R.id.lot_num9_89);
        t140= (TextView) rootView.findViewById(R.id.lot_num9_90);
        t141= (TextView) rootView.findViewById(R.id.lot_num9_91);
        t142= (TextView) rootView.findViewById(R.id.lot_num9_92);
        t143= (TextView) rootView.findViewById(R.id.lot_num9_93);
        t144= (TextView) rootView.findViewById(R.id.lot_num9_94);
        t145= (TextView) rootView.findViewById(R.id.lot_num9_95);
        t146= (TextView) rootView.findViewById(R.id.lot_num9_96);
        t147= (TextView) rootView.findViewById(R.id.lot_num9_97);
        t148= (TextView) rootView.findViewById(R.id.lot_num9_98);

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
        t30.setTypeface(font);
        t31.setTypeface(font);
        t32.setTypeface(font);
        t33.setTypeface(font);
        t34.setTypeface(font);
        t35.setTypeface(font);
        t36.setTypeface(font);
        t37.setTypeface(font);
        t38.setTypeface(font);
        t39.setTypeface(font);
        t40.setTypeface(font);
        t41.setTypeface(font);
        t42.setTypeface(font);
        t43.setTypeface(font);
        t44.setTypeface(font);
        t45.setTypeface(font);
        t46.setTypeface(font);
        t47.setTypeface(font);
        t48.setTypeface(font);
        t49.setTypeface(font);
        t50.setTypeface(font);
        t51.setTypeface(font);
        t52.setTypeface(font);
        t53.setTypeface(font);
        t54.setTypeface(font);
        t55.setTypeface(font);
        t56.setTypeface(font);
        t57.setTypeface(font);
        t58.setTypeface(font);
        t59.setTypeface(font);
        t60.setTypeface(font);
        t61.setTypeface(font);
        t62.setTypeface(font);
        t63.setTypeface(font);
        t64.setTypeface(font);
        t65.setTypeface(font);
        t66.setTypeface(font);
        t67.setTypeface(font);
        t68.setTypeface(font);
        t69.setTypeface(font);
        t70.setTypeface(font);
        t71.setTypeface(font);
        t72.setTypeface(font);
        t73.setTypeface(font);
        t74.setTypeface(font);
        t75.setTypeface(font);
        t76.setTypeface(font);
        t77.setTypeface(font);
        t78.setTypeface(font);
        t79.setTypeface(font);
        t80.setTypeface(font);
        t81.setTypeface(font);
        t82.setTypeface(font);
        t83.setTypeface(font);
        t84.setTypeface(font);
        t85.setTypeface(font);
        t86.setTypeface(font);
        t87.setTypeface(font);
        t88.setTypeface(font);
        t89.setTypeface(font);
        t90.setTypeface(font);
        t91.setTypeface(font);
        t92.setTypeface(font);
        t93.setTypeface(font);
        t94.setTypeface(font);
        t95.setTypeface(font);
        t96.setTypeface(font);
        t97.setTypeface(font);
        t98.setTypeface(font);
        t99.setTypeface(font);
        t100.setTypeface(font);
        t101.setTypeface(font);
        t102.setTypeface(font);
        t103.setTypeface(font);
        t104.setTypeface(font);
        t105.setTypeface(font);
        t106.setTypeface(font);
        t107.setTypeface(font);
        t108.setTypeface(font);
        t109.setTypeface(font);
        t110.setTypeface(font);
        t111.setTypeface(font);
        t112.setTypeface(font);
        t113.setTypeface(font);
        t114.setTypeface(font);
        t115.setTypeface(font);
        t116.setTypeface(font);
        t117.setTypeface(font);
        t118.setTypeface(font);
        t119.setTypeface(font);
        t120.setTypeface(font);
        t121.setTypeface(font);
        t122.setTypeface(font);
        t123.setTypeface(font);
        t124.setTypeface(font);
        t125.setTypeface(font);
        t126.setTypeface(font);
        t127.setTypeface(font);
        t128.setTypeface(font);
        t129.setTypeface(font);
        t130.setTypeface(font);
        t131.setTypeface(font);
        t132.setTypeface(font);
        t133.setTypeface(font);
        t134.setTypeface(font);
        t135.setTypeface(font);
        t136.setTypeface(font);
        t137.setTypeface(font);
        t138.setTypeface(font);
        t139.setTypeface(font);
        t140.setTypeface(font);
        t141.setTypeface(font);
        t142.setTypeface(font);
        t143.setTypeface(font);
        t144.setTypeface(font);
        t145.setTypeface(font);
        t146.setTypeface(font);
        t147.setTypeface(font);
        t148.setTypeface(font);

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
        t30.setText("110008");
        t31.setText("220076");
        t32.setText("332567");
        t33.setText("876106");
        t34.setText("111777");
        t35.setText("111555");
        t36.setText("000444");
        t37.setText("000654");
        t38.setText("987000");
        t39.setText("551111");
        t40.setText("666332");
        t41.setText("222098");
        t42.setText("444333");
        t43.setText("111415");
        t44.setText("229944");
        t45.setText("076111");
        t46.setText("123452");
        t47.setText("222330");
        t48.setText("666666");
        t49.setText("092332");
        tv9.setText("777508");
        t50.setText("435236");
        t51.setText("000946");
        t52.setText("377777");
        t53.setText("333946");
        t54.setText("176946");
        t55.setText("346546");
        t56.setText("300000");
        t57.setText("111111");
        t58.setText("123456");
        t59.setText("666666");
        t60.setText("000076");
        t61.setText("234567");
        t62.setText("876406");
        t63.setText("777777");
        t64.setText("555555");
        t65.setText("444444");
        t66.setText("327654");
        t67.setText("987432");
        t68.setText("555000");
        t69.setText("666666");
        t70.setText("987098");
        t71.setText("657333");
        t72.setText("432415");
        t73.setText("111144");
        t74.setText("000054");
        t75.setText("345672");
        t76.setText("111100");
        t77.setText("441166");
        t78.setText("784218");
        t79.setText("110008");
        t80.setText("220076");
        t81.setText("332567");
        t82.setText("876106");
        t83.setText("111777");
        t84.setText("111555");
        t85.setText("000444");
        t86.setText("000654");
        t87.setText("987000");
        t88.setText("551111");
        t89.setText("666332");
        t90.setText("222098");
        t91.setText("444333");
        t92.setText("111415");
        t93.setText("229944");
        t94.setText("076111");
        t95.setText("123452");
        t96.setText("222330");
        t97.setText("666666");
        t98.setText("092332");
        t99.setText("222098");
        t100.setText("444333");
        t101.setText("111415");
        t102.setText("229944");
        t103.setText("076111");
        t104.setText("123452");
        t105.setText("222330");
        t106.setText("666666");
        t107.setText("092332");
        t108.setText("444333");
        t109.setText("111415");
        t110.setText("229944");
        t111.setText("076111");
        t112.setText("123452");
        t113.setText("222330");
        t114.setText("666666");
        t115.setText("092332");
        t116.setText("444333");
        t117.setText("111415");
        t118.setText("229944");
        t119.setText("076111");
        t120.setText("123452");
        t121.setText("222330");
        t122.setText("666666");
        t123.setText("092332");
        t124.setText("444333");
        t125.setText("111415");
        t126.setText("229944");
        t127.setText("076111");
        t128.setText("123452");
        t129.setText("222330");
        t130.setText("666666");
        t131.setText("092332");
        t132.setText("123452");
        t133.setText("222330");
        t134.setText("666666");
        t135.setText("092332");
        t136.setText("444333");
        t137.setText("111415");
        t138.setText("229944");
        t139.setText("076111");
        t140.setText("123452");
        t141.setText("222330");
        t142.setText("666666");
        t143.setText("092332");
        t144.setText("123452");
        t145.setText("222330");
        t146.setText("666666");
        t147.setText("092332");
        t148.setText("092332");
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
        t1.setText("000236");
        t2.setText("111146");
        t3.setText("222777");
        t4.setText("000046");
        t5.setText("426746");
        t6.setText("112546");
        t7.setText("340000");
        t8.setText("222111");
        t9.setText("000856");
        t10.setText("434566");
        t11.setText("111176");
        t12.setText("345567");
        t13.setText("234506");
        t14.setText("722277");
        t15.setText("000055");
        t16.setText("411144");
        t17.setText("000654");
        t18.setText("467132");
        t19.setText("112300");
        t20.setText("111111");
        t21.setText("222228");
        t22.setText("333333");
        t23.setText("000755");
        t24.setText("888888");
        t25.setText("034564");
        t26.setText("324562");
        t27.setText("333300");
        t28.setText("221456");
        t29.setText("722228");
        t30.setText("000008");
        t31.setText("111116");
        t32.setText("000067");
        t33.setText("234566");
        t34.setText("112000");
        t35.setText("000005");
        t36.setText("113454");
        t37.setText("222254");
        t38.setText("333000");
        t39.setText("554671");
        t40.setText("677777");
        t41.setText("288888");
        t42.setText("409833");
        t43.setText("199415");
        t44.setText("299000");
        t45.setText("054321");
        t46.setText("223456");
        t47.setText("000030");
        t48.setText("645674");
        t49.setText("123332");
        tv9.setText("124308");
        t50.setText("433416");
        t51.setText("033526");
        t52.setText("345777");
        t53.setText("343946");
        t54.setText("122226");
        t55.setText("334346");
        t56.setText("245210");
        t57.setText("122211");
        t58.setText("111116");
        t59.setText("333366");
        t60.setText("054276");
        t61.setText("221367");
        t62.setText("874226");
        t63.setText("711177");
        t64.setText("532455");
        t65.setText("422224");
        t66.setText("312344");
        t67.setText("934532");
        t68.setText("554543");
        t69.setText("612456");
        t70.setText("531398");
        t71.setText("632453");
        t72.setText("432115");
        t73.setText("001144");
        t74.setText("033054");
        t75.setText("322672");
        t76.setText("114400");
        t77.setText("556566");
        t78.setText("777778");
        t79.setText("119998");
        t80.setText("228756");
        t81.setText("330967");
        t82.setText("876576");
        t83.setText("167777");
        t84.setText("100055");
        t85.setText("008544");
        t86.setText("011654");
        t87.setText("984600");
        t88.setText("576411");
        t89.setText("657932");
        t90.setText("211098");
        t91.setText("443413");
        t92.setText("110005");
        t93.setText("229004");
        t94.setText("075111");
        t95.setText("234252");
        t96.setText("232330");
        t97.setText("662326");
        t98.setText("092322");
        t99.setText("111118");
        t100.setText("111033");
        t101.setText("000415");
        t102.setText("000844");
        t103.setText("009646");
        t104.setText("123400");
        t105.setText("222111");
        t106.setText("666623");
        t107.setText("092300");
        t108.setText("444324");
        t109.setText("110000");
        t110.setText("229333");
        t111.setText("076100");
        t112.setText("123421");
        t113.setText("222000");
        t114.setText("666611");
        t115.setText("092111");
        t116.setText("444322");
        t117.setText("111000");
        t118.setText("229111");
        t119.setText("076112");
        t120.setText("123000");
        t121.setText("221244");
        t122.setText("666006");
        t123.setText("092112");
        t124.setText("444213");
        t125.setText("110005");
        t126.setText("223334");
        t127.setText("074441");
        t128.setText("123002");
        t129.setText("221110");
        t130.setText("661116");
        t131.setText("092002");
        t132.setText("123002");
        t133.setText("222440");
        t134.setText("664446");
        t135.setText("095552");
        t136.setText("447773");
        t137.setText("118885");
        t138.setText("220694");
        t139.setText("072221");
        t140.setText("124562");
        t141.setText("222090");
        t142.setText("662226");
        t143.setText("092432");
        t144.setText("120922");
        t145.setText("221130");
        t146.setText("662226");
        t147.setText("091112");
        t148.setText("092222");
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
        tv8.setText("003393");
        t1.setText("565236");
        t2.setText("990946");
        t3.setText("117777");
        t4.setText("300946");
        t5.setText("111946");
        t6.setText("322546");
        t7.setText("399000");
        t8.setText("000111");
        t9.setText("000456");
        t10.setText("876666");
        t11.setText("110076");
        t12.setText("234567");
        t13.setText("876406");
        t14.setText("111777");
        t15.setText("111155");
        t16.setText("422244");
        t17.setText("000054");
        t18.setText("111132");
        t19.setText("111000");
        t20.setText("222666");
        t21.setText("444098");
        t22.setText("111333");
        t23.setText("232315");
        t24.setText("111144");
        t25.setText("022254");
        t26.setText("111672");
        t27.setText("121100");
        t28.setText("441166");
        t29.setText("784218");
        t30.setText("110008");
        t31.setText("220076");
        t32.setText("332567");
        t33.setText("876106");
        t34.setText("111777");
        t35.setText("132555");
        t36.setText("111444");
        t37.setText("022254");
        t38.setText("333000");
        t39.setText("000001");
        t40.setText("121122");
        t41.setText("111098");
        t42.setText("111333");
        t43.setText("222115");
        t44.setText("339944");
        t45.setText("013211");
        t46.setText("144444");
        t47.setText("000000");
        t48.setText("634111");
        t49.setText("022222");
        tv9.setText("111108");
        t50.setText("000736");
        t51.setText("034946");
        t52.setText("388877");
        t53.setText("111146");
        t54.setText("222246");
        t55.setText("111546");
        t56.setText("111110");
        t57.setText("000111");
        t58.setText("124316");
        t59.setText("111166");
        t60.setText("234216");
        t61.setText("111117");
        t62.setText("212436");
        t63.setText("000077");
        t64.setText("123455");
        t65.setText("114444");
        t66.setText("566254");
        t67.setText("987432");
        t68.setText("548758");
        t69.setText("611166");
        t70.setText("981118");
        t71.setText("657333");
        t72.setText("432415");
        t73.setText("100144");
        t74.setText("000054");
        t75.setText("345672");
        t76.setText("111100");
        t77.setText("441166");
        t78.setText("711218");
        t79.setText("222208");
        t80.setText("211076");
        t81.setText("332567");
        t82.setText("876106");
        t83.setText("111777");
        t84.setText("111555");
        t85.setText("000444");
        t86.setText("000654");
        t87.setText("987000");
        t88.setText("112411");
        t89.setText("666332");
        t90.setText("222098");
        t91.setText("421313");
        t92.setText("213215");
        t93.setText("229944");
        t94.setText("076111");
        t95.setText("123452");
        t96.setText("213230");
        t97.setText("666666");
        t98.setText("011132");
        t99.setText("213218");
        t100.setText("222333");
        t101.setText("222225");
        t102.setText("333334");
        t103.setText("123222");
        t104.setText("555552");
        t105.setText("111330");
        t106.setText("000066");
        t107.setText("111332");
        t108.setText("444333");
        t109.setText("111415");
        t110.setText("229944");
        t111.setText("076111");
        t112.setText("123452");
        t113.setText("222330");
        t114.setText("666666");
        t115.setText("092332");
        t116.setText("444333");
        t117.setText("111415");
        t118.setText("229944");
        t119.setText("076111");
        t120.setText("123452");
        t121.setText("255505");
        t122.setText("600006");
        t123.setText("092332");
        t124.setText("444333");
        t125.setText("111415");
        t126.setText("229944");
        t127.setText("076111");
        t128.setText("123452");
        t129.setText("222330");
        t130.setText("666666");
        t131.setText("012342");
        t132.setText("155552");
        t133.setText("232111");
        t134.setText("611123");
        t135.setText("092332");
        t136.setText("444333");
        t137.setText("111415");
        t138.setText("229944");
        t139.setText("024111");
        t140.setText("667892");
        t141.setText("299990");
        t142.setText("664786");
        t143.setText("055432");
        t144.setText("654652");
        t145.setText("999590");
        t146.setText("653566");
        t147.setText("011452");
        t148.setText("477792");
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
        tv8.setText("323393");
        t1.setText("532146");
        t2.setText("000111");
        t3.setText("300007");
        t4.setText("333116");
        t5.setText("176446");
        t6.setText("000546");
        t7.setText("333000");
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
        t30.setText("110008");
        t31.setText("220076");
        t32.setText("332567");
        t33.setText("876106");
        t34.setText("111777");
        t35.setText("111555");
        t36.setText("000444");
        t37.setText("000654");
        t38.setText("987000");
        t39.setText("551111");
        t40.setText("666332");
        t41.setText("222098");
        t42.setText("444333");
        t43.setText("111415");
        t44.setText("229944");
        t45.setText("076111");
        t46.setText("123452");
        t47.setText("222330");
        t48.setText("666666");
        t49.setText("092332");
        tv9.setText("777508");
        t50.setText("435236");
        t51.setText("000946");
        t52.setText("377777");
        t53.setText("333946");
        t54.setText("176946");
        t55.setText("346546");
        t56.setText("300000");
        t57.setText("111111");
        t58.setText("123456");
        t59.setText("666666");
        t60.setText("000076");
        t61.setText("234567");
        t62.setText("876406");
        t63.setText("777777");
        t64.setText("555555");
        t65.setText("444444");
        t66.setText("327654");
        t67.setText("987432");
        t68.setText("555000");
        t69.setText("666666");
        t70.setText("987098");
        t71.setText("657333");
        t72.setText("432415");
        t73.setText("111144");
        t74.setText("000054");
        t75.setText("345672");
        t76.setText("111100");
        t77.setText("441166");
        t78.setText("784218");
        t79.setText("110008");
        t80.setText("220076");
        t81.setText("332567");
        t82.setText("876106");
        t83.setText("111777");
        t84.setText("111555");
        t85.setText("000444");
        t86.setText("000654");
        t87.setText("987000");
        t88.setText("551111");
        t89.setText("666332");
        t90.setText("222098");
        t91.setText("444333");
        t92.setText("111415");
        t93.setText("229944");
        t94.setText("076111");
        t95.setText("123452");
        t96.setText("222330");
        t97.setText("666666");
        t98.setText("092332");
        t99.setText("222098");
        t100.setText("444333");
        t101.setText("111415");
        t102.setText("229944");
        t103.setText("076111");
        t104.setText("123452");
        t105.setText("222330");
        t106.setText("666666");
        t107.setText("092332");
        t108.setText("444333");
        t109.setText("111415");
        t110.setText("229944");
        t111.setText("076111");
        t112.setText("123452");
        t113.setText("222330");
        t114.setText("666666");
        t115.setText("092332");
        t116.setText("444333");
        t117.setText("111415");
        t118.setText("229944");
        t119.setText("076111");
        t120.setText("123452");
        t121.setText("222330");
        t122.setText("666666");
        t123.setText("092332");
        t124.setText("444333");
        t125.setText("111415");
        t126.setText("229944");
        t127.setText("076111");
        t128.setText("123452");
        t129.setText("222330");
        t130.setText("666666");
        t131.setText("092332");
        t132.setText("123452");
        t133.setText("222330");
        t134.setText("666666");
        t135.setText("092332");
        t136.setText("444333");
        t137.setText("111415");
        t138.setText("229944");
        t139.setText("076111");
        t140.setText("123452");
        t141.setText("222330");
        t142.setText("666666");
        t143.setText("092332");
        t144.setText("123452");
        t145.setText("222330");
        t146.setText("666666");
        t147.setText("092332");
        t148.setText("092332");
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














