package week3.homework.checkTheWeather.model;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherServer implements Runnable{

    private static Logger logger = Logger.getLogger(WeatherProvider.class);
    private ServerSocket serverSocket;
    private WeatherObserver clientsObserver;
    private WeatherProvider provider;

    public WeatherServer() throws IOException {
        serverSocket = new ServerSocket(8880);
        provider = new WeatherProvider();
        clientsObserver = new WeatherObserver();
    }

    @Override
    public void run() {
        while (true){
            try {
                Socket clientSocket = serverSocket.accept();
                logger.info("New client has connected" + clientSocket.getInetAddress());
                WeatherClient  client = new WeatherClient(clientSocket);
                clientsObserver.addClient(client);
                Weather weather = provider.currentWeather();
                clientsObserver.notifyAll(weather);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
