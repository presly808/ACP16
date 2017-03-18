package week3.socket;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class MyTestSocket {
 private static String ipAddressName = "192.168.1.115";
    private static int port = 8888;

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket(ipAddressName, port);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("Ops");
        pw.flush();

        readStream(socket.getInputStream());
    }

    private static void readStream(InputStream inputStream) throws IOException {
        Scanner sc = new Scanner(inputStream);
        while (true){
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        }
    }
}


