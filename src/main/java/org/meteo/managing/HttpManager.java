package org.meteo.managing;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.meteo.model.OpenWeatherRecord;

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

    static List<OpenWeatherRecord> callHttp(String uri) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        return switch (response.statusCode()){
            case 200 -> getWeatherRecords(response);
            case 404 -> List.of();
            default -> throw new RuntimeException("Fail" + response.statusCode());
        };
    }

    private static List<OpenWeatherRecord> getWeatherRecords(HttpResponse<String> response) throws JsonProcessingException {
        JavaType returnType = OBJECT_MAPPER.getTypeFactory()
                .constructCollectionType(List.class, OpenWeatherRecord.class);

        return OBJECT_MAPPER.readValue(response.body(), returnType);
    }

}
