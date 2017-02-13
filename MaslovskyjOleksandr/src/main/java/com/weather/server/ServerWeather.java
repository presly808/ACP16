package com.weather.server;


import com.google.gson.Gson;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWeather {

    final static Logger LOGGER = Logger.getLogger(ServerWeather.class);
    private final String WAIT_MESSAGE = "PLEASE WAIT UNTIL INFO LOADED";

    private String ipAddress;
    private int port;
    private ServerSocket connection;

    public ServerWeather(ServerSocket connection) throws IOException {
        this.connection = connection;
        ipAddress = connection.getInetAddress().toString();
        port = connection.getLocalPort();
    }

    public void listeningClientConnection(){
        LOGGER.info("NEW THREAD CREATED");
        new Thread(() -> {
            while (true){
                try {
                    Socket client = connection.accept();
                    sendToClientTempResponse(client);
                } catch (IOException e) {
                    LOGGER.error("CONNECTION REFUSED");
                    e.printStackTrace();
                }
            }
        }
        ).start();
    }

    private void sendToClientTempResponse(Socket client) throws IOException {
        Gson gson = new Gson();
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream()));
        LOGGER.info("SEND RESPONSE TO USER");
        bufferedWriter.write(gson.toJson(WAIT_MESSAGE));
        bufferedWriter.flush();
    }
}
