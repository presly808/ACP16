
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.ReadWriteProperties;

import java.io.IOException;

public class TestReadFromProperties {

    private String serverUrl;

    @Before
    public void initData(){
        serverUrl = "openweathermap.org";
    }

    @Test
    public void testReadFromConfigPropertiesFilepath() throws IOException {
        Assert.assertEquals(serverUrl, ReadWriteProperties.getWeatherUrl());
    }
}
