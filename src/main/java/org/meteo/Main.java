package org.meteo;

import org.meteo.view.Application;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {
        Application application = Application.getInstance();
        application.startApp();
    }
}

