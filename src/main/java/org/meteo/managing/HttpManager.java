package org.meteo.managing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.meteo.model.Weather;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public interface HttpManager {
    ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    HttpClient CLIENT = HttpClient.newBuilder()
            .followRedirects(HttpClient.Redirect.ALWAYS)
            .build();

    static List<Weather> getOpenWeatherList(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return switch (response.statusCode()){
            case 200 -> toOpenWeatherRecord(response);
            case 404 -> List.of();
            default -> throw new RuntimeException("Fail" + response.statusCode());
        };
    }
    static String getOpenWeatherString(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return switch (response.statusCode()){
            case 200 -> response.body();
            case 404 -> "Error 404";
            default -> throw new RuntimeException("Fail" + response.statusCode());
        };
    }

    private static List<Weather> toOpenWeatherRecord(HttpResponse<String> response) throws JsonProcessingException {
        JavaType returnType = OBJECT_MAPPER.getTypeFactory()
                .constructCollectionType(List.class, Weather.class);
        return OBJECT_MAPPER.readValue(response.body(), returnType);
    }
}
