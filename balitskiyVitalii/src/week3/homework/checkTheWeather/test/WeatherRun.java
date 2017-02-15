package week3.homework.checkTheWeather.test;

import org.apache.log4j.Logger;
import week3.homework.checkTheWeather.model.WeatherClient;
import week3.homework.checkTheWeather.model.WeatherProvider;
import week3.homework.checkTheWeather.model.WeatherServer;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Socket;

/**
 * Created by Vitalii on 15.02.2017.
 */
public class WeatherRun {

    private static Logger logger = Logger.getLogger(WeatherRun.class);

    public static void main(String[] args) {
        try {
            WeatherServer server = new WeatherServer();
            WeatherClient client = new WeatherClient(new Socket("localhost", 8880));
            //WeatherClient client1 = new WeatherClient(new Socket("localhost", 8880));
            Thread serverThread = new Thread(server);
            Thread clientThread = new Thread(client);

            serverThread.start();
            Thread.sleep(3000);
            clientThread.start();

        } catch (IOException e) {
            logger.error(e.getMessage());
        } catch (InterruptedException e) {
            logger.warn(e.getMessage());
        }

    }
}
