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
    public void testReadFromConfigPropertiesFilepath() throws IOException {
        Assert.assertEquals(DRIVER_PATH, GetProperties.getDriverPath());

    }

    @Test
    public void testReadFromConfigPropertiesFileURl() throws IOException {
        Assert.assertEquals(DB_URL, GetProperties.getDbURL());

    }

    @Test
    public void testReadFromConfigPropertiesFileName() throws IOException {
        Assert.assertEquals(DB_NAME, GetProperties.getDbName());

    }

    @Test
    public void testReadFromConfigPropertiesFileUser() throws IOException {
        Assert.assertEquals(USER, GetProperties.getUser());

    }

    @Test
    public void testReadFromConfigPropertiesFilePass() throws IOException {
        Assert.assertEquals(PASSWORD, GetProperties.getPassword());
    }
}
