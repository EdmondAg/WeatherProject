package org.meteo.view;

import java.io.IOException;
import java.util.Scanner;

import static org.meteo.view.Application.user;

public interface CityMenu {
    Scanner scanner = new Scanner(System.in);
    default void toCityMenu() throws IOException, InterruptedException {
        System.out.println("Enter the city name: ");
        String city = scanner.nextLine();
        user.selectCity(city);
        System.out.println("You have selected " + city);
    }
}
