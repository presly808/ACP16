package week3.homework.checkTheWeather.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherObserver {

    private Set<WeatherClient> clients;

    public WeatherObserver(){
        clients = new HashSet<>();
    }

    public void addClient(WeatherClient client){
        clients.add(client);
    }

    public void notifyAll(Weather weather){
        clients.stream().forEach((client) -> client.sendMessage(weather));
    }


}
