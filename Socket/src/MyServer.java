
import com.google.gson.Gson;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


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
        String PATH = "Socket/src/resources/weather.json";
        String URL = "https://api.privatbank.main.java.ua/p24api/pboffice?json&city=Днепропетровск&address=Титова";
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
                    System.out.println();
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not start server");
        }

        // separate action


        new Thread(() -> {

            while (true) {

                inputMessagesObserver.notifyAllSubs(new MyMessage("server",LocalDateTime.now()));

                System.out.println();

            }

        }).start();

        new Thread(() -> {
            try {
                while(true) {
                    NetUtils.load(URL, PATH);
                    StringBuilder message = new StringBuilder();
                    BufferedReader br = new BufferedReader(new FileReader(PATH));

                    //char[] buff = new char[2048];
                    int symbol = br.read();
                    int k = 0;
                    while(symbol != -1){
                        message.append((char)symbol);
                    }
                    br.close();
                    System.out.println(message.toString());

                    //inputMessagesObserver.notifyAllSubs(new MyMessage("sinoptik", LocalDateTime.now(), message));

                    try {
                        Thread.sleep(20000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            } catch (URISyntaxException | IOException e) {
                e.printStackTrace();
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
        System.out.println("add new client " + socketClient.getIp());
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
    private Scanner sc;

    public MyMessage(String from, LocalDateTime creationTime) {
        sc = new Scanner(System.in);
        this.from = from;
        this.creationTime = creationTime;
        this.body = new Gson().toJson(sc.nextLine());
    }

    public MyMessage(String from, LocalDateTime creationTime, String body) {
        sc = new Scanner(System.in);
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
