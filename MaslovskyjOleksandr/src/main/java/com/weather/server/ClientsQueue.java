package com.weather.server;

import com.weather.client.ServerClient;
import org.apache.log4j.Logger;
import java.util.HashSet;
import java.util.Set;


public class ClientsQueue {

    final static Logger LOGGER = Logger.getLogger(ClientsQueue.class);

    private ServerClient client;
    private Set<ServerClient> clientList;

    public ClientsQueue(ServerClient client) {
        this.client = client;
        clientList = new HashSet<>();
    }

    public boolean addClientToQueue(ServerClient client){
        LOGGER.info("ADD CLIENT " + client.toString());
        return clientList.add(client);
    }

    public boolean removeClientFromQueue(ServerClient client){
        LOGGER.info("REMOVE CLIENT " + client.toString());
        return clientList.remove(client);
    }
}
