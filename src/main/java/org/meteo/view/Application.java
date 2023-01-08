package org.meteo.view;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.meteo.analyze.SentenceParser;
import org.meteo.model.City;
import org.meteo.model.Weather;
import org.meteo.service.dao.BaseDao;
import org.meteo.service.dao.CityDao;
import org.meteo.service.dao.WeatherDao;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
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

    public void startApp() throws IOException, InterruptedException {
        boolean exit = false;
        while (!exit){
            showMenu();

//            String userCommand = scanner.nextLine();
//            parseSentence(userCommand);
//
//            int command = 353430111;
//            try {
//                 command = Integer.parseInt(userCommand);
//            }catch (NumberFormatException e) {
//                System.out.println("Please enter a number");
//            }

            int command = scanner.nextInt();

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


    static void saveToDb(Map<LocalDateTime, String> map) {
        WeatherDao weatherDao = new WeatherDao();
        CityDao cityDao = new CityDao();
        City city = new City();
        city.setCityName(user.city);
        city.setLatitude(user.getLatitude());
        city.setLongitude(user.getLongitude());

        cityDao.saveCity(city);

        Weather weather;


        for (Map.Entry<LocalDateTime, String> ldt : map.entrySet()) {
            weather = new Weather();

            weather.setDateTime(ldt.getKey());

            String temp = ldt.getValue();
            String numberOnly= temp.replace("°C","");

            double temperatureFormatted = Double.parseDouble(numberOnly);
            weather.setTemperature(temperatureFormatted);
            weather.setCityKey(city);

            weatherDao.saveWeather(weather);
        }
    }







    static SessionFactory dbSession = BaseDao.getDbSession();
    static Map<Integer, String> cities = new HashMap<>();
    public Map<City,Weather> getCityWeather() {
        Weather weather = new Weather();
        City city = new City();

        Session session = dbSession.openSession();
        session.beginTransaction();

        return null;

    }

    static {
    }
}
