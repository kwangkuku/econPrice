package com.promptnow.econprice.fragment.weather;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 9/9/2559.
 */
public class SecondActivity extends Fragment {



   private ExpandableListView expListView;

     private List<String>listDataHeader ;
    private  HashMap<String, List<String>>listDataChild ;

    private View rootView;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_secondwea, container, false);
        setView();


        expListView = (ExpandableListView) rootView.findViewById(R.id.expListView);
              expListView.setDivider(null);
        // preparing list data
        prepareListData();

        MyExpandableAdapter listAdapter = new MyExpandableAdapter(getActivity(),listDataHeader,listDataChild);
        // setting list adapter
     expListView.setAdapter(listAdapter);



        return rootView;
    }

    private void setView() {



        TextView textData = (TextView) getActivity().findViewById(R.id.editText);

    }



        @Override
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);
        }

        private void prepareListData () {
            listDataHeader = new ArrayList<String>();
             listDataChild = new HashMap<String, List<String>>();


            // Adding child data
            listDataHeader.add("นนทบุรี");
            listDataHeader.add("สมุทปราการ");
            listDataHeader.add("ปทุมธานี");

            // Adding child data
            List<String> top250 = new ArrayList<String>();
            top250.add("อุณหภูมอากาศปัจจุบัน");
            top250.add("ทิศทางลม");
            top250.add("ค่าเฉลี่ยความชื้นสัมพัทธ์");
            top250.add("ความเร็วลม");
//
          //List<String> top2500 = new ArrayList<String>();
            //top2500.add("90");
//        List<String> nowShowing = new ArrayList<String>();
//        nowShowing.add("The Conjuring");
//        nowShowing.add("Despicable Me 2");
//        nowShowing.add("Turbo");
//        nowShowing.add("Grown Ups 2");
//        nowShowing.add("Red 2");
//        nowShowing.add("The Wolverine");
//
//        List<String> comingSoon = new ArrayList<String>();
//        comingSoon.add("2 Guns");
//        comingSoon.add("The Smurfs 2");
//        comingSoon.add("The Spectacular Now");
//        comingSoon.add("The Canyons");
//        comingSoon.add("Europa Report");

            listDataChild.put(listDataHeader.get(0), top250 );// Header, Child data
            //listDataChild.put(listDataHeader.get(0), top2500);
            //listDataChild.put(listDataHeader.get(2), comingSoon);
        }



}


