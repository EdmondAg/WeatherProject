package org.meteo.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.meteo.view.Application.user;

public interface Printer {
    default void printTimeAndTemperature(Map<LocalDateTime, String> timeTemp) {
        List<String> datesList = mapDate(timeTemp);

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

    default void printTimeAndTemperature(String startDate, String endDate) throws IOException {
        Map<LocalDateTime, String> map = user.withUserRequest(startDate, endDate);
        printTimeAndTemperature(map);
    }


    private static List<String> mapDate(Map<LocalDateTime, String> timeTemp) {
        Set<LocalDateTime> dates = timeTemp.keySet();
        return dates.stream()
                .map(date -> date.getYear() + "." +
                        date.getDayOfMonth() + "." +
                        date.getMonthValue()).distinct().toList();
    }




     default void showMenu() {
        System.out.println(user.city + ", " + user.actualTime + " :");
        System.out.println("""
        -    \tPress 1 to change city.
        -    \tPress 2 for today weather.
        -    \tPress 3 for 3 incoming days.
        -    \tPress 4 for selecting a time interval.
        -    \tPress 0 to exit.
                """);
    }
}
