package m.kash.seatify;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SeatifyApplication {
    public static void main(String[] args) {
        SpringApplication.run(SeatifyApplication.class, args);
    }

}
