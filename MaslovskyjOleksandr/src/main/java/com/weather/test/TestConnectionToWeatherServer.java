package com.weather.test;


import com.weather.server.ServerWeather;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestConnectionToWeatherServer {

    private ServerWeather server;
    private String actualTemp;


    @Before
    public void prepareForTesting() throws IOException {
        server = new ServerWeather();
        this.actualTemp = "7.5";
    }


    @Test
    public void testSendRequestToWeatherServer() throws IOException {
        InputStream inputStream = server.sendRequestToWeatherServer();
        Assert.assertNotNull(inputStream);
    }

    @Test
    public void testGetValueFromWeather() throws IOException {
        Assert.assertNotNull(server.getValueFromWeather());
        Assert.assertTrue(actualTemp.equals(server.getValueFromWeather()));
    }

    @Test
    public void testSendToClientResponseWithTemperature(){

    }

    @Test
    public void testListenWeatherGson(){

    }


}
