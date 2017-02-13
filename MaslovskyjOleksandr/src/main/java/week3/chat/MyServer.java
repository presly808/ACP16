package week3.chat;

import com.google.gson.Gson;
import jdk.nashorn.internal.parser.JSONParser;
import jdk.nashorn.internal.runtime.JSONFunctions;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class MyServer {

    final static Logger LOGGER = Logger.getLogger(MyServer.class);

    // logging(sout),
    // send message as json(use GSon lib)
    // new thread that accepts messages from client then notifyAll subscribers
    public static void main(String[] args) {

        InputMessagesObserver inputMessagesObserver = new InputMessagesObserver();
        //192.168.1.115
        try {
            ServerSocket serverSocket = new ServerSocket(8888);
            LOGGER.info(serverSocket.getLocalSocketAddress());

            //asynch action
            new Thread(() -> {
                while (true) {
                    try {
                        Socket client = serverSocket.accept();
                        LOGGER.info("accept socket runner");
                        inputMessagesObserver.subscribe(new SocketClient(client));
                    } catch (IOException e) {
                        LOGGER.error("can`t accept socket runner");
                        e.printStackTrace();
                    }
                }
            }).start();
            LOGGER.info("Start thread");

        } catch (IOException e) {
            LOGGER.error("Could not start runner");
            e.printStackTrace();
            throw new RuntimeException("Could not start runner");
        }

        // separate action

        new Thread(() -> {
            while (true) {
                inputMessagesObserver.notifyAllSubs(new MyMessage("runner",LocalDateTime.now(),"GET. THANKS"),
                        true);

                try {
                    LOGGER.info("Wait...");
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    LOGGER.error("No connection");
                    e.printStackTrace();
                }

            }
        }).start();
    }
}

class InputMessagesObserver {

    final static Logger LOG = Logger.getLogger(InputMessagesObserver.class);

    private List<SocketClient> subscribers;
    private Gson gson;

    public InputMessagesObserver() {
        LOG.info("put message into observer");
        subscribers = new ArrayList<>();
        gson = new Gson();
    }

    public void subscribe(SocketClient socketClient){
        LOG.info("add subscriber");
        subscribers.add(socketClient);
    }

    public void notifyAllSubs(MyMessage message){
        LOG.info("Notify All subscribers");
        subscribers.stream()
                .filter((sub) -> !sub.getIp().equals(message.getFrom()))
                .forEach((sub) -> sub.sendMessage(message));

    }

    public void notifyAllSubs(MyMessage message, boolean gsonFormat)
    {
        LOG.info("Notify All subscribers");
        subscribers.stream()
                .filter((sub) -> !sub.getIp().equals(message.getFrom()))
                .forEach((sub) -> sub.sendMessage(gson.toJson(message), true));

    }

}

class MyMessage {

    final static Logger LOG = Logger.getLogger(MyMessage.class);

    private String from;
    private LocalDateTime creationTime;
    private String body;

    public MyMessage(String from, LocalDateTime creationTime, String body) {
        LOG.info("Create message");
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

    final static Logger LOG = Logger.getLogger(SocketClient.class);

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
        LOG.info("Send message: " + message.toString());
        printWriter.printf("Time %s, From %s, Message %s \n",
                message.getCreationTime().toString(), message.getFrom(), message.getBody());
        printWriter.flush();
    }

    public void sendMessage(String message, boolean gsonFormat) {
        LOG.info("Send message: " + message.toString());
        printWriter.printf("Time %s, From %s, Message %s \n", message);
        printWriter.flush();
    }
}
