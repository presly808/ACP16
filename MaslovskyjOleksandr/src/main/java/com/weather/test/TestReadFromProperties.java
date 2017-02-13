package com.weather.test;


import com.weather.utils.ReadFromProperties;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestReadFromProperties {

    private String serverUrl;

    @Before
    public void initData(){
        serverUrl = "openweathermap.org";
    }

    @Test
    public void testReadFromConfigPropertiesFilepath() throws IOException {
        Assert.assertEquals(serverUrl, ReadFromProperties.getWeatherUrl());
    }
}
