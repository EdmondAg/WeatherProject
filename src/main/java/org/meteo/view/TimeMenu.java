package org.meteo.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;
import static org.meteo.view.Application.scanner;
import static org.meteo.view.Application.user;



public interface TimeMenu extends DailyWeather {
    Application application = Application.getInstance();

    default void getTimeInterval() throws IOException {
        System.out.println("(yyyy-mm-dd) Example: 2021-05-01");
        System.out.println("Actual time is "+ user.actualTime + ";" +
                " press enter to select actual time or enter your start date or write q to go back at main menu: ");


        String startDate = scanner.nextLine();
        startDate = verifyStartDate(startDate);

        System.out.println("Enter end date: ");
        String endDate = scanner.next();
        endDate = verifyEndDate(endDate, startDate);

        System.err.println(startDate + " -> " + endDate);
        confirmDate(startDate, endDate);
    }


    private void confirmDate(String startDate, String endDate) throws IOException {
        System.out.println("Start date: " + startDate + "; End date: " + endDate + " for city: " + user.actualCity);
        System.err.println("Confirm? (y/n) or press q to go back at main menu");
        String confirm = scanner.next();
        switch (confirm) {
            case "y" -> print(startDate, endDate);
            case "n" -> getTimeInterval();
            case "q" -> application.startApp();
            default -> {
                System.err.println("Wrong command!");
                confirmDate(startDate, endDate);
            }
        }

    }

    static void print(String startDate, String endDate) throws IOException {
        Map<LocalDateTime, String> map = user.withUserRequest(startDate, endDate);
        Printer.print(map);
    }

     default String verifyEndDate(String endDate, String startDate) throws IOException {

        if (endDate.equals("q")) {
            application.startApp();
        }

        verifyDateLimit(endDate);

        while (endDate.compareTo(startDate) < 0) {
            System.out.println("End date must be after start date!");
            System.out.println("Enter end date: ");
            endDate = scanner.next();
        }

        return endDate;
    }


    private String verifyStartDate(String startDate) throws IOException {

        if (startDate.equals("")){
            startDate = user.actualTime.toString();
        } else if (startDate.equals("q")){
            application.startApp();
        }

        verifyDateLimit(startDate);

        return startDate;
    }

    private void verifyDateLimit(String date) throws IOException {
        if (date.length() != 10 || date.charAt(4) != '-' || date.charAt(7) != '-'){
            System.out.println("Wrong date format!");
            getTimeInterval();
        } else if (date.compareTo("2022-10-00") < 0 || date.compareTo("2023-01-14") > 0){
            System.out.println("Date is not in the range!");
            getTimeInterval();
        }
    }

}
