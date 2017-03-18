package artcode.week3;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class TestSocket {

    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("google.com", 80);
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
