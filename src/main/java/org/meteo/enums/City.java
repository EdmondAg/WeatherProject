package org.meteo.enums;

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

    private final String country;
    private final String latitude;
    private final String longitude;

    City(Country country, String latitude, String longitude) {
        this.country = String.valueOf(country);
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public String toString() {
        return name() + " (" + country + ")" + " (" + latitude + ")" + " (" + longitude + ")";
    }



}
