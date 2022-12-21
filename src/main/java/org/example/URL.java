package org.example;

public enum URL {
    WEATHER("PUT-URL-WITH-API-KEY-HERE"),

    EXCHANGE("PUT-URL-WITH-API-KEY-HERE");


    private final String url;


    URL(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }
}
