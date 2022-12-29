package org.meteo;

import com.fasterxml.jackson.core.JsonProcessingException;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.Set;

import static org.meteo.json.JsonParser.parseJson;
import static org.meteo.service.OpenWeatherService.URL2;
import static org.meteo.service.OpenWeatherService.callString;

public class Main {
//    {"latitude":52.52,"longitude":13.419998,
//    "generationtime_ms":0.2300739288330078,
//    "utc_offset_seconds":0,"timezone":"GMT",
//    "timezone_abbreviation":"GMT","elevation":38.0,
//    "hourly_units":{"time":"iso8601","temperature_2m":"°C"},
//    "hourly":{"time":["2022-12-29T00:00","2022-12-29T01:00",
//    "2022-12-29T02:00","2022-12-29T03:00","2022-12-29T04:00",
//    "2022-12-29T05:00","2022-12-29T06:00","2022-12-29T07:00",
//    "2022-12-29T08:00","2022-12-29T09:00","2022-12-29T10:00",
//    "2022-12-29T11:00","2022-12-29T12:00","2022-12-29T13:00",
//    "2022-12-29T14:00","2022-12-29T15:00","2022-12-29T16:00",
//    "2022-12-29T17:00","2022-12-29T18:00","2022-12-29T19:00",
//    "2022-12-29T20:00","2022-12-29T21:00","2022-12-29T22:00",
//    "2022-12-29T23:00"],
//    "temperature_2m":[7.8,7.9,7.9,8.4,8.4,8.5,9.0,9.4,9.5,9.8,10.5,11.1,11.2,11.3,11.3,10.9,10.4,9.9,9.6,9.1,8.6,8.5,8.1,7.9]}}
    public static void main(String[] args) throws JsonProcessingException {
        String data = callString(URL2);
        Map<LocalDateTime,String> timeTemp = parseJson(data);

//        Print the day and the month only once

        Set<LocalDateTime> dates = timeTemp.keySet();
        dates.stream().map(date ->date.getYear() + "." + date.getDayOfMonth() + "." + date.getMonthValue()).distinct().forEach(System.out::println);

        timeTemp.forEach((k,v) -> System.out.println(k.getHour() + k.getMinute() + " & temperature: " + v));
    }
}

