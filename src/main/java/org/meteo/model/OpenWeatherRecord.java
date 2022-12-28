package org.meteo.model;

public record OpenWeatherRecord(String temperature2M, String time,
                                String relativeHumidity2M, String apparentTemperature,
                                String visibility, String windSpeed10M,
                                String soilMoisture1mm) {
}
