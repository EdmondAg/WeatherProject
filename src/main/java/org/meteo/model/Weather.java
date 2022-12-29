package org.meteo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Weather(String time, String temperature_2m,
                      String relativehumidity_2m, String visibility,
                      String windspeed_10m, String soil_moisture_0_1cm) {
}
