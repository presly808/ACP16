package com.weather.test;


import com.weather.client.Location;
import com.weather.server.ServerWeather;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class TestConnectionToWeatherServer {

    private ServerWeather server;
    private String expectedTemp;
    private String location;

    @Before
    public void prepareForTesting() throws IOException {
        server = new ServerWeather();
        this.expectedTemp = "7.5";
        this.location = "London";
    }

    @Test
    public void testSendRequestToWeatherServer() throws IOException {
        InputStream inputStream = server.sendRequestToWeatherServer();
        Assert.assertNotNull(inputStream);
    }

    @Test
    public void testGetValueFromWeather() throws IOException, InterruptedException {
        Assert.assertNotNull(server.getValueFromWeatherFantom());
        Assert.assertTrue(expectedTemp.equals(server.getValueFromWeatherFantom()));
    }

    @Test
    public void testSendGetRequestToWeatherServer() throws IOException {
        Assert.assertNotNull(server.sendGetHttpRequestToWeatherServer(location));
    }

    @Test
    public void testSendToClientResponseWithTemperature(){

    }

    @Test
    public void testListenWeatherGson(){

    }

}
