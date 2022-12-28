package org.meteo.model;

public class WeatherEntity {
    String temperature;
    String date;
    String rain;
    String relativehumidity_2m;
    String apparent_temperature;

    public WeatherEntity(){
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getRain() {
        return rain;
    }

    public void setRain(String rain) {
        this.rain = rain;
    }

    public String getRelativehumidity_2m() {
        return relativehumidity_2m;
    }

    public void setRelativehumidity_2m(String relativehumidity_2m) {
        this.relativehumidity_2m = relativehumidity_2m;
    }

    public String getApparent_temperature() {
        return apparent_temperature;
    }

    public void setApparent_temperature(String apparent_temperature) {
        this.apparent_temperature = apparent_temperature;
    }
}
