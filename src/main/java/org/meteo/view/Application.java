package org.meteo.view;

import org.meteo.analyze.SentenceParser;

import java.io.IOException;
import java.util.Scanner;

public class Application extends SentenceParser implements CityMenu, TimeMenu, Printer {
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

            String userCommand = scanner.nextLine();
            parseSentence(userCommand);

            int command = 353430111;
            try {
                 command = Integer.parseInt(userCommand);
            }catch (NumberFormatException e) {
                System.out.println("Please enter a number");
            }

            switch (command){
                case 1 -> toCityMenu();
                case 2 -> getTodayWeather();
                case 3 -> get3DayWeather();
                case 4 -> getTimeInterval();
                case 0 -> exit = true;
                case 353430111 -> startApp();
            }
        }
        System.out.println("Thank you for using our app!");
    }

}
