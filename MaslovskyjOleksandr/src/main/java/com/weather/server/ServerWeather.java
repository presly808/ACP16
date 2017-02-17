package com.weather.server;


import com.google.gson.Gson;
import com.weather.utils.ReadWriteProperties;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerWeather {

    final static Logger LOGGER = Logger.getLogger(ServerWeather.class);
    private final String WAIT_MESSAGE = "PLEASE WAIT UNTIL INFO LOADED";

    private String ipAddress;
    private int port;
    private ServerSocket server;

    public ServerWeather() throws IOException {
        server = new ServerSocket(ReadWriteProperties.getServerPort());
        ipAddress = server.getInetAddress().toString();
        this.port = server.getLocalPort();
        //ReadWriteProperties.writePortIntoProperties(port);
    }

    public int getPort() {
        return port;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void listeningClients(){
        new Thread(() -> {
            LOGGER.info("NEW THREAD CREATED");
            while (true){
                try {
                    Socket client = server.accept();
                    sendToClientTempResponse(client);
                } catch (IOException e) {
                    LOGGER.error("CONNECTION REFUSED");
                    e.printStackTrace();
                    LOGGER.info("WAIT FOR CLIENT");
                }

            }
        }
        ).start();

    }

    private void sendToClientTempResponse(Socket client) throws IOException {
        Gson gson = new Gson();
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream()));
        bufferedWriter.write(gson.toJson(WAIT_MESSAGE) + "\n");
        LOGGER.info("SEND DEFAULT RESPONSE TO USER: " + gson.toJson(WAIT_MESSAGE));
        bufferedWriter.flush();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private InputStream sendRequestToWeatherServer() throws IOException {
        LOGGER.info("SEND REQUEST TO WEATHER SERVER");
        Socket socket = new Socket(ReadWriteProperties.getWeatherUrl(), ReadWriteProperties.getLocalPort());
        socket.getOutputStream();
        return socket.getInputStream();
    }

    private void getHTMLSource(){

    }

}
