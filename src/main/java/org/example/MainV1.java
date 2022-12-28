package org.example;

import org.example.v1.weather.URL;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Deprecated
public class MainV1 {
    public static void main(String[] args) {

    HttpRequest request = HttpRequest.newBuilder()
        .uri(URI.create(URL.WEATHER.getUrl()))
        .build();

    HttpClient client = HttpClient.newHttpClient();
    client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
            .thenApply(HttpResponse::body)
            .thenAccept(System.out::println)
            .join();

    System.out.println("Done");

    }
}