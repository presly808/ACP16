package week3.homework.checkTheWeather.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.log4j.Logger;
import week3.day1.SocketCreate;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * Created by Vitalii on 13.02.2017.
 */
public class WeatherClient implements Runnable {

    Logger logger = Logger.getLogger(WeatherClient.class);

    private Socket socket;
    private PrintWriter writer;
    private BufferedReader reader;
    private Gson gson;

    public WeatherClient(Socket socket) throws IOException {
        this.socket = socket;
        gson = new GsonBuilder().create();

        this.reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.writer = new PrintWriter(socket.getOutputStream());
    }

    public void sendMessage(Weather weather) {
        writer.println(weather);
        writer.flush();
    }

    public void run() {
        Weather weather = null;
        while (true) {
            try {
                String inputMessage = reader.readLine();
                weather = gson.fromJson(inputMessage, Weather.class);
                System.out.println(LocalDateTime.now().toString() + weather + "CLIENT");
            }catch(IOException e){
                logger.info(e.getMessage());
            }
        }
    }
}
