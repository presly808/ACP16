package week3.homework.checkTheWeather.model;

import week3.day1.SocketCreate;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherServer implements Runnable{

    private ServerSocket serverSocket;

    public WeatherServer() throws IOException {
        serverSocket = new ServerSocket(8888);
    }

    public void startServer(){

    }

    @Override
    public void run() {
        while (true){
            try {
                Socket client = serverSocket.accept();



            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
