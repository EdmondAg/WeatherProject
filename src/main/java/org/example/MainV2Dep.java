package org.example;


import org.example.v2.files.FileManager;
import org.example.v2.service.UriParameters;
import org.example.v2.service.WeatherRetrievalService;

import java.io.IOException;

@Deprecated
public class MainV2Dep {
    static UriParameters uriParameters = UriParameters.getInstance();
    final static String TEST_URL =  uriParameters.getTestURL();
    final static String OPEN_METEO_URI = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m";

    final static String WAPI2 = "https://api.stormglass.io/v2/weather/point" +
            "?lat=52.52" +
            "&lng=13.41" +
            "&params=airTemperature,airTemperature80m,airTemperature100m,pressure,currentSpeed,humidity,visibility" +
            "&Authorization=7bc5b61e-8629-11ed-bc36-0242ac130002-7bc5b6c8-8629-11ed-bc36-0242ac130002";


    public static void main(String[] args) throws IOException, InterruptedException {

        String data = WeatherRetrievalService.callHttp(WAPI2);
        FileManager.saveDataToFile(data, "5DaysTirane.txt");
        System.out.println(data);
    }
}