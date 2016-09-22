package com.promptnow.econprice.fragment.weather;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.lottery.CustomAdapter;

import static java.security.AccessController.getContext;

/**
 * Created by Admin on 8/9/2559.
 */

public class CustomAdapterr extends BaseAdapter {

    Context mContext;
    String[] strName;


    public CustomAdapterr(Context context, String[] strName) {
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
        LayoutInflater mInflater =
                (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        if (view == null)
            view = mInflater.inflate(R.layout.listview_row, parent, false);
        TextView textView = (TextView) view.findViewById(R.id.textView1);

        Typeface font = Typeface.createFromAsset(mContext.getAssets(), "tmedium.ttf");
        textView.setTypeface(font);


        textView.setText(strName[position]);


        if (position % 2 == 0) {

            view.setBackgroundResource(R.color.colorTop);

        } else {

            view.setBackgroundResource(R.color.color_bg_table);

        }

        View.OnClickListener yourClickListener = new View.OnClickListener() {
            public void onClick(View v) {
                //put your desired action here

            }
        };


        return view;
    }

//
//    public AssetManager getAssets() {
//        return getAssets();
//    }
}




