package com.promptnow.econprice.view;

/**
 * Created by Admin on 9/9/2559.
 */

public class Singleton {

    //private ArrayList<Object> list;

    private static Singleton instance;
    private static String indexlist;
    private static Boolean firstOpenApp;
    private static String yourFormattedString = "";
    private static String yourFormattedString2 = "";
    private static String yourFormattedString3 = "";

//    private Singleton(){list = new ArrayList<Object>();
//    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public String getIndexlist() {
        return indexlist;
    }

    public void setIndexlist(String indexlist) {
        Singleton.indexlist = indexlist;
    }

<<<<<<< HEAD
//<<<<<<< HEAD
//
//=======
//    public  Boolean getFirstOpenApp() {
//        return firstOpenApp;
//    }
//
//    public  void setFirstOpenApp(Boolean firstOpenApp) {
//        Singleton.firstOpenApp = firstOpenApp;
//    }
//>>>>>>> origin/master
=======
    public Boolean getFirstOpenApp() {
        return firstOpenApp;
    }

    public void setFirstOpenApp(Boolean firstOpenApp) {
        Singleton.firstOpenApp = firstOpenApp;
    }

    public  String getYourFormattedString() {
        return yourFormattedString;
    }

    public  void setYourFormattedString(String yourFormattedString) {
        Singleton.yourFormattedString = yourFormattedString;
    }

    public  String getYourFormattedString2() {
        return yourFormattedString2;
    }

    public  void setYourFormattedString2(String yourFormattedString2) {
        Singleton.yourFormattedString2 = yourFormattedString2;
    }

    public String getYourFormattedString3() {
        return yourFormattedString3;
    }

    public  void setYourFormattedString3(String yourFormattedString3) {
        Singleton.yourFormattedString3 = yourFormattedString3;
    }
>>>>>>> origin/master
}

