package com.weather.runner;

import com.weather.client.ServerClient;
import com.weather.client.ServerMessage;
import com.weather.exceptions.NoServerFoundException;
import com.weather.utils.ReadFromProperties;

import java.io.IOException;

/**
 * Created by ubuntu on 12.02.17.
 */
public class WeatherClientRunner {

    public static void main(String[] args) throws IOException, NoServerFoundException {
        String url = ReadFromProperties.getLocalYrl();
        int port = ReadFromProperties.getLocalPort();

        ServerMessage message = new ServerMessage("1234", "give me weather");
        ServerClient serverClient = new ServerClient(url, port);

        while (true){
            serverClient.sendGsonMessageToServer(message);
        }

    }

}
