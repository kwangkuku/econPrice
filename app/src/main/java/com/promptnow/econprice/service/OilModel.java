package com.promptnow.econprice.service;

import java.util.List;

/**
 * Created by Acer on 31/10/2559.
 */

public class OilModel {
   List<OilUserRequest> oilData;

    public List<OilUserRequest> getOilModel() {

        return oilData;
    }

    public void setOilModel(List<OilUserRequest>oilData) {
        this.oilData = oilData;
    }
}
