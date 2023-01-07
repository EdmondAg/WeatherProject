package org.meteo.view;

import java.io.IOException;
import java.util.Scanner;

public class Application implements CityMenu, TimeMenu, Printer{
    static final Scanner scanner = new Scanner(System.in);

    static final User user = User.getInstance();

    private static final Application application = new Application();

    private Application() {
    }

    public static Application getInstance() {
        return application;
    }

    public void startApp() throws IOException {
        boolean exit = false;
        while (!exit){
            showMenu();
            int userCommand = scanner.nextInt();
            switch (userCommand){
                case 1 -> toCityMenu();
                case 2 -> getTodayWeather();
                case 3 -> get3DayWeather();
                case 4 -> getTimeInterval();
                case 0 -> exit = true;
            }
        }
        System.out.println("Thank you for using our app!");
    }
}
