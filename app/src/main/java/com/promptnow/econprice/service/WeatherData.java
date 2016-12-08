package com.promptnow.econprice.service;

/**
 * Created by Admin on 9/11/2559.
 */

public class WeatherData {

    private static WeatherData instance;
    public static WeatherData getInstance(){
        if (instance == null) {
            instance = new WeatherData();
        }
        return instance;
    }

    WeatherModel weatherModel;

    public WeatherModel getWeatherModel() {
        return weatherModel;
    }

    public void setWeatherModel(WeatherModel weatherModel) {
        this.weatherModel = weatherModel;
    }
}
