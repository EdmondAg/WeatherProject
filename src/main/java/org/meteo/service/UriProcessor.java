package org.meteo.service;

import org.meteo.service.json.JsonParser;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

public interface UriProcessor extends JsonParser {

    default Map<LocalDateTime, String> useURI(final String URI) throws IOException {
        String date = withUri(URI);
        return mapData(date);
    }

    private static String withUri(String URI) {
        String dataString = null;
        try {
            dataString = HttpCaller.getResponse(URI);
//            FileManager.saveFile(dataString, "openWeatherData");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return dataString;
    }
}
