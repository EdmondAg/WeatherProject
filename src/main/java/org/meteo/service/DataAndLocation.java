package org.meteo.service;

import org.meteo.enums.City;

import java.time.LocalDateTime;

public class DataAndLocation {
    private String latitude = City.TIRANE.getLatitude();
    private String longitude = City.TIRANE.getLongitude();

    private String startTime = LocalDateTime.now().toString();

    private String endTime = LocalDateTime.now().toString();

    public void selectCity(City city){
        this.latitude = city.getLatitude();
        this.longitude = city.getLongitude();
    }

    public void selectTime(String startTime, String endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getUrl() {
        String openMeteoUri =   "https://api.open-meteo.com/v1/forecast?" +
                                "latitude=%s" +
                                "&longitude=%s" +
                                "&hourly=temperature_2m" +
                                "&start_date=%s" +
                                "&end_date=%s";

        return String.format(openMeteoUri, latitude, longitude, startTime, endTime);
    }

}
