package com.promptnow.econprice.fragment.oil;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.view.DatePickerFragment;

/**
 * Created by Whankung on 7/9/2559.
 */

public class OilFragment extends DialogFragment {
    private View rootView;


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.oil, container, false);
        setView();
        return rootView;
    }


    public void setView() {
        final LinearLayout ll = (LinearLayout) rootView.findViewById(R.id.table);
        TextView tv_date_oil_price = (TextView) rootView.findViewById(R.id.tv_date_oil_price);

        tv_date_oil_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Initialize a new date picker dialog fragment
                android.app.DialogFragment dFragment = new DatePickerFragment();

                // Show the date picker dialog fragment
                dFragment.show(getActivity().getFragmentManager(), "Date Picker");
            }
        });


    }
}



