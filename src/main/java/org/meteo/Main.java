package org.meteo;

import org.meteo.service.dao.BaseDao;
import org.meteo.view.Application;

import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        BaseDao.getDbSession();
        Application application = Application.getInstance();
        application.startApp();
    }
}

