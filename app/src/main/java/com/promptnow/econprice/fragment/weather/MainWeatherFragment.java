package com.promptnow.econprice.fragment.weather;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.activity.Menu;
import com.promptnow.econprice.view.Singleton;

public class MainWeatherFragment extends Fragment {
    private View rootView;



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_stucture_weather, container, false);
     setView();



        return rootView;
    }

    private void setView() {

        final String[] list = {"กรุงเทพมหานครและปริมณฑล", "ภาคเหนือ", "ภาคตะวันออกเฉียงเหนือ"
                , "ภาคกลาง", "ภาคตะวันออก", "ภาคใต้"};

        //หน้าแรกไม่ควนมีปุ่มย้อนกลับ ประกาศตัวปุ่มย้อนกลับเพื่อให้ซ่อน
        ImageView action = (ImageView) getActivity().findViewById(R.id.action);
        action.setVisibility(View.INVISIBLE);

        CustomAdapterr adapter = new CustomAdapterr(getActivity(), list);

        final ListView listView = (ListView) rootView.findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), SecondFragment.class);
                switch (position) {
                    case 0:
                        ((Menu)getActivity()).setFragment(new SecondFragment());
                        Singleton.getInstance().setIndexlist(list[0]);
                        break;
                    case 1:
                        //intent.putExtra("indexlist", "ภาคเหนือ");

                        ((Menu)getActivity()).setFragment(new SecondFragment());
                        Singleton.getInstance().setIndexlist(list[1]);
                        break;
                    case 2:
//                        intent.putExtra("indexlist", "ภาคตะวันออกเฉียงเหนือ");
                        ((Menu)getActivity()).setFragment(new SecondFragment());
                        Singleton.getInstance().setIndexlist(list[2]);
                        break;
                    case 3:
//                        intent.putExtra("indexlist", "ภาคกลาง");
                        ((Menu)getActivity()).setFragment(new SecondFragment());
                        Singleton.getInstance().setIndexlist(list[3]);
                        break;
                    case 4:
//                       intent.putExtra("indexlist", "ภาคตะวันออก");
                        ((Menu)getActivity()).setFragment(new SecondFragment());
                        Singleton.getInstance().setIndexlist(list[4]);
                        break;
                    case 5:
//                        intent.putExtra("indexlist", "ภาคใต้");
                        ((Menu)getActivity()).setFragment(new SecondFragment());
                        Singleton.getInstance().setIndexlist(list[5]);
                        break;

                }

            }

        });
    }
}