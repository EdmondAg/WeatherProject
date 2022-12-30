package org.meteo.menu;

import org.meteo.service.UriParametrization;
import org.meteo.service.WeatherService;

import java.io.IOException;
import java.util.Scanner;

import static org.meteo.menu.Menu.actualTime;
import static org.meteo.service.UriParametrization.getOpenMeteoFormattedUri;

public interface TimeMenu {
    static final Scanner scanner = new Scanner(System.in);

    static void goToTimeMenu() throws IOException {
        System.out.println("(yyyy-mm-dd) Example: 2021-05-01");
        System.out.println("Actual time is "+ actualTime + ";" +
                " press enter to select actual time or enter your start date or write q to go back at main menu: ");
//        Make possible to select actual time by pressing enter key
        String startDate = scanner.nextLine();

        if (startDate.isEmpty()){
            startDate = actualTime.toString();
        }else if (startDate.equals("q")){
            Menu.startApp();
        }

        System.out.println("Start time is: " + startDate + "; select the end date: ");
        String endDate = scanner.next();
        System.err.println(startDate + " -> " + endDate);

        confirmDate(startDate, endDate);

        final String URI = getOpenMeteoFormattedUri();

        WeatherService.useURI(URI);
    }

    private static void confirmDate(String startDate, String endDate) throws IOException {
        System.out.println("Start date: " + startDate + "; End date: " + endDate + " for city: " + Menu.actualCity);
        System.err.println("Confirm? (y/n) or press q to go back at main menu");
        String confirm = scanner.next();
        switch (confirm) {
            case "y" -> UriParametrization.selectTime(startDate, endDate);
            case "n" -> goToTimeMenu();
            case "q" -> Menu.startApp();
            default -> {
                System.err.println("Wrong command!");
                confirmDate(startDate, endDate);
            }
        }

    }
}
