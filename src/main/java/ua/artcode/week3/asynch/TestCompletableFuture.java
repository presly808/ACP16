package ua.artcode.week3.asynch;

import com.sun.xml.internal.ws.util.CompletedFuture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
public class TestCompletableFuture {


    public static void main(String[] args) throws IOException {

        // blocking moment
        Files.readAllBytes(
                Paths.get("/home/serhii/testagt/platform/dcoll-core-scheduler-components/ACP16/.gitignore"));


        CompletableFuture.supplyAsync(() -> {

            for (int i = 0; i < 10; i++) {
                System.out.println("Run asynch 1");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "";
        }).thenRun(new Runnable() {
            @Override
            public void run() {
                System.out.println("some");
            }
        });



        new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });


    }
}
