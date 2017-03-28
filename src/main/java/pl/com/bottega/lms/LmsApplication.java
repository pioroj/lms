package pl.com.bottega.lms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class LmsApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(LmsApplication.class, args);
    }

}
