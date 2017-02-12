package ua.artcode.week3.client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class MyServer {

    private static List<Socket> clients = new ArrayList<>();

    public static void main(String[] args) {

        //192.168.1.115
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println(serverSocket.getLocalSocketAddress());

            //asynch action
            new Thread(() -> {
                while(true){
                    try {
                        Socket client =  serverSocket.accept();
                        clients.add(client);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not start server");
        }

        // separate action




        while(true){
            try {

                for (Socket client : clients) {
                    PrintWriter output = new PrintWriter(client.getOutputStream());
                    String response = String.format("CurrentTime %tc", new Date())  ;
                    output.println(response);
                    output.flush();
                }

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }


    }
}
