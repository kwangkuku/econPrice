package com.promptnow.econprice.service;

/**
 * Created by Admin on 28/9/2559.
 */

public class OilUserRequest {

    private String pumpName;
    private String oilType;
    private String oilPrice;

    public String getPumpName() {
        return pumpName;
    }

    public void setPumpName(String pumpName) {
        this.pumpName = pumpName;
    }

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getOilPrice() {
        return oilPrice;
    }

    public void setOilPrice(String oilPrice) {
        this.oilPrice = oilPrice;
    }

    //    private String bensin_PTT ;
//    private String gasohol95_PTT;
//    private String gasohol91_PTT;
//    private String e20_PTT;
//    private String e85_PTT;
//    private String diesel_PTT;
//
//    private String bensin_Bangchak;
//    private String gasohol95_Bangchak;
//    private String gasohol91_Bangchak;
//    private String e20_Bangchak;
//    private String e85_Bangchak;
//    private String diesel_Bangchak;
//
//
//    private String bensin_Shell;
//    private String gasohol95_Shell;
//    private String gasohol91_Shell;
//    private String e20_Shell;
//    private String e85_Shell;
//    private String diesel_Shell;
//
//    private String bensin_Esso;
//    private String gasohol95_Esso;
//    private String gasohol91_Esso;
//    private String e20_Esso;
//    private String e85_Esso;
//    private String diesel_Esso;
//
//
//    public String getBensin_PTT() {
//        return bensin_PTT;
//    }
//
//    public void setBensin_PTT(String bensin_PTT) {
//        this.bensin_PTT = bensin_PTT;
//    }
//
//    public String getGasohol95_PTT() {
//        return gasohol95_PTT;
//    }
//
//    public void setGasohol95_PTT(String gasohol95_PTT) {
//        this.gasohol95_PTT = gasohol95_PTT;
//    }
//
//    public String getGasohol91_PTT() {
//        return gasohol91_PTT;
//    }
//
//    public void setGasohol91_PTT(String gasohol91_PTT) {
//        this.gasohol91_PTT = gasohol91_PTT;
//    }
//
//    public String getE20_PTT() {
//        return e20_PTT;
//    }
//
//    public void setE20_PTT(String e20_PTT) {
//        this.e20_PTT = e20_PTT;
//    }
//
//    public String getE85_PTT() {
//        return e85_PTT;
//    }
//
//    public void setE85_PTT(String e85_PTT) {
//        this.e85_PTT = e85_PTT;
//    }
//
//    public String getDiesel_PTT() {
//        return diesel_PTT;
//    }
//
//    public void setDiesel_PTT(String diesel_PTT) {
//        this.diesel_PTT = diesel_PTT;
//    }
//
//    public String getBensin_Bangchak() {
//        return bensin_Bangchak;
//    }
//
//    public void setBensin_Bangchak(String bensin_Bangchak) {
//        this.bensin_Bangchak = bensin_Bangchak;
//    }
//
//    public String getGasohol95_Bangchak() {
//        return gasohol95_Bangchak;
//    }
//
//    public void setGasohol95_Bangchak(String gasohol95_Bangchak) {
//        this.gasohol95_Bangchak = gasohol95_Bangchak;
//    }
//
//    public String getGasohol91_Bangchak() {
//        return gasohol91_Bangchak;
//    }
//
//    public void setGasohol91_Bangchak(String gasohol91_Bangchak) {
//        this.gasohol91_Bangchak = gasohol91_Bangchak;
//    }
//
//    public String getE20_Bangchak() {
//        return e20_Bangchak;
//    }
//
//    public void setE20_Bangchak(String e20_Bangchak) {
//        this.e20_Bangchak = e20_Bangchak;
//    }
//
//    public String getE85_Bangchak() {
//        return e85_Bangchak;
//    }
//
//    public void setE85_Bangchak(String e85_Bangchak) {
//        this.e85_Bangchak = e85_Bangchak;
//    }
//
//    public String getBensin_Shell() {
//        return bensin_Shell;
//    }
//
//    public void setBensin_Shell(String bensin_Shell) {
//        this.bensin_Shell = bensin_Shell;
//    }
//
//    public String getGasohol95_Shell() {
//        return gasohol95_Shell;
//    }
//
//    public void setGasohol95_Shell(String gasohol95_Shell) {
//        this.gasohol95_Shell = gasohol95_Shell;
//    }
//
//    public String getDiesel_Bangchak() {
//        return diesel_Bangchak;
//    }
//
//    public void setDiesel_Bangchak(String diesel_Bangchak) {
//        this.diesel_Bangchak = diesel_Bangchak;
//    }
//
//    public String getGasohol91_Shell() {
//        return gasohol91_Shell;
//    }
//
//    public void setGasohol91_Shell(String gasohol91_Shell) {
//        this.gasohol91_Shell = gasohol91_Shell;
//    }
//
//    public String getE20_Shell() {
//        return e20_Shell;
//    }
//
//    public void setE20_Shell(String e20_Shell) {
//        this.e20_Shell = e20_Shell;
//    }
//
//    public String getE85_Shell() {
//        return e85_Shell;
//    }
//
//    public void setE85_Shell(String e85_Shell) {
//        this.e85_Shell = e85_Shell;
//    }
//
//    public String getDiesel_Shell() {
//        return diesel_Shell;
//    }
//
//    public void setDiesel_Shell(String diesel_Shell) {
//        this.diesel_Shell = diesel_Shell;
//    }
//
//    public String getBensin_Esso() {
//        return bensin_Esso;
//    }
//
//    public void setBensin_Esso(String bensin_Esso) {
//        this.bensin_Esso = bensin_Esso;
//    }
//
//    public String getGasohol95_Esso() {
//        return gasohol95_Esso;
//    }
//
//    public void setGasohol95_Esso(String gasohol95_Esso) {
//        this.gasohol95_Esso = gasohol95_Esso;
//    }
//
//    public String getGasohol91_Esso() {
//        return gasohol91_Esso;
//    }
//
//    public void setGasohol91_Esso(String gasohol91_Esso) {
//        this.gasohol91_Esso = gasohol91_Esso;
//    }
//
//    public String getE20_Esso() {
//        return e20_Esso;
//    }
//
//    public void setE20_Esso(String e20_Esso) {
//        this.e20_Esso = e20_Esso;
//    }
//
//    public String getE85_Esso() {
//        return e85_Esso;
//    }
//
//    public void setE85_Esso(String e85_Esso) {
//        this.e85_Esso = e85_Esso;
//    }
//
//    public String getDiesel_Esso() {
//        return diesel_Esso;
//    }
//
//    public void setDiesel_Esso(String diesel_Esso) {
//        this.diesel_Esso = diesel_Esso;
//    }
}
