package ar.foodOverflow;

import ar.foodOverflow.bootstrap.Bootstrap;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        new Bootstrap().run();
        SpringApplication.run(Application.class, args);
    }
}
