package com.promptnow.econprice.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Acer on 30/8/2559.
 */

public class CustomTextView extends TextView {
    public CustomTextView(Context context) {
        super(context);


        //setTextSize(TypedValue.COMPLEX_UNIT_SP, 10);
    }

    public CustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public CustomTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }







    @Override
    public void setTextSize(int unit, float size) {

        super.setTextSize(unit, size);
    }
}
