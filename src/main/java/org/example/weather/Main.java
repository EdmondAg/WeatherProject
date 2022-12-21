package org.example.weather;

import org.example.URL;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
    public static void main(String[] args) {

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL.WEATHER.getUrl()))
        .build();

        System.out.println(URL.EXCHANGE.getUrl());

        HttpClient client = HttpClient.newHttpClient();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();

        System.out.println("Done");
    }
}