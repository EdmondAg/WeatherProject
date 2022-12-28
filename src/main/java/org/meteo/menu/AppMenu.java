package org.meteo.menu;

import java.util.Scanner;

public class AppMenu {
    static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        startApp();


    }

    private static void startApp() {
        boolean exit = false;
        while (!exit){
            showMenu();
            int userCommand = scanner.nextInt();
            switch (userCommand){
                case 1 -> showTodayWeather();
                case 2 -> show3DaysWeather();
                case 3 -> exit = true;
            }
        }
        System.out.println("Bye");
    }

    private static void show3DaysWeather() {
        System.out.println("""
                Today: 25 C
                Tomorrow: 21 C
                After-tomorrow: 22 C
                """);
    }

    private static void showTodayWeather() {
        System.out.println("Today: 25 C");
    }

    private static void showMenu() {
        System.out.println("""
                Please choose:
                \tPress 1 for showing today weather.
                \tPress 2 for seeing 3 coming days.
                \tETC....
                \t..
                \t..
                \t..
                \tPress 3 to exit.
                
                """);
    }
}
