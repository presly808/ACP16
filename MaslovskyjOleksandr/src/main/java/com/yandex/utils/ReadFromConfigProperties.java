package com.yandex.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadFromConfigProperties {

    private Properties properties;
    private InputStream inputStream;
    private String fileName = "/java/com/yandex/db.properties";


    public ReadFromConfigProperties() {
        properties = new Properties();
        inputStream = null;
    }

    public Properties readFromFile() throws IOException {

        inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            throw new FileNotFoundException();
        }
        return properties;
    }

    public String getDriverPath() throws IOException {
        Properties properties = readFromFile();
        return properties.getProperty("DRIVER_PATH");
    }

    public String getDbURL() throws IOException {
        Properties properties = readFromFile();
        return properties.getProperty("DB_URL");
    }

    public String getDbName() throws IOException {
        Properties properties = readFromFile();
        return properties.getProperty("DB_NAME");
    }

    public String getUser() throws IOException {
        Properties properties = readFromFile();
        return properties.getProperty("USER");
    }

    public String getPassword() throws IOException {
        Properties properties = readFromFile();
        return properties.getProperty("PASSWORD");
    }

}
