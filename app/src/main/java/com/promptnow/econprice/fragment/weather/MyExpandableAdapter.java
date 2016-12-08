package com.promptnow.econprice.fragment.weather;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.service.UserRequest;
import com.promptnow.econprice.service.WeatherModel;

import java.util.HashMap;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 12/9/2559.
 */

public class MyExpandableAdapter extends BaseExpandableListAdapter {

//    private final WeatherModel _weatherModel = WeatherData.getInstance().getWeatherModel();
    private Context _context;
    private List<String> _listDataHeader; // header titles
    // child data in format of header title, child title
    private HashMap<String, List<String>> _listDataChild;

    List<UserRequest> userRequests;

    public MyExpandableAdapter(WeatherModel weatherModel, Context context, List<String> listDataHeader,
                               HashMap<String, List<String>> listChildData) {
//        _weatherModel = weatherModel;
        this._context = context;
        this._listDataHeader = listDataHeader;
        this._listDataChild = listChildData;


    }

    public MyExpandableAdapter(Context context, List<UserRequest> userRequests) {
        this._context = context;
        this.userRequests = userRequests;
//        this._weatherModel = weatherModel;
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


//        final String childText = (String) getChild(groupPosition, childPosition);

        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_item, null);

        }
//        UserRequest userRequest  = (UserRequest) _listDataChild.get(groupPosition);
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
        txtListChild.setText(userRequests.get(groupPosition).getMaxTemperature());
        txt_number1.setText(userRequests.get(groupPosition).getWindDirection());
        txt_number2.setText(userRequests.get(groupPosition).getTempartureLevel());
        txt_number3.setText(userRequests.get(groupPosition).getWindSpeed());

        return convertView;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
//        return this._listDataChild.get(this._listDataHeader.get(groupPosition))
//                .size();

        return 1;


//
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this._listDataHeader.get(groupPosition);
    }


    @Override
    public int getGroupCount() {
        if (userRequests == null) {
            return 0;
        }
//        Log.d(TAG, "getGroupCount: "+userRequests.size());
        return userRequests.size();
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

//        String headerTitle = (String) getGroup(groupPosition);
//        UserRequest user = null;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this._context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_group, null);

        }

        Typeface font = Typeface.createFromAsset(_context.getAssets(), "tmedium.ttf");
        TextView txt_num = (TextView) convertView.findViewById(R.id.txt_num);
        txt_num.setTypeface(font);
        TextView lblListHeader = (TextView) convertView
                .findViewById(R.id.lblListHeader);
        lblListHeader.setTypeface(font);
        lblListHeader.setText(userRequests.get(groupPosition).getProvinceNameTh());
        txt_num.setText(userRequests.get(groupPosition).getMaxTemperature());
        ImageView im = (ImageView) convertView.findViewById(R.id.img_wea);
        Log.d(TAG, "getGroupView: " + userRequests.get(groupPosition).getWeatherDescription());

        if (userRequests.get(groupPosition).getWeatherDescription().equals("ฝนฟ้าคะนอง")) {
            Log.d(TAG, "getGroupView: 1");
            im.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_rain));
        } else if
                (userRequests.get(groupPosition).getWeatherDescription().equals("ท้องฟ้ามีเมฆบางส่วน")){
            im.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_jamsai));
    } else if
            (userRequests.get(groupPosition).getWeatherDescription().equals("ท้องฟ้าโปร่ง")) {
            im.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_sun));
        } else if
                (userRequests.get(groupPosition).getWeatherDescription().equals("ฝน"))
            im.setImageDrawable(ContextCompat.getDrawable(_context, R.drawable.ic_fon));


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