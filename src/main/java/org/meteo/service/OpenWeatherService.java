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

    static private List<OpenWeatherRecord> dataList = new ArrayList<>();
    static private String dataString;

    public static void main(String[] args) throws IOException, InterruptedException {
        callList();
//        callString();
    }

    private static void callString() {
        try {
            dataString = HttpManager.getOpenWeatherString(URL1);
            System.out.println(dataString);
            FileManager.saveFile(dataString, "openWeatherData");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void callList() throws IOException, InterruptedException {
        dataList = HttpManager.getOpenWeatherList(URL1);
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
