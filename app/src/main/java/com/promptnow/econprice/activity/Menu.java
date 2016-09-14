package com.promptnow.econprice.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.lottery.NullLotteryFragment;
import com.promptnow.econprice.fragment.oil.NullOilFragment;
import com.promptnow.econprice.fragment.weather.NullWeatherFragment;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class Menu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        setView();
        setBottomBar();

    }


    private void setView() {

    }

    public void setFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frgMain,fragment)
                .addToBackStack(null)
                .commit();
    }

    private void setBottomBar() {
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
             TextView tv = (TextView) findViewById(R.id.toolbar_title);
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_oil) {

                    // Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_LONG).show();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new NullOilFragment());
                    transaction.commit();
                    tv.setText("ตรวจสอบราคาน้ำมัน");
                    tv.setTextColor(Color.parseColor("#228B22"));
                 //   tv.setBackgroundColor(Color.parseColor("#FFFFF0"));




                }else if (tabId == R.id.tab_lottery){
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new NullLotteryFragment());
                    transaction.commit();
                    tv.setText("ตรวจผลสลากกินแบ่งรัฐบาล");
                    tv.setTextColor(Color.parseColor("#B22222"));
                }else if(tabId == R.id.tab_weather){
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new NullWeatherFragment());
                    transaction.commit();
                    tv.setText("พยากรณ์อากาศ");
                    tv.setTextColor(Color.parseColor("#20B2AA"));
                }
            }


        });

    }










}




