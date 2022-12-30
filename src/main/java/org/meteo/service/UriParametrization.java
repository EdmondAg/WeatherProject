package org.meteo.service;

import org.meteo.enums.City;
import org.meteo.menu.Menu;

public class UriParametrization {
    static private String latitude = Menu.actualCity.getLatitude();
    static private String longitude = Menu.actualCity.getLongitude();

    static private String startTime = Menu.actualTime.toString();

    static private String endTime = Menu.actualTime.toString();


    static public void selectCity(City city){
        UriParametrization.latitude = city.getLatitude();
        UriParametrization.longitude = city.getLongitude();
    }

    public static void selectTime(String startTime, String endTime) {
        UriParametrization.startTime = startTime;
        UriParametrization.endTime = endTime;
    }

    public static String getOpenMeteoFormattedUri() {
        String openMeteoUri =   "https://api.open-meteo.com/v1/forecast?" +
                                "latitude=%s" +
                                "&longitude=%s" +
                                "&hourly=temperature_2m" +
                                "&start_date=%s" +
                                "&end_date=%s";

        return String.format(openMeteoUri, latitude, longitude, startTime, endTime);
    }

}
