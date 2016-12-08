
package com.promptnow.econprice.fragment.weather;


import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.service.HttpManager;
import com.promptnow.econprice.service.UserRequest;
import com.promptnow.econprice.service.WeatherData;
import com.promptnow.econprice.service.WeatherModel;
import com.promptnow.econprice.view.Singleton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;

/**
 * Created by Admin on 9/9/2559.
 */
public class SecondFragment extends Fragment {

    private Typeface font;
    private ExpandableListView expListView;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listDataChild;
    private View rootView;
    private MyExpandableAdapter listAdapter;
    private TextView txt_time, update, edittext;
    private WeatherModel weatherModel;
    private ProgressDialog progressDialog;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.activity_secondwea, container, false);


        setView();
        setDateTime();

 //ตัวดาว์โหลด ทำก่อนเรียก API
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("กำลังโหลดข้อมูล...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();


        Call<WeatherModel> call = HttpManager.getInstance().getUser().loadJson();
        call.enqueue(new Callback<WeatherModel>() {

            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {

                Log.d(TAG, "response: " + response.toString());
                WeatherData.getInstance().setWeatherModel(response.body());
                weatherModel = response.body();
               setStation();

                listAdapter.notifyDataSetChanged();
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                Log.d(TAG, "onFailure: " + t.toString());
            }
        });


        return rootView;
    }




    private void setView() {


        expListView = (ExpandableListView) rootView.findViewById(R.id.expListView);
        expListView.setDividerHeight(2);


        // preparing list data
        prepareListData();

        Singleton.getInstance().getIndexlist().toString();

        //ประกาศตัวปุ่มย้อนกลับของเรา ผูกตัวแปรไว้
        ImageView img = (ImageView) getActivity().findViewById(R.id.action);
        img.setVisibility(View.VISIBLE);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //กลับไปยังหน้าเลือก ถาคของเรา
                getFragmentManager().popBackStack();

            }
        });
//          textData = (TextView) rootView.findViewById(R.id.editText);
//        textData.setText(Singleton.getInstance().getIndexlist());

        edittext = (TextView) rootView.findViewById(R.id.editText);
        edittext.setText(Singleton.getInstance().getIndexlist());

//font
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        edittext.setTypeface(font);
//        textData.setTypeface(font);
        update = (TextView) rootView.findViewById(R.id.update);
        update.setTypeface(font);

        //เราทำให้ เมื่อเรากดกลุ่มหัวอันใหญ่ แล้วลูกมันจะออกมา แล้วถ้าเรากดแีกครั้งอันที่เราเคยกดมันจะหุบ
        expListView.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {

                if (expListView.isGroupExpanded(groupPosition)) {
                    expListView.collapseGroup(groupPosition);
                } else {

                    for (int i = 0; i < listAdapter.getGroupCount(); i++) {
                        if (groupPosition != i) {
                            expListView.collapseGroup(i);
                        } else {
                            expListView.expandGroup(i);
                        }
                    }
                }
                return true;

            }
        });
    }

    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();


        // Adding child data
        listDataHeader.add("นนทบุรี");
        listDataHeader.add("สมุทรปราการ");
        listDataHeader.add("ปทุมธานี");

        // Adding child data
        List<String> top250 = new ArrayList<String>();
        top250.add("44.5°C");

        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("44.5°C");

        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("44.5°C");

        Log.d(TAG, "prepareListData: " + Singleton.getInstance().getIndexlist());


        listDataChild.put(listDataHeader.get(0), top250);// Header, Child data
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);

    }

    public void setDateTime() {
        TextView txt_date = (TextView) rootView.findViewById(R.id.txt_date);
        txt_time = (TextView) rootView.findViewById(R.id.txt_time);

        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(System.currentTimeMillis());

        int minutes = c.get(Calendar.MINUTE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        String curTime = String.format("%02d:%02d", hour, minutes);
        String time = curTime;

        if (hour < 12 && hour >= 0) {
            txt_time.setText(time);
        } else {
            hour -= 12;
            if (hour == 0) {
            }
            txt_time.setText(time);
        }
        int day = c.get(Calendar.DAY_OF_MONTH);
        int month = c.get(Calendar.MONTH);
        month += 1;
        int year = c.get(Calendar.YEAR);
        String date = day + "/" + month + "/" + year;

        //assuming that you need date and time in separate textview named txt_date and txt_time.
        font = Typeface.createFromAsset(getContext().getAssets(), "tmedium.ttf");
        txt_time.setTypeface(font);
        txt_date.setTypeface(font);
        txt_date.setText(date);
    }

    private void setStation() {

//        weatherModel = WeatherData.getInstance().getWeatherModel();
        final String[] list = {"กรุงเทพมหานครและปริมณฑล", "ภาคเหนือ", "ภาคตะวันออกเฉียงเหนือ"
                , "ภาคกลาง", "ภาคตะวันออก", "ภาคใต้"};
        List<UserRequest> userRequests = new ArrayList<>();

        List<String> listprovice000 = new ArrayList<>();
        listprovice000.add("เชียงราย");
        listprovice000.add("เชียงใหม่");
        listprovice000.add("แม่ฮ่องสอน");
        listprovice000.add("ตาก");
        listprovice000.add("น่าน");
        listprovice000.add("อุตรดิตถ์");
        listprovice000.add("พิษณุโลก");
        listprovice000.add("กำแพงเพชร");
        listprovice000.add("พิจิตร");
        listprovice000.add("สุโขทัย");
        listprovice000.add("พะเยา");
        listprovice000.add("ลำพูน");
        listprovice000.add("ลำปาง");
        listprovice000.add("แพร่");
        listprovice000.add("เพชรบูรณ์");
        listprovice000.add("หนองคาย");


        List<String> listprovice001 = new ArrayList<>();
        listprovice001.add("กรุงเทพมหานคร");
        listprovice001.add("ปทุมธานี");
        listprovice001.add("นครปฐม");
        listprovice001.add("นนทบุรี");
        listprovice001.add("สมุทรปราการ");


        List listprovice002 = new ArrayList();
        listprovice002.add("หนองคาย");
        listprovice002.add("เลย");
        listprovice002.add("ขอนแก่น");
        listprovice002.add("อุบลราชธานี");
        listprovice002.add("นครราชสีมา");
        listprovice002.add("ร้อยเอ็ด");
        listprovice002.add("มุกดาหาร");
        listprovice002.add("อุดรธานี");
        listprovice002.add("หนองบัวลำภู");
        listprovice002.add("นครพนม");
        listprovice002.add("สกลนคร");
        listprovice002.add("กาฬสินธุ์");
        listprovice002.add("ชัยภูมิ");
        listprovice002.add("ศรีสะเกษ");
        listprovice002.add("ยโสธร");
        listprovice002.add("สุรินทร์");
        listprovice002.add("บุรีรัมย์");


        List listprovice003 = new ArrayList();
        listprovice003.add("กาญจนบุรี");
        listprovice003.add("นครสวรรค์");
        listprovice003.add("สุพรรณบุรี");
        listprovice003.add("ชัยนาท");
        listprovice003.add("ลพบุรี");
        listprovice003.add("พระนครศรีอยุธยา");
        listprovice003.add("ราชบุรี");
        listprovice003.add("สิงค์บุรี");
        listprovice003.add("สมุทรสงคราม");
        listprovice003.add("อ่างทอง");
        listprovice003.add("อุทัยธานี");
        listprovice003.add("สมุทรสาคร");


        List listprovice004 = new ArrayList();
        listprovice004.add("สระแก้ว");
        listprovice004.add("ชลบุรี");
        listprovice004.add("ระยอง");
        listprovice004.add("ปราจีนบุรี");
        listprovice004.add("ตราด");
        listprovice004.add("จันทบุรี");
        listprovice004.add("ฉะเชิงเทรา");
        listprovice004.add("นครนายก");
        listprovice004.add("พัทยา");


        List listprovice005 = new ArrayList();
        listprovice005.add("ประจวบศีรีขันธ์");
        listprovice005.add("ชุมพร");
        listprovice005.add("นครศรีธรรมราช");
        listprovice005.add("นราธิวาส");
        listprovice005.add("สุราษฤร์ธานี");
        listprovice005.add("ยะลา");
        listprovice005.add("ปัตตานี");
        listprovice005.add("สงขลา");
        listprovice005.add("หัวหิน (ประจวบคีรีขันธ์)");
        listprovice005.add("เกาะสมุย (สุราษฎร์ธานี)");
        listprovice005.add("พัทลุง");
        listprovice005.add("ระนอง");
        listprovice005.add("กระบี่");
        listprovice005.add("ตรัง");
        listprovice005.add("หาดใหญ่");
        listprovice005.add("สตูล");
        listprovice005.add("พังงา");
        listprovice005.add("ภูเก็ต");




        if (Singleton.getInstance().getIndexlist() == "กรุงเทพมหานครและปริมณฑล") {


            for (int j = 0; j < weatherModel.getWeatherModel().size(); j++) {
                for (int i = 0; i < listprovice001.size(); i++) {
                    if (weatherModel.getWeatherModel().get(j).getProvinceNameTh().equals(listprovice001.get(i))) {
                        userRequests.add(weatherModel.getWeatherModel().get(j));

                    }
                }

            }

        }

        if (Singleton.getInstance().getIndexlist() == "ภาคเหนือ") {
            for (int j = 0; j < weatherModel.getWeatherModel().size(); j++) {
                for (int i = 0; i < listprovice000.size(); i++) {
                    if (weatherModel.getWeatherModel().get(j).getProvinceNameTh().equals(listprovice000.get(i))) {
                        userRequests.add(weatherModel.getWeatherModel().get(j));

                    }
                }

            }
        }

        if (Singleton.getInstance().getIndexlist() == "ภาคตะวันออกเฉียงเหนือ"){
            for (int j=0; j< weatherModel.getWeatherModel().size();j++){
                for (int i=0; i< listprovice002.size(); i++){
                    if(weatherModel.getWeatherModel().get(j).getProvinceNameTh().equals(listprovice002.get(i))){
                        userRequests.add(weatherModel.getWeatherModel().get(j));
                    }
                }
            }
        }

        if (Singleton.getInstance().getIndexlist() == "ภาคกลาง"){
            for (int j= 0; j<weatherModel.getWeatherModel().size();j++){
                for (int i =0; i<listprovice003.size();i++){
                    if(weatherModel.getWeatherModel().get(j).getProvinceNameTh().equals(listprovice003.get(i))){
                        userRequests.add(weatherModel.getWeatherModel().get(j));
                    }

                }
            }
        }

        if (Singleton.getInstance().getIndexlist() == "ภาคตะวันออก"){
            for (int j=0; j<weatherModel.getWeatherModel().size();j++){
                for (int i=0; i<listprovice004.size();i++){
                    if (weatherModel.getWeatherModel().get(j).getProvinceNameTh().equals(listprovice004.get(i))){
                     userRequests.add(weatherModel.getWeatherModel().get(j));
                    }
                }
            }
        }
        if (Singleton.getInstance().getIndexlist()=="ภาคใต้"){
            for (int j=0; j<weatherModel.getWeatherModel().size();j++){
                for (int i=0; i<listprovice005.size();i++){
                    if (weatherModel.getWeatherModel().get(j).getProvinceNameTh().equals(listprovice005.get(i))){
                        userRequests.add(weatherModel.getWeatherModel().get(j));
                    }
                }
            }
        }


        Log.d(TAG, "setStation: size" + ((userRequests.size())));
        //        listAdapter = new MyExpandableAdapter(getActivity(), listDataHeader, listDataChild);
        listAdapter = new MyExpandableAdapter(getActivity(), userRequests);
        // setting list adapter
        expListView.setAdapter(listAdapter);



    }

}
