package org.meteo.service;

import org.meteo.json.JsonParser;
import org.meteo.managing.FileManager;
import org.meteo.managing.HttpManager;
import org.meteo.menu.Formatter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public class WeatherService {
    //    URL1 -> 2022-06-08 - 2023-01-12  -> ~6 months hourly with parameters:
    // "hourly": {
    //"time": [], 5256 items
    //"temperature_2m": [], 5256 items
    //"relativehumidity_2m": [], 5256 items
    //"visibility": [], 5256 items
    //"windspeed_10m": [], 5256 items
    //"soil_moisture_0_1cm": [] 5256 items

    static private String dataString;

    public static void useURI(final String URI) throws IOException {
        String date = withUri(URI);
        Map<LocalDateTime, String> map = JsonParser.mapData(date);
        Formatter.printTimeAndTemperature(map);
    }

    private static String withUri(String URI) {
        try {
            dataString = HttpManager.getOpenWeatherString(URI);
            FileManager.saveFile(dataString, "openWeatherData");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return dataString;
    }
}
