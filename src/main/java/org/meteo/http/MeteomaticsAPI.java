package org.meteo.http;


import org.meteo.files.FileManager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class MeteomaticsAPI {

    private String data;
    public void callURL() throws Exception {
        String[] credentials = getCredentials();
        URL url = getUrl();
        manageConnection(credentials, url);
    }

    public void callURL(final String URL_FROM_USER) throws Exception {
        final URL URL1 = new URL(URL_FROM_USER);
        String[] credentials = getCredentials();
        manageConnection(credentials, URL1);
    }

    private void manageConnection(String[] credentials, URL url) throws IOException {
        String encoding = getEncoding(credentials[0], credentials[1]);
        HttpURLConnection conn = getHttpURLConnection(url, encoding);
        verifyResponseStatus(conn);
        BufferedReader streamReader = new BufferedReader(new InputStreamReader((conn.getInputStream())));
        StringBuilder responseStrBuilder = new StringBuilder();
        printAndSaveResponse(streamReader, responseStrBuilder);
    }



    public void callMultipleURIs(String... varargs) throws Exception {
        for (String url : varargs) {
            manageConnection(getCredentials(), new URL(url));
        }
    }



    private void verifyResponseStatus(HttpURLConnection conn) throws IOException {
        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
        }
    }

    private void printAndSaveResponse(BufferedReader streamReader, StringBuilder responseStrBuilder) throws IOException {
        String inputStr;
        while ((inputStr = streamReader.readLine()) != null) {
            responseStrBuilder.append(inputStr);
        }

        data = responseStrBuilder.toString();
        FileManager.saveFile(responseStrBuilder.toString(), "Meteomatics");
    }

    public String getData() {
        if (data == null) {
            return "Data is empty!";
        }
        return data;
    }


    private String[] getCredentials() {
        final String USERNAME = "me_agalliu";
        final String PASSWORD = "W3g8TkL0hc";
        return new String[]{USERNAME, PASSWORD};
    }


    private HttpURLConnection getHttpURLConnection(URL url, String encoding) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        conn.setRequestProperty("Authorization", "Basic " + encoding);
        return conn;
    }

    private String getEncoding(String username, String password) {
        return Base64.getEncoder().encodeToString((username + ":" + password).getBytes(StandardCharsets.UTF_8));
    }

    private URL getUrl() throws MalformedURLException {
        return new URL("https://api.meteomatics.com/2022-12-28T11:40:00.000+01:00--2022-12-31T11:40:00.000+01:00:PT2H/t_2m:C/51.5073219,-0.1276474/json?model=mix");
    }
}