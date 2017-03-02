package runner;

import client.ServerMessage;
import client.WeatherClient;
import exceptions.NoServerFoundException;
import utils.ReadWriteProperties;


import java.io.IOException;


public class WeatherClientRunner {

    public static void main(String[] args) throws IOException, NoServerFoundException {

        ServerMessage message = new ServerMessage("1234", "give me weather");
        String cityName = "London";
        WeatherClient serverClient = new WeatherClient(ReadWriteProperties.getServerPort());

        serverClient.sendGsonMessageToServer(cityName);
        serverClient.getGsonMessageFromServer();
    }

}
