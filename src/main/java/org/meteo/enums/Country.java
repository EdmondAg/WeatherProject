package org.meteo.enums;

@Deprecated
public enum Country {
    ALBANIA("Albania", "AL"),
    FRANCE("France", "FR"),
    GERMANY("Germany", "DE"),
    ITALY("Italy", "IT"),
    JAPAN("Japan", "JP"),
    RUSSIA("Russia", "RU"),
    SPAIN("Spain", "ES"),
    CHINA("China", "CN"),
    ENGLAND("England", "GB");

    private final String country;
    private final String countryCode;

    Country(String country, String countryCode) {
        this.country = country;
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String toString() {
        return name();
    }
}
