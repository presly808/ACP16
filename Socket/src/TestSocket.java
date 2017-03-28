import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.util.stream.Stream;
import com.google.gson.Gson;

/**
 * Created by alex on 11.02.17.
 */
public class TestSocket {
    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);

        Gson gson = new Gson();


        InputStream inputStream = socket.getInputStream();

        new Thread(() -> {

            try(OutputStream outputStream = socket.getOutputStream()){

                String massage;

                while(true){

                    massage = gson.toJson(sc.nextLine());
                    outputStream.write(massage.getBytes());
                    outputStream.flush();


                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }).start();




        while(true){
            int data = inputStream.read();
            char content;

            while(data != -1) {

                content = (char) data;
                System.out.print(content);
                data = inputStream.read();

            }
        }


    }

}
