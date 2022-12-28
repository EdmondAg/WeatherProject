package org.meteo.menu;

import org.meteo.enums.City;
import org.meteo.service.UriParametrization;

import java.util.Scanner;

public class AppMenu {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        boolean exit = false;
        while (!exit){
            showMenu();
            int userCommand = scanner.nextInt();
            switch (userCommand){
                case 1 -> displayTodayWeather();
                case 2 -> display3DaysWeather();
                case 3 -> goToCityMenu();
                case 0 -> exit = true;
            }
        }
        System.out.println("Bye");
    }

    private static void goToCityMenu() {
        City.getCities().forEach(System.err::println);
        System.out.println("Enter city name: ");
        String cityName = scanner.next();
        City city = City.getCityByName(cityName);
        if (city != null){
            System.out.println(city);
        } else {
            System.err.println("City not found!");
        }
        String formatUri = withCityFormatUri(city);
        if (formatUri == null){
            System.err.println("City not found!");
        }

    }

    private static void goBackToMainMenu(){
        while (true){
            System.out.println("Press 1 to go back to main menu");
            System.out.println("Press 0 to exit");

            int userCommand = scanner.nextInt();

            if (userCommand == 1){
                startApp();
            }
            if (userCommand == 0){
                System.out.println("Bye");
            }

            System.err.println("Wrong command!");
        }



    }

    private static String withCityFormatUri(City city) {
        System.out.println(getFormattedUri(city));
        return getFormattedUri(city);
    }

    private static String getFormattedUri(City city) {
        for (City c : City.values()) {
            if (c.equals(city)){
               return UriParametrization.formatUriWithCity(c.getLatitude(), c.getLongitude());
            }
        }
        return null;
    }

    private static void display3DaysWeather() {
        System.out.println("""
                Today: 25 C
                Tomorrow: 21 C
                After-tomorrow: 22 C
                """);
    }

    private static void displayTodayWeather() {
        System.out.println("Today: 25 C");
    }

    private static void showMenu() {
        System.out.println("""
                Please choose:
                \tPress 1 for showing today weather.
                \tPress 2 for seeing 3 coming days.
                \tPress 3 to show all cities.
                \t..
                \t..
                \t..
                \tPress 0 to exit.
                
                """);
    }
}
