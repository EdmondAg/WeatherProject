package org.meteo.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class JsonParser {
    static ObjectMapper objectMapper = getObjectMapper();

    public static ObjectMapper getObjectMapper() {
        return new ObjectMapper();
    }

    private static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }


    public static Map<LocalDateTime,String> mapData(String data) throws JsonProcessingException {
        JsonNode jsonNode = JsonParser.parse(data);
        Map<LocalDateTime,String> timeTemp = new LinkedHashMap<>();

        for ( int i = 0; i < jsonNode.get("hourly").get("time").size(); i++) {
            String fullDate = jsonNode.get("hourly").get("time").get(i).asText();
//          "2022-12-30T00:00",
            LocalDateTime formattedTime = formatTime(LocalDateTime.parse(fullDate));

            double temp = jsonNode.get("hourly").get("temperature_2m").get(i).asDouble();
            timeTemp.put(formattedTime, temp + " °C");
        }
        return timeTemp;
    }

    public static LocalDateTime formatTime(LocalDateTime fullDate) {
        return LocalDateTime.of(fullDate.getYear(), fullDate.getMonth(), fullDate.getDayOfMonth(),
                fullDate.getHour(), 0);
    }

}
