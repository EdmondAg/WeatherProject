package org.meteo.service;

import org.meteo.managing.FileManager;
import org.meteo.managing.HttpManager;
import org.meteo.model.OpenWeatherRecord;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OpenWeatherService {
    static final String URL1 = "https://api.open-meteo.com/v1/forecast?latitude=41.33&longitude=19.78&hourly=temperature_2m,relativehumidity_2m,visibility,windspeed_10m,soil_moisture_0_1cm&models=best_match&start_date=2022-06-08&end_date=2023-01-12";
//    URL1 -> 2022-06-08 - 2023-01-12  -> ~6 months hourly with parameters:
                                                                        // "hourly": {
                                                                        //"time": [], 5256 items
                                                                        //"temperature_2m": [], 5256 items
                                                                        //"relativehumidity_2m": [], 5256 items
                                                                        //"visibility": [], 5256 items
                                                                        //"windspeed_10m": [], 5256 items
                                                                        //"soil_moisture_0_1cm": [] 5256 items

    public static final String URL2 = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&hourly=temperature_2m&start_date=2022-12-29&end_date=2022-12-31";
    static private List<OpenWeatherRecord> dataList = new ArrayList<>();
    static private String dataString;

    public static void main(String[] args) throws IOException, InterruptedException {
//        callList(URL2);
//        callString(URL1);
    }

    public static String callString(String URI) {
        try {
            dataString = HttpManager.getOpenWeatherString(URI);
//            System.out.println(dataString);
            FileManager.saveFile(dataString, "openWeatherData");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return dataString;
    }

    public static void callList(String URI) throws IOException, InterruptedException {
        dataList = HttpManager.getOpenWeatherList(URI);
        getOpenWeatherList();
        FileManager.saveFile(dataList, "Open_weather.txt");
    }

    public static List<OpenWeatherRecord> getOpenWeatherList(){
        System.out.println(dataList.size());
        dataList.forEach(System.out::println);
        return dataList;
    }

    public static String getOpenWeatherString(){
        return dataString;
    }
}
