package org.meteo.view;

import org.meteo.enums.City;

import java.util.concurrent.atomic.AtomicInteger;

import static org.meteo.view.Application.scanner;
import static org.meteo.view.Application.user;


public interface CityMenu {
    default void toCityMenu() {
        AtomicInteger i = new AtomicInteger(1);
        City.getCities().forEach(city -> System.out.println(i.getAndIncrement() + ". " + city));

        System.out.println("Choose a city: ");
        int cityNumber = scanner.nextInt();

        if (cityNumber > 0 && cityNumber <= City.getCities().size()) {
            user.selectCity(City.getCities().get(cityNumber - 1));
            System.out.println("You have selected " + user.actualCity);
        } else {
            System.err.println("Wrong command!");
            toCityMenu();
        }
    }
}
