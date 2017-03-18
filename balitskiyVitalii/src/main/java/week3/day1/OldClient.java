package week3.day1;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by Vitalii on 12.02.2017.
 */
public class OldClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.1.115", 8888);
        PrintWriter pw = new PrintWriter(socket.getOutputStream());
        pw.println("GET / HTTP/1.1\n");
        pw.flush();

        readStream(socket.getInputStream());
    }

    private static void readStream(InputStream inputStream) throws IOException {
        Scanner sc = new Scanner(inputStream);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}
