package nativeServer.run;


import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;


@SpringBootApplication(scanBasePackages = "nativeServer")
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
