package org.meteo.service.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.meteo.utils.TimeFormatter;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public interface JsonParser extends TimeFormatter {
    ObjectMapper objectMapper = getObjectMapper();

    static ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    private static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }


    default Map<LocalDateTime,String> mapData(String data) throws JsonProcessingException {
        JsonNode jsonNode = JsonParser.parse(data);
        Map<LocalDateTime,String> timeTemp = new LinkedHashMap<>();

        for ( int i = 0; i < jsonNode.get("hourly").get("time").size(); i++) {
            String fullDate = jsonNode.get("hourly").get("time").get(i).asText();
            LocalDateTime formattedTime = formatTime(LocalDateTime.parse(fullDate));
            double temp = jsonNode.get("hourly").get("temperature_2m").get(i).asDouble();
            timeTemp.put(formattedTime, temp + " °C");
        }
        return timeTemp;
    }

    default Map<String,List<String>> mapCities(String data) throws JsonProcessingException {
        JsonNode jsonNode = JsonParser.parse(data);
//        [{"name": "Paris", "latitude": 48.8566, "longitude": 2.3522,
//        "country": "FR", "population": 11020000, "is_capital": true}]
        Map<String,List<String>> cities = new LinkedHashMap<>();

        String name = jsonNode.get(0).get("name").asText();
        String latitude = jsonNode.get(0).get("latitude").asText();
        String longitude = jsonNode.get(0).get("longitude").asText();

        cities.put(name, List.of(latitude, longitude));

        return cities;
    }
}
