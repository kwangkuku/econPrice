package com.promptnow.econprice.service;

/**
 * Created by Admin on 28/9/2559.
 */

public class UserRequest {


//    String status;

    private String provinceNameTh;
    private String maxTemperature;
    private String windDirection;
    private String windSpeed;
    private String weatherDescription;
    private String tempartureLevel;



    public String getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(String windSpeed) {
        this.windSpeed = windSpeed;
    }


    public String getProvinceNameTh() {
        return provinceNameTh;
    }

    public void setProvinceNameTh(String provinceNameTh) {
        this.provinceNameTh = provinceNameTh;
    }

    public String getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(String maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getTempartureLevel() {
        return tempartureLevel;
    }

    public void setTempartureLevel(String tempartureLevel) {
        this.tempartureLevel = tempartureLevel;
    }


    //    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getStatus() {
//        return status;
//    }
}
