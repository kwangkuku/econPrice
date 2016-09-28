package com.promptnow.econprice.fragment.lottery;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.ArrayList;


/**
 * Created by Admin on 8/9/2559.
 */


// Custom Spinner
public class CustomAdapterLotto extends BaseAdapter {

    Context mContext;
    String[] strName;



    public CustomAdapterLotto(Context context, String[] strName) {
        this.mContext = context;
        this.strName = strName;

    }

    public int getCount() {
        return strName.length;
    }

    public Object getItem(int position) {

        return null;
    }


    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        view = inflater.inflate(R.layout.list_item_adapter, parent, false);



        TextView textView = (TextView) view.findViewById(R.id.name_spin);
        textView.setText(strName[position]);

        Typeface font;
        font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");
        textView.setTypeface(font);


        View.OnClickListener yourClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                //put your desired action here

            }
        };

        return view;
    }


}




