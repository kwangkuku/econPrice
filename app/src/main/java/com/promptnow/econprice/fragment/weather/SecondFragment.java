package com.promptnow.econprice.fragment.weather;


import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.view.Singleton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.promptnow.econprice.R.id.editText;

/**
 * Created by Admin on 9/9/2559.
 */
public class SecondFragment extends Fragment {

    private Typeface font;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private View rootView;
    private MyExpandableAdapter listAdapter;
    private TextView txt_time,textData,update,edittext,lblListItem ;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_secondwea, container, false);


        setView();
        setDateTime();


        return rootView;
    }


    private void setView() {


        expListView = (ExpandableListView) rootView.findViewById(R.id.expListView);
        expListView.setDividerHeight(2);

        // preparing list data
        prepareListData();

        listAdapter = new MyExpandableAdapter(getActivity(), listDataHeader, listDataChild);
        // setting list adapter
        expListView.setAdapter(listAdapter);

        Singleton.getInstance().getIndexlist().toString();

        //ประกาศตัวปุ่มย้อนกลับของเรา ผูกตัวแปรไว้
        ImageView img = (ImageView) getActivity().findViewById(R.id.action);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือก ถาคของเรา
                getFragmentManager().popBackStack();

            }
        });
//          textData = (TextView) rootView.findViewById(R.id.editText);
//        textData.setText(Singleton.getInstance().getIndexlist());

        edittext = (TextView) rootView.findViewById(R.id.editText);
        edittext.setText(Singleton.getInstance().getIndexlist());


//font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        edittext.setTypeface(font);
//        textData.setTypeface(font);
        update = (TextView) rootView.findViewById(R.id.update);
        update.setTypeface(font);



        //เราทำให้ เมื่อเรากดกลุ่มหัวอันใหญ่ แล้วลูกมันจะออกมา แล้วถ้าเรากดแีกครั้งอันที่เราเคยกดมันจะหุบ
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if(expListView.isGroupExpanded(groupPosition)) {
                    expListView.collapseGroup(groupPosition);
                }
                else {

                    for (int i = 0; i < listAdapter.getGroupCount(); i++) {
                        if ( groupPosition != i) {
                            expListView.collapseGroup(i);
                        }else{
                            expListView.expandGroup(i);
                        }
                    }
                }
return true;

                }
            });
}



    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding child data
        listDataHeader.add("นนทบุรี");
        listDataHeader.add("สมุทรปราการ");
        listDataHeader.add("ปทุมธานี");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("44.5°C");


        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("44.5°C");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("44.5°C");

        Log.d(TAG, "prepareListData: " + Singleton.getInstance().getIndexlist());


        listDataChild.put(listDataHeader.get(0), top250);// Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);



    }

    public void setDateTime() {
        TextView txt_date = (TextView) rootView.findViewById(R.id.txt_date);
        txt_time = (TextView) rootView.findViewById(R.id.txt_time);

        Calendar c = Calendar.getInstance();

        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        String time = hour + ":" +minutes + " " + "น.";

        if (hour < 12 && hour >= 0) {
            txt_time.setText(time);
        } else {
            hour -= 12;
            if (hour == 0) {
            }
            txt_time.setText(time);
        }
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        month += 1;
        int year = c.get(Calendar.YEAR);
        String date = day + "/" + month + "/" + year;

        //assuming that you need date and time in separate textview named txt_date and txt_time.

        txt_date.setText(date);



    }
}


