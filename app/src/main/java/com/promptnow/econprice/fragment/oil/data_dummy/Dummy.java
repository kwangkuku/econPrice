package com.promptnow.econprice.fragment.oil.data_dummy;

import com.promptnow.econprice.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Acer on 19/9/2559.
 */

public class Dummy {

    public static Dummy newInstance(){
        return new Dummy();
    }
    //0 ---> Bensin         //1 ---> Sohol95            //2 ---> Sohol96
    //3 ---> E20            //4 ---> E85                //5 ---> Disel

    public List<String> ptt = new ArrayList<>(Arrays.asList("31.44","22.25","23.26","21.29","17.83","23.23"));
    public List<String> bangjak = new ArrayList<>(Arrays.asList("22.25","-","-","21.81","17.18","23.44"));
    public List<String> shell = new ArrayList<>(Arrays.asList("23.26","22.90","23.60","-","17.44","23.54"));
    public List<String> esso = new ArrayList<>(Arrays.asList("21.29","23.12","24.11","21.61","-","23.09"));


    public List<Integer> popup = new ArrayList<>(Arrays.asList( R.drawable.ic_ptt, R.drawable.ic_bangjak, R.drawable.ic_shell, R.drawable.ic_esso));



}
