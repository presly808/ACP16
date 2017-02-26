package com.weather.runner;


import com.weather.server.ServerWeather;

import java.io.IOException;


public class WeatherServerRunner {

    public static void main(String[] args) throws IOException {

        ServerWeather serverWeather = new ServerWeather();
        serverWeather.listeningClients();
    }
}
