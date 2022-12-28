package org.meteo.managing;

import lombok.NonNull;
import org.meteo.model.OpenWeatherRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public interface FileManager {

    static void saveFile(@NonNull final List<OpenWeatherRecord> data, final String prefix) {
        try {
            FileWriter fileWriter = new FileWriter(NameManager.generateNameBasedOnDate(prefix));
            fileWriter.write(data.toString());
            fileWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    static void saveFile(@NonNull final String data, final String prefix) {
        try {
            FileWriter fileWriter = new FileWriter(NameManager.generateNameBasedOnDate(prefix));
            fileWriter.write(data);
            fileWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }


    static String readFile(@NonNull String fileName) {
        String data = null;

        try {
            File myObj = new File(fileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                data = myReader.nextLine();
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}
