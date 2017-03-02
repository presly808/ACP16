package utils;

import java.io.IOException;

/**
 * Created by ubuntu on 10.02.17.
 */
public class GetProperties {

    private static ReadFromConfigProperties readFromConfigProperties = new ReadFromConfigProperties();

    public static String getDriverPath() throws IOException {
        return readFromConfigProperties.getDriverPath();
    }

    public static String getDbURL() throws IOException {
        return readFromConfigProperties.getDbURL();
    }

    public static String getDbName() throws IOException {
        return readFromConfigProperties.getDbName();
    }

    public static String getUser() throws IOException {
        return readFromConfigProperties.getUser();
    }

    public static String getPassword() throws IOException {
        return readFromConfigProperties.getPassword();
    }
}
