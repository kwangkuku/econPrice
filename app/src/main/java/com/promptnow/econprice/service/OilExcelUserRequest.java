package com.promptnow.econprice.service;

/**
 * Created by Admin on 28/9/2559.
 */

public class OilExcelUserRequest {

    private String oilPump;
    private String oilType;
    private String oilPrice;

    public String getOilPump() {
        return oilPump;
    }

    public void setOilPump(String oilPump) {
        this.oilPump = oilPump;
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
}
