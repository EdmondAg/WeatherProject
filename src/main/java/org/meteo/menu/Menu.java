package org.meteo.menu;

import org.meteo.enums.City;
import org.meteo.service.UriParametrization;
import org.meteo.service.WeatherService;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

import static org.meteo.menu.CityMenu.goToCityMenu;
import static org.meteo.menu.TimeMenu.goToTimeMenu;

public class Menu {
    static final Scanner scanner = new Scanner(System.in);

    public static City actualCity = City.TIRANE;

    public static LocalDate actualTime = LocalDate.now();
    public static void startApp() throws IOException {
        boolean exit = false;
        while (!exit){
            showMenu();
            int userCommand = scanner.nextInt();
            switch (userCommand){
                case 1 -> goToCityMenu();
                case 2 -> displayTodayWeather();
                case 3 -> display3NextDaysWeather();
                case 4 -> goToTimeMenu();
                case 0 -> exit = true;
            }
        }
        System.out.println("Thank you for using our app!");
    }



    private static void showMenu() {
        System.out.println(actualCity + ", " + actualTime + " :");
        System.out.println("""
        -    \tPress 1 to change city.
        -    \tPress 2 for today weather.
        -    \tPress 3 for 3 incoming days.
        -    \tPress 4 for selecting a time interval.
        -    \tPress 0 to exit.
                """);
    }


    private static void display3NextDaysWeather() throws IOException {
        UriParametrization.selectTime(actualTime.toString(), actualTime.plusDays(3).toString());
        String openMeteoFormattedUri = UriParametrization.getOpenMeteoFormattedUri();
        System.out.println(openMeteoFormattedUri);
        WeatherService.useURI(openMeteoFormattedUri);
    }

    private static void displayTodayWeather() throws IOException {
        UriParametrization.selectTime(actualTime.toString(), actualTime.toString());
        String openMeteoFormattedUri = UriParametrization.getOpenMeteoFormattedUri();
        System.out.println(openMeteoFormattedUri);
        WeatherService.useURI(openMeteoFormattedUri);
    }



}
