import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherProviderTest extends InitMockContext{

    @Test
    public void getCurrentWeatherTest(){
        assertThat(weather, is(weatherProvider.currentWeather()));
    }
}
