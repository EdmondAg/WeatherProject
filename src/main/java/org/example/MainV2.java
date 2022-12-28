package org.example;


import org.example.v2.files.FileManager;

public class MainV2 {
    public static void main(String[] args) {
//        String data = FileManager.readDataFromFileBytes("MeteomaticsExample.txt"); Not necessary to use this method.
        String data2 = FileManager.readFileSimple("MeteomaticsExample.txt"); // This method is better.

//        System.out.println(data);
        System.out.println(data2);

    }
}
