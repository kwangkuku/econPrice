package com.promptnow.econprice.fragment.oil;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.promptnow.econprice.R;

/**
 * Created by Acer on 23/9/2559.
 */

public class CustomAdapter extends BaseAdapter {
    private Context mContext;

    public CustomAdapter(Context context) {
        mContext = context;
    }

    public int getCount() {
        return 3;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

//    public View getView(int position, View convertView, ViewGroup parent) {
//        ImageView imageView;
//
////        if (convertView == null) {
////            imageView = new ImageView(mContext);
////            imageView.setLayoutParams(new GridView.LayoutParams(
////                    ViewGroup.LayoutParams.MATCH_PARENT, 200));
////            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
////            imageView.setPadding(4, 4, 4, 4);
////        } else {
////            imageView = (ImageView) convertView;
////        }
////
////        imageView.setImageResource(R.drawable.ic_ptt);
////       return imageView;
////  }
//}

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {  // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    private Integer[] mThumbIds = {
            R.drawable.ic_bangjak,
            R.drawable.ic_shell,
            R.drawable.ic_esso
    };
}