package ua.artcode.week3.client_server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class MyServer {

    // logging(sout),
    // send message as json(use GSon lib)
    // new thread that accepts messages from client then notifyAll subscribers
    public static void main(String[] args) {

        InputMessagesObserver inputMessagesObserver = new InputMessagesObserver();
        //192.168.1.115
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            System.out.println(serverSocket.getLocalSocketAddress());

            //asynch action
            new Thread(() -> {
                while (true) {
                    try {
                        Socket client = serverSocket.accept();
                        inputMessagesObserver.subscribe(new SocketClient(client));
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


        new Thread(() -> {
            while (true) {

                inputMessagesObserver.notifyAllSubs(new MyMessage("server",LocalDateTime.now(),"hello"));

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();


    }
}

class InputMessagesObserver {

    private List<SocketClient> subscribers;

    public InputMessagesObserver() {
        subscribers = new ArrayList<>();
    }

    public void subscribe(SocketClient socketClient){
        subscribers.add(socketClient);
    }

    public void notifyAllSubs(MyMessage message){

        subscribers.stream()
                .filter((sub) -> !sub.getIp().equals(message.getFrom()))
                .forEach((sub) -> sub.sendMessage(message));

    }


}

class MyMessage {

    private String from;
    private LocalDateTime creationTime;
    private String body;

    public MyMessage(String from, LocalDateTime creationTime, String body) {
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


class SocketClient {

    private String ip;
    private Socket socket;
    private PrintWriter printWriter;
    private BufferedReader bufferedReader;

    public SocketClient(Socket socket) throws IOException {
        this.socket = socket;

        this.ip = socket.getInetAddress().toString();
        this.bufferedReader = new BufferedReader(
                new InputStreamReader(socket.getInputStream()));

        this.printWriter = new PrintWriter(socket.getOutputStream());
    }

    public String getIp() {
        return ip;
    }

    public PrintWriter getPrintWriter() {
        return printWriter;
    }

    public BufferedReader getBufferedReader() {
        return bufferedReader;
    }

    public void sendMessage(MyMessage message) {
        printWriter.printf("Time %s, From %s, Message %s \n",
                message.getCreationTime().toString(), message.getFrom(), message.getBody());
        printWriter.flush();
    }
}
