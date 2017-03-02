package week3.day1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;

/**
 * Created by vitalii on 11.02.17.
 */
public class SocketCreate1{
    private static String ADDRESS = "localhost";
    private static int PORT = 8888;


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(ADDRESS, PORT);
        Gson gson = new GsonBuilder().create();
        OutputStream os = socket.getOutputStream();

        MyMessage1 message1 = new MyMessage1("client2", LocalDateTime.now(), "hello");

        os.write((gson.toJson(message1) + "\n").getBytes());
        os.flush();

        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));


        new Thread(() -> {
            while (true) {
                try {
                    os.write((gson.toJson(message1) + "\n").getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    os.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        while (true) {
            String inputMessage = reader.readLine();
            MyMessage1 message = gson.fromJson(inputMessage, MyMessage1.class);
                System.out.println(message.getCreationTime() + " " + message.getFrom() + " " + message.getBody());
        }


    }




}

class MyMessage1 {

    private String from;
    private LocalDateTime creationTime;
    private String body;

    public MyMessage1(String from, LocalDateTime creationTime, String body) {
        this.from = from;
        this.creationTime = creationTime;
        this.body = body;
    }

    public String getFrom() {
        return from;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }

    public String getBody() {
        return body;
    }
}
