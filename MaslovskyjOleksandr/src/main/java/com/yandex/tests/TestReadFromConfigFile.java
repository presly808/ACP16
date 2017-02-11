package com.yandex.tests;


import com.yandex.utils.GetProperties;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class TestReadFromConfigFile {

    private String DRIVER_PATH = "com.mysql.jdbc.Driver";
    private String DB_URL = "localhost:3306/";
    private String DB_NAME = "YANDEX";
    private String USER = "root";
    private String PASSWORD = "maslik106";

    @Test
    public void testReadFromConfigPropertiesFile() throws IOException {
        Assert.assertEquals(DRIVER_PATH, GetProperties.getDriverPath());
        Assert.assertEquals(DB_URL, GetProperties.getDbURL());
        Assert.assertEquals(DB_NAME, GetProperties.getDbName());
        Assert.assertEquals(USER, GetProperties.getUser());
        Assert.assertEquals(PASSWORD, GetProperties.getPassword());
    }

}
