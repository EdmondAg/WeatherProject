package org.example.v2.meteomatic;


import org.example.v2.files.FileManager;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MeteomaticsExample {
    public static void main(String[] args) throws Exception {
        String username = args[0];
        String password = args[1];
        System.out.print("username: " + username + ", password: " + password + "\n");
        URL url = new URL("https://api.meteomatics.com/2022-12-28T11:40:00.000+01:00--2022-12-31T11:40:00.000+01:00:PT2H/t_2m:C/51.5073219,-0.1276474/json?model=mix");
        String encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + encoding);

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }

        BufferedReader streamReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));

        StringBuilder responseStrBuilder = new StringBuilder();

        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }

        System.out.print(responseStrBuilder);
        FileManager.saveDataToFile(responseStrBuilder.toString(), "MeteomaticsExample.txt");
    }
}