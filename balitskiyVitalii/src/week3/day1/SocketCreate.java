package week3.day1;

import java.io.*;
import java.net.Socket;

/**
 * Created by vitalii on 11.02.17.
 */
public class SocketCreate {
    private static String ADDRESS = "192.168.1.115";
    private static int PORT = 8888;


    public static void main(String[] args) throws IOException {

        Socket socket = new Socket(ADDRESS, PORT);

        OutputStream os = socket.getOutputStream();

        os.write("1\n".getBytes());
        os.flush();

        InputStream is = socket.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        while (true) {
                System.out.print((char)reader.read());
        }

    }


}
