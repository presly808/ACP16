package com.weather.client;


import com.google.gson.Gson;
import com.weather.controllers.ClientActions;
import com.weather.exceptions.NoServerFoundException;
import com.weather.utils.ReadWriteProperties;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;

public class WeatherClient implements ClientActions{

    final static Logger LOGGER = Logger.getLogger(WeatherClient.class);

    private String ipAddress;
    private int port;
    private Socket connection;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;

    public WeatherClient(int port) throws IOException {
        this.connection = new Socket(ReadWriteProperties.getLocalYrl(), port);
        this.ipAddress = connection.getInetAddress().toString();
        this.port = connection.getPort();
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        this.bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(connection.getOutputStream()));
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }

    public Socket getConnection() {
        return connection;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeatherClient that = (WeatherClient) o;

        return ipAddress.equals(that.ipAddress);

    }

    @Override
    public int hashCode() {
        return ipAddress.hashCode();
    }

    @Override
    public String toString() {
        return "WeatherClient{" +
                "ipAddress='" + ipAddress + '\'' +
                ", port='" + port + '\'' +
                ", connection=" + connection +
                '}';
    }

    @Override
    public OutputStream sendRequestToServer() throws NoServerFoundException, IOException {
        LOGGER.info("SEND REQUEST TO SERVER");
        return connection.getOutputStream();
    }

    public void sendGsonMessageToServer(ServerMessage message) throws IOException, NoServerFoundException {
        Gson gson = new Gson();
        LOGGER.info("CONVERT MESSAGE TO JSON");
        bufferedWriter.write(gson.toJson(message));
        bufferedWriter.flush();
    }

    @Override
    public void getGsonMessageFromServer() throws NoServerFoundException, IOException {
        LOGGER.info("START READING MESSAGE");
        while (bufferedReader.readLine() != null){
            LOGGER.info(bufferedReader.readLine());
        }
        LOGGER.info("FINISH READING MESSAGE");
    }
}
