package org.meteo.model;

public record WeatherRecord( String temperature, String date, String rain, String relativeHumidity,
                             String apparentTemperature) {

}
