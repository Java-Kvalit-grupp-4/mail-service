package io.wakelesstuna.twiliomailsenderdemo;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TwilioMailSenderDemoApplication {

    public static Dotenv dotenv;

    public static void main(String[] args) {
        SpringApplication.run(TwilioMailSenderDemoApplication.class, args);
    }

    @Bean
    public void createDoeEnvInstance() {
        dotenv = Dotenv.load();
    }

}
