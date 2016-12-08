package com.promptnow.econprice.service;

import java.util.List;

/**
 * Created by Acer on 31/10/2559.
 */

public class OilExcelModel {
   List<OilExcelUserRequest> oilExcelData;

    public List<OilExcelUserRequest> getOilExcelModel() {

        return oilExcelData;
    }

    public void setOilExcelModel(List<OilExcelUserRequest>oilExcelData) {
        this.oilExcelData = oilExcelData;
    }
}
