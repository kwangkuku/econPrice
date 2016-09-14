package com.promptnow.econprice.view;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.promptnow.econprice.R;


public class View_popup_false extends DialogFragment {

    private TextView txt;
    private String message;
    private TextView btn_ok;
    private String msg_ok;
    private Dialog dialog;
    private EditText ed;

    View.OnClickListener listenerOK;
    public onSubmitAlertDialogListener mListener;



    public interface onSubmitAlertDialogListener {
        void setOnSubmitAlertDialogListener();
    }


    public View_popup_false(String message, String button1) {
        this.message = message;
        msg_ok = button1;
    }

    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setContentView(R.layout.activity_popup_false);
        dialog.setCancelable(true);
        dialog.show();

        txt = (TextView) dialog.findViewById(R.id.txt);
        btn_ok = (Button) dialog.findViewById(R.id.btn_ok);


        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.setOnSubmitAlertDialogListener();
                dialog.dismiss();
            }


        });
        return dialog;

    }


}








