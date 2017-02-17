import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import week3.homework.checkTheWeather.model.Weather;
import week3.homework.checkTheWeather.model.WeatherProvider;

import static org.mockito.Mockito.when;

/**
 * Created by Vitalii on 17.02.2017.
 */

@RunWith(MockitoJUnitRunner.class)
public class InitMockContext {

    @Mock
    public WeatherProvider weatherProvider;

    protected Weather weather;


    @Before
    public void setUpMocks(){
        weather = new Weather();
        weather.setTempC(3.6f);
        weather.setWeather("clear");

        when(weatherProvider.currentWeather()).thenReturn(weather);
    }
}
