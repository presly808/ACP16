package utils;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class ReadWriteProperties {

    private static final Logger LOGGER = Logger.getLogger(ReadWriteProperties.class);

    private static Properties properties;
    private static String fileName = "weather.properties";
    private static final String TOKEN = "token";
    private static final String WEATHER_URL = "urlToServer";
    private static final String SERVER_PORT = "port";
    private static final String LOCAL_YRL = "localURL";
    private static final String LOCAL_PORT = "localport";
    private static File file;

    public ReadWriteProperties() throws IOException {
        properties = readFromFile();
        this.file = new File(fileName);
    }

    private Properties readFromFile() throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        LOGGER.info("Read from file");
        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            LOGGER.error("Can`t read from properties file");
            throw new FileNotFoundException();
        }
        return properties;
    }

    private String getWeatherUrlFromFile() throws IOException {
        LOGGER.info("Get value from " + WEATHER_URL);
        return readFromFile().getProperty(WEATHER_URL);
    }

    private String getServerPortFromFile() throws IOException {
        LOGGER.info("Get value from " + SERVER_PORT);
        return readFromFile().getProperty(SERVER_PORT);
    }

    private String getLocalUrlFromFile() throws IOException {
        LOGGER.info("Get value from " + LOCAL_YRL);
        return readFromFile().getProperty(LOCAL_YRL);
    }

    private String getLocalPortFromFile() throws IOException {
        LOGGER.info("Get value from " + LOCAL_PORT);
        return readFromFile().getProperty(LOCAL_PORT);
    }

    private String getTokenFromFile() throws IOException {
        LOGGER.info("Get value from " + TOKEN);
        return readFromFile().getProperty(TOKEN);
    }

    public static String getToken() throws IOException {
        return new ReadWriteProperties().getTokenFromFile();
    }

    public static String getWeatherUrl() throws IOException {
        return new ReadWriteProperties().getWeatherUrlFromFile();
    }

    public static int getServerPort() throws IOException {
        return Integer.parseInt(new ReadWriteProperties().getServerPortFromFile());
    }

    public static String getLocalYrl() throws IOException {
        return new ReadWriteProperties().getLocalUrlFromFile();
    }

    public static int  getLocalPort() throws IOException {
        return Integer.parseInt(new ReadWriteProperties().getLocalPortFromFile());
    }

    public static void writePortIntoProperties(int port) throws IOException {
        LOGGER.info("WRITE PORT TO PROPERTIES FILE");
        properties.setProperty(SERVER_PORT, String.valueOf(port));
        FileWriter fileWriter = new FileWriter(file);
        properties.store(fileWriter, "");
        fileWriter.close();
    }

}
