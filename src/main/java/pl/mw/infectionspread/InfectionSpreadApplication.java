package pl.mw.infectionspread;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class InfectionSpreadApplication {

    public static void main(String[] args) {
        SpringApplication.run(InfectionSpreadApplication.class, args);
    }

}
