package org.meteo.http;

import lombok.*;

@Data
@Deprecated
public class UriParameters {
    String latitude;
    String longitude;
    String startTime; // Unix time -> SECONDS SINCE JAN 01 1970. (UTC)

    String endTime; // Unix time -> SECONDS SINCE JAN 01 1970. (UTC)

    String placeId;

    final String TEST_URL_4_DAYS = "https://api.meteomatics.com/2022-12-27T21:50:00.000+01:00--2023-01-31T21:50:00.000+01:00:PT1H/t_2m_min_1d_efi:idx/41.3654357,19.7547343_41.2955352,19.876438:1024x1024/json?model=mix";

    private UriParameters() {
    }

    public String getTestURL() {
        return TEST_URL_4_DAYS;
    }


    private static class UriParametersHolder {
        // Singleton thread safe class holder
        private static final UriParameters INSTANCE = new UriParameters();
    }

    public static UriParameters getInstance() {
        return UriParametersHolder.INSTANCE;
    }
}