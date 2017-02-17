package com.weather.runner;

import com.weather.client.ServerMessage;
import com.weather.client.WeatherClient;
import com.weather.exceptions.NoServerFoundException;
import com.weather.utils.ReadWriteProperties;

import java.io.IOException;


public class WeatherClientRunner {

    public static void main(String[] args) throws IOException, NoServerFoundException {

        ServerMessage message = new ServerMessage("1234", "give me weather");
        WeatherClient serverClient = new WeatherClient(ReadWriteProperties.getServerPort());

        serverClient.sendGsonMessageToServer(message);
        serverClient.getGsonMessageFromServer();
    }

}
