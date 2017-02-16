package com.weather.runner;


import com.weather.server.ServerWeather;
import com.weather.utils.ReadFromProperties;
import java.io.IOException;


public class WeatherServerRunner {

    public static void main(String[] args) throws IOException {

        int port = ReadFromProperties.getLocalPort();
        ServerWeather serverWeather = new ServerWeather(port);

        serverWeather.listeningClientConnection();

    }
}
