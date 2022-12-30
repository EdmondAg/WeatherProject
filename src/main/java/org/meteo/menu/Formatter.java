package org.meteo.menu;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Formatter {

    public static void printTimeAndTemperature(Map<LocalDateTime, String> timeTemp) {
        Set<LocalDateTime> dates = timeTemp.keySet();
        List<String> datesList = dates.stream()
                .map(date -> date.getYear() + "." +
                        date.getDayOfMonth() + "." +
                        date.getMonthValue()).distinct().toList();

        for (String date : datesList) {
            System.out.println("Date: " + date);
            for (Map.Entry<LocalDateTime, String> entry : timeTemp.entrySet()) {
                if ((entry.getKey().getYear() + "." +
                        entry.getKey().getDayOfMonth() + "." +
                        entry.getKey().getMonthValue()).equals(date)) {
                    System.out.println("Time: " + entry.getKey().getHour() + ":00 & temperature: " + entry.getValue());
                }
            }
        }
    }
}
