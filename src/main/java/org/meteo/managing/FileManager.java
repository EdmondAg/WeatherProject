package org.meteo.managing;

import org.meteo.model.OpenWeatherRecord;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.List;
import java.util.Scanner;

public interface FileManager {

    static void saveFile(List<OpenWeatherRecord> data, String prefix) {
        try {
            FileWriter fileWriter = new FileWriter(NameManager.generateNameBasedOnDate(prefix));
            fileWriter.write(data.toString());
            fileWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }

    static void saveFile(String data) {
        try {
            FileWriter fileWriter = new FileWriter(NameManager.generateNameBasedOnDate());
            fileWriter.write(data);
            fileWriter.close();
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    static String readFile(String fileName) {
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