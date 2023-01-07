package org.meteo.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum City {
    LONDON(Country.ENGLAND, "51.509865","-0.118092"),
    TIRANE(Country.ALBANIA,"41.327953","19.818698"),
    PARIS(Country.FRANCE,"48.856614","2.352222"),
    BERLIN(Country.GERMANY,"52.520008","13.404954"),
    ROME(Country.ITALY,"41.902782","12.496366"),
    MADRID(Country.SPAIN,"40.416775","-3.703790"),
    TOKYO(Country.JAPAN,"35.689487","139.691706"),
    BEIJING(Country.CHINA,"39.904200","116.407396"),
    MOSCOW(Country.RUSSIA,"55.755826","37.617300");

    private final Country COUNTRY;
    private final String LATITUDE;
    private final String LONGITUDE;

    City(Country COUNTRY, String LATITUDE, String LONGITUDE) {
        this.COUNTRY = COUNTRY;
        this.LATITUDE = LATITUDE;
        this.LONGITUDE = LONGITUDE;
    }

    public static City getCityByName(String cityName) {
        return Arrays.stream(City.values())
                .filter(city -> city.name().equalsIgnoreCase(cityName))
                .findFirst()
                .orElse(null);
    }

    public Country getCountry() {
        return COUNTRY;
    }

    public String getLatitude() {
        return LATITUDE;
    }

    public String getLongitude() {
        return LONGITUDE;
    }

    public String toString() {
        return name() + " (" + COUNTRY + ")";
    }

    public String getOnlyCity() {
        return name();
    }

    public static List<City> getCities() {
        //        Add only and only city name in the list and nothing more
        return new ArrayList<>(Arrays.asList(City.values()));
    }
}
