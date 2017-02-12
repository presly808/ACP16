package com.weather.utils;

import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by ubuntu on 12.02.17.
 */
public class ReadFromProperties {

    private static final Logger LOGGER = Logger.getLogger(ReadFromProperties.class);

    private Properties properties;
    private String fileName = "weather.properties";
    private final String WEATHER_URL = "urlToServer";

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
        return readFromFile().getProperty(WEATHER_URL);
    }
}
