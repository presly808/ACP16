package week3.chat;


import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.Scanner;

public class MyTestSocket {

    private static String ipAddressName = "127.0.0.1";
    private static int port = 8888;
    private static Gson gson = new Gson();

    public static void main(String[] args) throws IOException {

        Gson gson = new Gson();
        String gsonObj = gson.toJson(createMessage());

        Socket socket = new Socket(ipAddressName, port);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println(gsonObj);
        pw.flush();

        readStream(socket.getInputStream());
    }

    private static MyMessage createMessage(){
        return new MyMessage("runner", LocalDateTime.now(),"HI!!!!!");
    }

    private static void readStream(InputStream inputStream) throws IOException {
        BufferedReader streamReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        while (true){

        }
    }
}


