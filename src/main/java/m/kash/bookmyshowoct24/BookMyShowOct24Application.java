package m.kash.bookmyshowoct24;

import m.kash.bookmyshowoct24.controllers.UserController;
import m.kash.bookmyshowoct24.dtos.SignUpRequestDto;
import m.kash.bookmyshowoct24.dtos.SignUpResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookMyShowOct24Application implements CommandLineRunner {
    @Autowired
    private UserController userController;

    public static void main(String[] args) {
        SpringApplication.run(BookMyShowOct24Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        SignUpRequestDto requestDto= new SignUpRequestDto();
        requestDto.setName("Kaushal");
        requestDto.setEmail("kaushal2@email.com");
        requestDto.setPassword("mypassword");

        SignUpResponseDto responseDto = userController.signUp(requestDto);
    }
}
