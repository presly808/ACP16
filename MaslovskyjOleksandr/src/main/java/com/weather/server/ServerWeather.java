package com.weather.server;


import com.google.gson.Gson;
import com.weather.utils.HtmlParser;
import com.weather.utils.ReadWriteProperties;
import org.apache.log4j.Logger;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.stream.Collectors;

public class ServerWeather {

    private final static Logger LOGGER = Logger.getLogger(ServerWeather.class);
    private final String WAIT_MESSAGE = "PLEASE WAIT UNTIL INFO LOADED";
    private final String WEATHER = ReadWriteProperties.getWeatherUrl();
    private final int PORT = ReadWriteProperties.getLocalPort();
    private final String TEMP_ID = "weather-widget-temperature";

    private String ipAddress;
    private int port;
    private ServerSocket server;
    private Gson gson;


    public ServerWeather() throws IOException {
        server = new ServerSocket(ReadWriteProperties.getServerPort());
        ipAddress = server.getInetAddress().toString();
        this.port = server.getLocalPort();
        this.gson = new Gson();
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
                    sendRequestToWeatherServer();
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
        Socket socket = new Socket(WEATHER, PORT);
        socket.getOutputStream();
        return socket.getInputStream();
    }

    private Document getHTMLSource() throws IOException {
        return HtmlParser.getPageSource(ReadWriteProperties.getWeatherUrl());
    }

    public String getValueFromWeather() throws IOException {
        Document document = getHTMLSource();
        Element element = HtmlParser.getElement(document, TEMP_ID);
        LOGGER.info("GET VALUE FROM ELEMENT");
        return element.data();
    }

    private void sendToClientResponseWithTemperature(Socket client) throws IOException {
        String value = gson.toJson(getValueFromWeather());
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream()));
        bufferedWriter.write(value);
        LOGGER.info("SEND RESPONSE WITH TEMPERATURE TO USER: " + value);
        bufferedWriter.flush();
    }

    public String listenWeatherGson() throws IOException {
        final String[] response = {""};
        new Thread(() -> {
            LOGGER.info("NEW THREAD CREATED");
            InputStream inputStream = null;
            try {
                inputStream = sendRequestToWeatherServer();
                response[0] = gson.toJson(convertInputStreamToString(inputStream));;
            } catch (IOException e) {
                LOGGER.error("CONNECTION REFUSED");
                e.printStackTrace();
            }
        }
        ).start();
        return response[0];
    }

    private String convertInputStreamToString(InputStream inputStream){
        return new BufferedReader(new InputStreamReader(inputStream))
                .lines().collect(Collectors.joining("\n")).toString();
    }

}
