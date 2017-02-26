package com.weather.utils;


import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpService {

    private static final Logger LOGGER = Logger.getLogger(HttpService.class);

    public static String sendGetQuery(String url) throws IOException {
        URL url1 = new URL(url);
        LOGGER.info("SEND GET REQUEST");
        HttpURLConnection connection = (HttpURLConnection) url1.openConnection();
        connection.setRequestMethod("GET");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                connection.getInputStream()));
        return readResponse(bufferedReader);
    }

    private static String readResponse(BufferedReader bufferedReader) throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        LOGGER.info("READ RESPONSE FROM SERVER");
        while ((line = bufferedReader.readLine()) != null){
            result.append(line);
        }
        bufferedReader.close();
        return result.toString();
    }

}
