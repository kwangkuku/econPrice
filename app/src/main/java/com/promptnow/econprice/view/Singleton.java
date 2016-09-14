package com.promptnow.econprice.view;

/**
 * Created by Admin on 9/9/2559.
 */

public class Singleton {

    //private ArrayList<Object> list;

    private static Singleton instance;
    private static String indexlist;

//    private Singleton(){list = new ArrayList<Object>();
//    }

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

    public String getIndexlist(){
        return indexlist;
    }
    public void setIndexlist(String indexlist){
        Singleton.indexlist = indexlist;
    }
}

