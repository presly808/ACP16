package week3.homework.checkTheWeather.test;

import org.junit.Before;
import org.junit.Test;
import week3.homework.checkTheWeather.model.Weather;
import week3.homework.checkTheWeather.model.WeatherProvider;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherProviderTest {

    protected WeatherProvider weatherProvider;
    protected Weather weather;

    @Before
    public void setUpTest() throws MalformedURLException, UnsupportedEncodingException {
        weatherProvider = new WeatherProvider();
        weather = new Weather();
    }

    @Test
    public void getCurrentWeatherTest(){
        System.out.println(weatherProvider.CurrentWeather());
    }
}
