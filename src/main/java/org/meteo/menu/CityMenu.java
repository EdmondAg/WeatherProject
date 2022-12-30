package org.meteo.menu;

import org.meteo.enums.City;
import org.meteo.service.UriParametrization;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public interface CityMenu {
    Scanner scanner = new Scanner(System.in);

    static void goToCityMenu() {
        AtomicInteger i = new AtomicInteger(1);
        City.getCities().forEach(city -> System.out.println(i.getAndIncrement() + ". " + city));
        System.out.println("Choose a city: ");
        int cityNumber = scanner.nextInt();
        if (cityNumber > 0 && cityNumber <= City.getCities().size()) {
            Menu.actualCity = City.getCities().get(cityNumber - 1);
            System.out.println("You have selected " + Menu.actualCity);
            UriParametrization.selectCity(Menu.actualCity);
        } else {
            System.err.println("Wrong command!");
            goToCityMenu();
        }
    }
//    static String withCityFormatUri(City city) {
//        for (City c : City.values()) {
//            if (c.equals(city)){
//                Menu.actualCity = city;
//                UriParametrization.selectCity(city);
//            }
//        }
//        return null;
//    }
}
