package com.snva.soap.payments;

import com.snva.soap.payments.Repository.BootcampRepository;
import com.snva.soap.payments.Repository.UserRepository;
import com.snva.soap.payments.model.Bootcamp;
import com.snva.soap.payments.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories
@SpringBootApplication
public class PaymentsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PaymentsApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, BootcampRepository bootcampRepository) {
        return args -> {

            if (false) {

                User user = new User();
                user.setFirstName("Jack");
                user.setLastName("Fe");
                user.setContact("123456789");
                user.setAge(20);
                userRepository.save(user);
                System.out.println("User is created!!!");

                Bootcamp bootcamp = new Bootcamp();
                bootcamp.setBootcampName("Java");
                bootcamp.setDetails("Full-stack Java bootcamp");
                bootcamp.setInstructor("Viet");
                bootcampRepository.save(bootcamp);
                System.out.println("Bootcamp is created!!!");
            }
        };
    }

}
