package com.promptnow.econprice.service;

import java.util.List;



public class LotteryModel {

    List<LotteryRequest> lotteryData;

    public  List<LotteryRequest> getLotteryModel() {
        return lotteryData;
    }

    public void setLotteryModel( List<LotteryRequest> lotteryData) {
        this.lotteryData = lotteryData;
    }
}
