package com.promptnow.econprice.fragment.oil.data_dummy;

import com.promptnow.econprice.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Acer on 19/9/2559.
 */

public class Dummy {

    private static Dummy getInstance;


    public static Dummy getInstance() {
        if (getInstance == null) {
            getInstance = new Dummy();
        }
        return getInstance;
    }


    //0 ---> Bensin         //1 ---> Sohol95            //2 ---> Sohol96
    //3 ---> E20            //4 ---> E85                //5 ---> Disel

    public List<String> ptt_day_10 = new ArrayList<>(Arrays.asList("31.44", "22.25", "23.26", "21.29", "17.83", "23.23"));
    public List<String> bangjak_day_10 = new ArrayList<>(Arrays.asList("32.25", "23.66", "23.99", "21.81", "17.18", "23.44"));
    public List<String> shell_day_10 = new ArrayList<>(Arrays.asList("23.26", "22.90", "23.60", "-", "17.44", "23.54"));
    public List<String> esso_day_10 = new ArrayList<>(Arrays.asList("21.29", "23.12", "24.11", "21.61", "-", "23.09"));

    public List<String> ptt_day_18 = new ArrayList<>(Arrays.asList("36.54", "29.99", "23.26", "21.29", "-", "23.23"));
    public List<String> bangjak_day_18 = new ArrayList<>(Arrays.asList("25.25", "34.11", "22.55", "21.23", "13.55", "23.94"));
    public List<String> shell_day_18 = new ArrayList<>(Arrays.asList("23.66", "24.56", "24.80", "22.22", "18.74", "22.44"));
    public List<String> esso_day_18 = new ArrayList<>(Arrays.asList("22.59", "23.62", "23.99", "20.63", "-", "-"));

    public List<String> ptt_day_27 = new ArrayList<>(Arrays.asList("-", "26.62", "24.38", "22.49", "-", "-"));
    public List<String> bangjak_day_27 = new ArrayList<>(Arrays.asList("23.15", "-", "22.33", "27.97", "18.65", "28.31"));
    public List<String> shell_day_27 = new ArrayList<>(Arrays.asList("29.22", "22.96", "23.62", "28.01", "-", "24.64"));
    public List<String> esso_day_27 = new ArrayList<>(Arrays.asList("26.34", "23.63", "-", "28.62", "-", "26.33"));


    public List<Integer> popup = new ArrayList<>(Arrays.asList(R.drawable.ic_ptt, R.drawable.ic_bangjak, R.drawable.ic_shell, R.drawable.ic_esso));


}
