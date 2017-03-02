package client;


import com.google.gson.Gson;

import controllers.ClientActions;
import exceptions.NoServerFoundException;
import org.apache.log4j.Logger;
import schema.JSonSchema;
import utils.ReadWriteProperties;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;

public class WeatherClient implements ClientActions {

    final static Logger LOGGER = Logger.getLogger(WeatherClient.class);

    private String ipAddress;
    private int port;
    private Socket connection;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private Gson gson;

    public WeatherClient(int port) throws IOException {
        this.connection = new Socket(ReadWriteProperties.getLocalYrl(), port);
        this.ipAddress = connection.getInetAddress().toString();
        this.port = connection.getPort();
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        this.bufferedWriter = new BufferedWriter(
                new OutputStreamWriter(connection.getOutputStream()));
        this.gson = new Gson();
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
        LOGGER.info("CONVERT MESSAGE TO JSON");
        bufferedWriter.write(gson.toJson(message));
        bufferedWriter.flush();
    }

    public void sendGsonMessageToServer(String city) throws IOException, NoServerFoundException {
        LOGGER.info("CONVERT MESSAGE TO JSON");
        bufferedWriter.write(gson.toJson(city));
        bufferedWriter.flush();
    }

    @Override
    public <T>T getGsonMessageFromServer() throws NoServerFoundException, IOException {
        LOGGER.info("FINISH READING MESSAGE");
        JSonSchema schema = gson.fromJson(readResponse(), (Type) JSonSchema.class);
        LOGGER.info("PARSE STRING TO OBJECT");
        LOGGER.info(schema);
        return (T) schema;
    }

    private String readResponse() throws IOException {
        StringBuilder result = new StringBuilder();
        String line;
        LOGGER.info("READ RESPONSE FROM SERVER");
        while ((line = bufferedReader.readLine()) != null){
            result.append(line);
        }
        bufferedReader.close();
        return result.toString();
    }
}
