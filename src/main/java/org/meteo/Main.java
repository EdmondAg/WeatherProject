package org.meteo;


import org.meteo.files.FileManager;
import org.meteo.http.MeteomaticsHttpCall;

public class Main {
    static MeteomaticsHttpCall meteomaticsHttpCall = new MeteomaticsHttpCall();

    static final String METEOMATICS_5_MIN_INTERVAL = "https://api.meteomatics.com/2022-12-28T16:20:00.000+01:00--2022-12-31T16:20:00.000+01:00:PT5M/t_mean_1000m_1h:C/51.5073219,-0.1276474/json?model=mix";

    public static void main(String[] args) throws Exception {
        System.out.println(readFromFile("MeteomaticsExample.txt"));
        System.out.println(readFromFile("Open_weather_API.txt"));

        meteomaticsHttpCall.callURL();
        System.out.println(meteomaticsHttpCall.getData());

        meteomaticsHttpCall.callURL(METEOMATICS_5_MIN_INTERVAL);
        System.out.println(meteomaticsHttpCall.getData());

    }

    private static String readFromFile(String fileName) {
        return FileManager.readFile(fileName);
    }


//     TODO: 1.Create a prototype method which will read the data from the file and fit the data into a class.


//     TODO: 2. Read documentation at the website and have a better understanding of query parameters.
//     TODO: 3. When 2 is done, create a method which will create a query based on the parameters.
}
