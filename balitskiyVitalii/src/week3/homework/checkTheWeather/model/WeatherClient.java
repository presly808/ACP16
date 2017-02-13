package week3.homework.checkTheWeather.model;

import week3.day1.SocketCreate;

import java.net.Socket;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherClient {

    private Socket socket;

    public void showWeather(Weather weather){
        System.out.println(weather);
    }
}
