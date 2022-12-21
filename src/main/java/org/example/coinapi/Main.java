package org.example.coinapi;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.example.coinapi.URManager.FULL_URL;

public class Main {
    public static void main(String[] args) {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(FULL_URL)
                .addHeader("X-CoinAPI-Key", "73034021-THIS-IS-SAMPLE-KEYs")
                .build();

        try (Response response = client.newCall(request).execute()) {
            assert response.body() != null;
            System.out.println(response.body().string());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
