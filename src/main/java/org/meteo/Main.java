package org.meteo;


import org.meteo.files.FileManager;

public class Main {
    public static void main(String[] args) {
//        String data = FileManager.readDataFromFileBytes("MeteomaticsExample.txt"); Not necessary to use this method.
        String data2 = FileManager.readFileSimple("MeteomaticsExample.txt"); // This method is better.

//        System.out.println(data);
        System.out.println(data2);

    }
//     TODO: 1.Create a prototype method which will read the data from the file and fit the data into a class.
//     TODO: 2. Read documentation at the website and have a better understanding of query parameters.
//     TODO: 3. When 2 is done, create a method which will create a query based on the parameters.
}
