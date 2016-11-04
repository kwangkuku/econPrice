package com.promptnow.econprice.service;

import java.util.List;

/**
 * Created by Admin on 27/10/2559.
 */

public class LotteryModel {

    List<LotteryUserRequest> lotteryData;

    public  List<LotteryUserRequest> getLotteryModel() {
        return lotteryData;
    }

    public void setLotteryModel( List<LotteryUserRequest> lotteryData) {
        this.lotteryData = lotteryData;
    }
}
