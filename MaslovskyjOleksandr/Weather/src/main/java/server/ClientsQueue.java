package server;

import client.WeatherClient;
import org.apache.log4j.Logger;
import java.util.HashSet;
import java.util.Set;


public class ClientsQueue {

    final static Logger LOGGER = Logger.getLogger(ClientsQueue.class);

    private WeatherClient client;
    private Set<WeatherClient> clientList;

    public ClientsQueue(WeatherClient client) {
        this.client = client;
        clientList = new HashSet<>();
    }

    public boolean addClientToQueue(WeatherClient client){
        LOGGER.info("ADD CLIENT " + client.toString());
        return clientList.add(client);
    }

    public boolean removeClientFromQueue(WeatherClient client){
        LOGGER.info("REMOVE CLIENT " + client.toString());
        return clientList.remove(client);
    }
}
