package week3.homework.checkTheWeather.model;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class Weather {

    private float tempC;
    private String weather;

    public Weather() {
    }

    public float getTempC() {
        return tempC;
    }

    public void setTempC(float tempC) {
        this.tempC = tempC;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    @Override
    public String toString() {
        return "{" +
                "tempC='" + tempC + '\'' +
                ", weather='" + weather + '\'' +
                '}';
    }
}
