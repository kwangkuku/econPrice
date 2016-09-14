package com.promptnow.econprice.fragment.weather;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.activity.Menu;

public class MainWeatherFragment extends Fragment {
    private View rootView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_stucture_weather, container, false);

        String[] list = {"กรุงเทพมหานครและปริมณฑล", "ภาคเหนือ", "ภาคตะวันออกเฉียงเหนือ"
                , "ภาคกลาง", "ภาคตะวันออก", "ภาคใต้"};

        CustomAdapterr adapter = new CustomAdapterr(getActivity(), list);

        final ListView listView = (ListView) rootView.findViewById(R.id.listView1);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()


        {

            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Intent intent = new Intent(getActivity(), SecondActivity.class);
                switch (position) {
                    case 0:
                        ((Menu) getActivity()).setFragment(new SecondActivity());

                        break;
                    case 1:
                        //intent.putExtra("indexlist", "ภาคเหนือ");

                        ((Menu) getActivity()).setFragment(new SecondActivity());
                        break;
                    case 2:
//                        intent.putExtra("indexlist", "ภาคตะวันออกเฉียงเหนือ");
                        ((Menu) getActivity()).setFragment(new SecondActivity());
                        break;
                    case 3:
//                        intent.putExtra("indexlist", "ภาคกลาง");
                        ((Menu) getActivity()).setFragment(new SecondActivity());
                        break;
                    case 4:
//                       intent.putExtra("indexlist", "ภาคตะวันออก");
                        ((Menu) getActivity()).setFragment(new SecondActivity());
                        break;
                    case 5:
//                        intent.putExtra("indexlist", "ภาคใต้");
                        ((Menu) getActivity()).setFragment(new SecondActivity());
                        break;

                }

            }
        });
        return rootView;
    }
}