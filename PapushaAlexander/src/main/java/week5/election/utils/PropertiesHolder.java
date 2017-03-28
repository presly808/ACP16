package week5.election.utils;


import java.io.IOException;
import java.util.Properties;

/**
 * Created by alex on 03.03.17.
 */
public class PropertiesHolder {


    public static final String APP_PROPERTIES_FILE = "/app.properties";
    private static final Properties PROPS = loadProps();

    private static Properties loadProps() {
        Properties properties = new Properties();
        try {
            properties.load(PropertiesHolder.class.getResourceAsStream(APP_PROPERTIES_FILE));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("can not load properties", e);
        }
        return properties;
    }

    public static String get(String key) {
        return PROPS.getProperty(key);
    }
}