package week3.homework.checkTheWeather.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.*;
import java.util.logging.Logger;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherProvider {

    private final String USER_AGENT = "Mozilla/5.0";
    private static Logger logger = Logger.getLogger(WeatherProvider.class.toString());
    private static String providerAddress = "http://api.openweathermap.org/data/2.5/forecast/city?id=703448&APPID=5157501f93d7a5f0eb66e2084430b6c7";
    private Gson gson;
    private URL url;
    private URLConnection connection;
    String paramValue = "param\\with\\backslash";

    public WeatherProvider() throws MalformedURLException {
        gson = new GsonBuilder().create();
        url = new URL(providerAddress);
    }

    public Weather CurrentWeather(){
        StringBuilder inputWeather = new StringBuilder();
        try{
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            logger.info("\nSending 'GET' request to URL : " + url);
            logger.info("Response Code : " + connection.getResponseCode());



            String line;
            while ((line = reader.readLine()) != null){
                inputWeather.append(line + "\n");
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info(inputWeather.toString());
        Weather weather = gson.fromJson(inputWeather.toString(), Weather.class);
        return weather;
    }
}
