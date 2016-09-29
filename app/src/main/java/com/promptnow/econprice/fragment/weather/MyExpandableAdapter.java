package com.promptnow.econprice.fragment.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.promptnow.econprice.R;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Admin on 12/9/2559.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter {

    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;


    public MyExpandableAdapter(Context context, List<String> listDataHeader,
                               HashMap<String, List<String>> listChildData) {
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;

    }

    @Override
    public Object getChild(int groupPosition, int childPosititon) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .get(childPosititon);


    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }


    @Override
    public View getChildView(int groupPosition, final int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {


        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);

        }
        Typeface font = Typeface.createFromAsset(_context.getAssets(), "tmedium.ttf");
        TextView lblListItem = (TextView) convertView.findViewById(R.id.lblListItem);
        lblListItem.setTypeface(font);
        TextView lblListItem1 = (TextView) convertView.findViewById(R.id.lblListItem1);
        lblListItem1.setTypeface(font);
        TextView lblListItem2 = (TextView) convertView.findViewById(R.id.lblListItem2);
        lblListItem2.setTypeface(font);
        TextView lblListItem3 = (TextView) convertView.findViewById(R.id.lblListItem3);
        lblListItem3.setTypeface(font);
        TextView txt_number1 = (TextView) convertView.findViewById(R.id.txt_number1);
        txt_number1.setTypeface(font);
        TextView txt_number2 = (TextView) convertView.findViewById(R.id.txt_number2);
        txt_number2.setTypeface(font);
        TextView txt_number3 = (TextView) convertView.findViewById(R.id.txt_number3);
        txt_number3.setTypeface(font);

        TextView txtListChild = (TextView) convertView
                .findViewById(R.id.txt_number);
        txtListChild.setTypeface(font);
        txtListChild.setText(childText);





        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
                .size();

//
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }

    @Override
    public int getGroupCount() {
        return this._listDataHeader.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {
        String headerTitle = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);
        }
        Typeface font = Typeface.createFromAsset(_context.getAssets(), "tmedium.ttf");
        TextView txt_num =(TextView) convertView.findViewById(R.id.txt_num);
        txt_num.setTypeface(font);
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(font);
        lblListHeader.setText(headerTitle);

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}
