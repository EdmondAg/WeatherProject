package org.meteo.managing;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

public interface NameManager {
    LocalDate date = LocalDate.now();
    Calendar calendar = Calendar.getInstance();

    static String generateNameBasedOnDate() {
        return String.format(Locale.ROOT,
                "%d_%d_%d_%s.txt", date.getDayOfMonth(), date.getMonthValue(),
                date.getYear(), getRandomChars());
    }

    static String generateNameBasedOnDate(String prefix) {
        return String.format(Locale.ROOT,
                "%S_%d_%d_%d_%s.txt",prefix, date.getDayOfMonth(), date.getMonthValue(),
                date.getYear(),getRandomChars());
    }

    static int getNanoSeconds() {
        return calendar.getTime().toInstant().getNano();
    }

    static String getRandomChars() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 13; i++) {
            int index = (int) (chars.length() * Math.random());
            sb.append(chars.charAt(index));
        }
        return sb.toString();
    }
}
