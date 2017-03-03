package utils;


import org.apache.log4j.Logger;
import java.io.IOException;
import java.util.Properties;


public class PropertyReader {

    private static  final Logger LOGGER = Logger.getLogger(PropertyReader.class);

    private static final String DB_PROPERTIES = "db.properties";
    private static final String UNIT = "unit";
    private static Properties properties;

    public PropertyReader() {
        if (properties == null) {
            this.properties = new Properties();
            try {
                properties.load(this.getClass().getResourceAsStream(DB_PROPERTIES));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getUnitName() {
        properties = new Properties();
        LOGGER.info("READ UNIT NAME FROM PROPERTIES FILE");
        return properties.getProperty(UNIT);
    }

}
