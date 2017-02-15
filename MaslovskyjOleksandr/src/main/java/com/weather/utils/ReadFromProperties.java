package com.weather.utils;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromProperties {

    private static final Logger LOGGER = Logger.getLogger(ReadFromProperties.class);

    private static Properties properties;
    private static String fileName = "weather.properties";
    private static final String WEATHER_URL = "urlToServer";
    private static final String WEATHER_PORT = "port";
    private static final String LOCAL_YRL = "localURL";
    private static final String LOCAL_PORT = "localport";

    public ReadFromProperties() throws IOException {
        properties = readFromFile();
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

    private String getWeatherPortFromFile() throws IOException {
        LOGGER.info("Get value from " + WEATHER_PORT);
        return readFromFile().getProperty(WEATHER_PORT);
    }

    private String getLocalUrlFromFile() throws IOException {
        LOGGER.info("Get value from " + LOCAL_YRL);
        return readFromFile().getProperty(LOCAL_YRL);
    }

    private String getLocalPortFromFile() throws IOException {
        LOGGER.info("Get value from " + LOCAL_PORT);
        return readFromFile().getProperty(LOCAL_PORT);
    }

    public static String getWeatherUrl() throws IOException {
        return new ReadFromProperties().getWeatherUrlFromFile();
    }

    public static int  getWeatherPort() throws IOException {
        return Integer.parseInt(new ReadFromProperties().getWeatherPortFromFile());
    }

    public static String getLocalYrl() throws IOException {
        return new ReadFromProperties().getLocalUrlFromFile();
    }

    public static int  getLocalPort() throws IOException {
        return Integer.parseInt(new ReadFromProperties().getLocalPortFromFile());
    }
}
