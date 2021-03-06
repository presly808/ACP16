package com.weather.server;


import com.google.gson.Gson;
import com.weather.client.Location;
import com.weather.client.WeatherClient;
import com.weather.utils.HtmlParser;
import com.weather.utils.HttpService;
import com.weather.utils.PhantomJsUtils;
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
    private String weather_message = "\"GET / HTTP/1.1\\n\"";

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

    public void listeningClients(){
        new Thread(() -> {
            LOGGER.info("NEW THREAD CREATED");
            while (true){
                try {
                    Socket client = server.accept();
                    sendToClientTempResponse(client);
                    sendRequestToWeatherServer();
                    sendWeatherToClient(client);
                } catch (IOException e) {
                    LOGGER.error("CONNECTION REFUSED");
                    e.printStackTrace();
                    LOGGER.info("WAIT FOR CLIENT");
                }

            }
        }
        ).start();

    }

    public void sendWeatherToClient(Socket client) throws IOException {
        new Thread(() -> {
            LOGGER.info("NEW THREAD CREATED");
            try {
                sendGetHttpRequestToWeatherServer(getMessageFromClient(client));
            } catch (IOException e) {
                LOGGER.error("CONNECTION REFUSED");
                e.printStackTrace();
            }
        }
        ).start();
    }

    public void sendToClientTempResponse(Socket client) throws IOException {
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

    public void sendToClientResponseWithTemperature(Socket client) throws IOException, InterruptedException {
        String value = gson.toJson(getValueFromWeatherFantom());
        BufferedWriter bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(client.getOutputStream()));
        bufferedWriter.write(value);
        LOGGER.info("SEND RESPONSE WITH TEMPERATURE TO USER: " + value);
        bufferedWriter.flush();
    }

    public InputStream sendRequestToWeatherServer() throws IOException {
        LOGGER.info("SEND REQUEST TO WEATHER SERVER");
        Socket socket = new Socket(WEATHER, PORT);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(gson.toJson(weather_message));
        pw.flush();
        return socket.getInputStream();
    }

    public String getValueFromWeatherFantom() throws IOException, InterruptedException {
        Document document = getHTMLSourceFromPhantomDriver();
        Element element = HtmlParser.getElement(document, TEMP_ID);
        LOGGER.info("GET VALUE FROM ELEMENT");
        return element.data();
    }

    public String getValueFromWeather() throws IOException {
        Document document = getHTMLSource();
        Element element = HtmlParser.getElement(document, TEMP_ID);
        LOGGER.info("GET VALUE FROM ELEMENT");
        return element.data();
    }

    public String sendGetHttpRequestToWeatherServer(String city) throws IOException {
        String url = generateGetUrl(city);
        String response = HttpService.sendGetQuery(url);
        return response;
    }

    private Document getHTMLSource() throws IOException {
        return HtmlParser.getPageSource(WEATHER);
    }

    private Document getHTMLSourceFromPhantomDriver() throws InterruptedException {
        return PhantomJsUtils.getSourcePage(WEATHER);
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder result = new StringBuilder();
        String line;
        LOGGER.info("READ RESPONSE FROM SERVER");
        while ((line = bufferedReader.readLine()) != null){
            result.append(line);
        }
        bufferedReader.close();
        return result.toString();
    }

    private String getMessageFromClient(Socket client) throws IOException {
        return convertInputStreamToString(client.getInputStream());
    }

    private String generateGetUrl(String city) throws IOException {
        String token = ReadWriteProperties.getToken();
        LOGGER.info("GENERATE GET URL");
        return WEATHER + "/data/2.5/weather?q=" + city + "&appid=" + token;
    }

}
