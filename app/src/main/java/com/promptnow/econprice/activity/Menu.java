package com.promptnow.econprice.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.promptnow.econprice.R;
import com.promptnow.econprice.fragment.lottery.MainLotteryFragment;
import com.promptnow.econprice.fragment.oil.MainOilFragment;
import com.promptnow.econprice.fragment.weather.MainWeatherFragment;
import com.promptnow.econprice.view.Singleton;
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
Singleton.getInstance().setFirstOpenApp(true);
}

    public void setFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frgMain, fragment)
                .addToBackStack(null)
                .commit();
    }

    private void setBottomBar() {
        final BottomBar bottomBar = (BottomBar) findViewById(R.id.bottomBar);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            TextView tv = (TextView) findViewById(R.id.toolbar_title);
            ImageView img = (ImageView) findViewById(R.id.action);
            @Override
            public void onTabSelected(@IdRes int tabId) {

                if (tabId == R.id.tab_oil) {

                    // Toast.makeText(MainActivity.this,"tttt",Toast.LENGTH_LONG).show();
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainOilFragment());
                    transaction.commit();
                    tv.setText("ตรวจสอบราคาน้ำมัน");
                    tv.setTextColor(Color.parseColor("#228B22"));
                    img.setVisibility(View.INVISIBLE);


                } else if (tabId == R.id.tab_lottery) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainLotteryFragment());
                    transaction.commit();
                    tv.setText("ตรวจผลสลากกินแบ่งรัฐบาล");
                    tv.setTextColor(Color.parseColor("#B22222"));
                    img.setVisibility(View.INVISIBLE);
                } else if (tabId == R.id.tab_weather) {
                    FragmentManager manager = getSupportFragmentManager();
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.frgMain, new MainWeatherFragment());
                    transaction.commit();
                    tv.setText("พยากรณ์อากาศ");
                    tv.setTextColor(Color.parseColor("#20B2AA"));
                    img.setVisibility(View.INVISIBLE);
                }
            }


        });

    }


}




