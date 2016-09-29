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

import java.text.DecimalFormat;
import java.util.Calendar;

/**
 * Created by Whankung on 7/9/2559.
 */

public class OilFragment2 extends Fragment {
    private View rootView;
    private Typeface font;
    private Spinner oilTypeSpinner;
    private TextView tv_date_oil_vs, tv, tv2, tv3, tv4,tv5,tv6,tv7;
    private TextView show_vs1, show_vs2, tv_show_result;
    private ImageView img_vs1, img_vs2 ;
    double vs1, vs2;
    double result;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil2, container, false);
        show_vs1 = (TextView) rootView.findViewById(R.id.show_vs1);
        show_vs2 = (TextView) rootView.findViewById(R.id.show_vs2);
        tv_show_result = (TextView) rootView.findViewById(R.id.tv_show_result);
        img_vs1 = (ImageView) rootView.findViewById(R.id.img_vs1);
        img_vs2 = (ImageView) rootView.findViewById(R.id.img_vs2);


//        GridView gridview = (GridView) this.getActivity().findViewById(R.id.gridview);
//        gridview.setAdapter(new CustomAdapter(this.getActivity()));
//
//        gridview.setAdapter(new CustomAdapter(rootView.getContext()));


//        GridView gridview = (GridView) rootView.findViewById(R.id.gridview);
//
//        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//
//            }
//        });

        setView();
        setOilTypeSpiner();
        setType();
        setVSpopup();
        setShowResult();
        return rootView;

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
                        dialog.dismiss();
                        //   img_vs2.setImageResource(R.drawable.ic_bangjak);

                        // img_vs2.setImageResource(R.drawable.ic_bangjak);


                    }
                });

                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs1.setImageResource(Dummy.getInstance().popup.get(2));
                        dialog.dismiss();
                    }
                });
                dialog.show();

                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs1.setImageResource(Dummy.getInstance().popup.get(3));
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
                        dialog.dismiss();

                    }
                });


                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(1));
                        dialog.dismiss();

                    }
                });


                b3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(2));
                        dialog.dismiss();
                    }
                });


                b4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        img_vs2.setImageResource(Dummy.getInstance().popup.get(3));
                        dialog.dismiss();
                    }
                });
                dialog.show();
            }
        });


    }

    private void setShowResult() {

    }

    private void setType() {
//        oilTypeSpinner.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                oilTypeSpinner.performClick();
//
//            }
//        });
    }

    private void setOilTypeSpiner() {
        oilTypeSpinner = (Spinner) rootView.findViewById(R.id.oilTypeSpinner);
        //  oilTypeSpinner.setEnabled(false);
        String[] List = {"เบนซิล 95", "แก๊สโซฮอล์ 95", "E20", "E85", "ดีเซล"};
        CustomAdapterOil oilAdapter = new CustomAdapterOil(getActivity(), List);
//        ArrayList<String> arrayList = new ArrayList<String>();
//        arrayList.add("เบนซิล 95");
//        arrayList.add("แก๊สโซฮอล์ 95");
//        arrayList.add("E20");
//        arrayList.add("E85");
//        arrayList.add("ดีเซล");
//
//
//        ArrayAdapter<String> oilAdapter = new ArrayAdapter<String>(getActivity(),
//                android.R.layout.simple_list_item_1, arrayList);
        oilTypeSpinner.setAdapter(oilAdapter);


        oilTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView adapter, View v, int i, long lng) {

                if (i == 0) {
                    vs1 = 31.76;
                    vs2 = 32.21;
                    result = vs1 - vs2;
                } else if (i == 1) {
                    vs1 = 35.76;
                    vs2 = 31.21;
                    result = vs1 - vs2;

                } else if (i == 2) {
                    vs1 = 38.36;
                    vs2 = 37.11;
                    result = vs1 - vs2;

                } else if (i == 3) {
                    vs1 = 11.54;
                    vs2 = 23.55;
                    result = vs1 - vs2;

                } else if (i == 4) {
                    vs1 = 52.54;
                    vs2 = 35.86;
                    result = vs1 - vs2;

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
        tv_show_result.setText(new DecimalFormat("0.00").format(+result));
        tv_show_result.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);


        if (result < 0) {
            show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
            show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
        } else if (result > 0) {
            show_vs1.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape));
            show_vs2.setBackground(getActivity().getResources().getDrawable(R.drawable.result_shape_sp));
        }


    }

    //Date Picker
    private void setView() {
        tv_date_oil_vs = (TextView) rootView.findViewById(R.id.tv_date_oil_vs);

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


        tv_date_oil_vs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                // Initialize a new date picker dialog fragment
//                android.app.DialogFragment dFragment = new DatePickerFragmentDialog();
//
//                // Show the date picker dialog fragment
//                dFragment.show(getActivity().getFragmentManager(), "Date Picker");
            }
        });


    }
}







