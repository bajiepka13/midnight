package org.bajiepka.midnight;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MidnightApplication {

    public static void main(String[] args) {
        log.info("Приложение запускается...");
        SpringApplication.run(MidnightApplication.class, args);
    }
}
