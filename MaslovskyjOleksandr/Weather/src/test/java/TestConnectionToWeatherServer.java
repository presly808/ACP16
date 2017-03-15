
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import server.ServerWeather;

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

    @Ignore
    @Test
    public void testSendRequestToWeatherServer() throws IOException {
        InputStream inputStream = server.sendRequestToWeatherServer();
        Assert.assertNotNull(inputStream);
    }

    @Ignore
    @Test
    public void testGetValueFromWeather() throws IOException, InterruptedException {
        Assert.assertNotNull(server.getValueFromWeatherFantom());
        Assert.assertTrue(expectedTemp.equals(server.getValueFromWeatherFantom()));
    }

    @Ignore
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
