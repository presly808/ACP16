package utils;


import org.apache.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyReader {

    private static  final Logger LOGGER = Logger.getLogger(PropertyReader.class);

    private static String fileName = "db.properties";
    private static final String UNIT = "unit";
    private static Properties properties;
    private static File file;

    public PropertyReader() {
        try {
            properties = readFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.file = new File(fileName);
    }

    private Properties readFromFile() throws IOException {
        properties = new Properties();
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(fileName);

        if (inputStream != null) {
            properties.load(inputStream);
        } else {
            LOGGER.error("Can`t read from properties file");
            throw new FileNotFoundException();
        }
        return properties;
    }

    private String getUnit() {
        LOGGER.info("READ UNIT NAME FROM PROPERTIES FILE");
        try {
            return readFromFile().getProperty(UNIT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getUnitName() {
        return new PropertyReader().getUnit();
    }

}
