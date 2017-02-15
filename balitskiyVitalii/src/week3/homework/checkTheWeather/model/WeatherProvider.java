package week3.homework.checkTheWeather.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherProvider {

    private final String USER_AGENT = "Mozilla/5.0";
    private static Logger logger = Logger.getLogger(WeatherProvider.class);
    private static String providerAddress = "http://api.aerisapi.com/observations/kiev,ua?fields=ob.tempC,ob.weather&client_id=6JuzIFUUSoewQ5otwYD9h&client_secret=zMHKs3d9qQUk0W0Aw7EdhBMjv2ovukhKZMXsbq7Y";
    private Gson gson;
    private URL url;
    private HttpURLConnection connection;

    public WeatherProvider() throws MalformedURLException {
        gson = new GsonBuilder().create();
        url = new URL(providerAddress);
    }

    public Weather currentWeather(){
        StringBuilder inputWeather = new StringBuilder();
        try{
            connection = (HttpURLConnection) url.openConnection();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

//            logger.info("Sending 'GET' request to URL : " + url);
//            logger.info("Response Code : " + connection.getResponseCode());

            String line;
            while ((line = reader.readLine()) != null){
                inputWeather.append(line);
            }
            reader.close();

        } catch (IOException e) {
            logger.error(e.getMessage());
        }

        logger.info(inputWeather.toString());
        Weather weather = getWeather(inputWeather);

        return weather;
    }

    private Weather getWeather(StringBuilder inputWeather) {
        JsonObject jResponse = gson.fromJson(inputWeather.toString(), JsonObject.class);
        return gson.fromJson(jResponse.getAsJsonObject("response").getAsJsonObject("ob"), Weather.class);
    }
}
