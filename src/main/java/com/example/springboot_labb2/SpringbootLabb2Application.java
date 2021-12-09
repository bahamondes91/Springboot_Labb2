package com.example.springboot_labb2;

import com.example.springboot_labb2.entities.Pizza;
import com.example.springboot_labb2.repositories.PizzaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootLabb2Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLabb2Application.class, args);
    }

    @Bean
    public CommandLineRunner init(PizzaRepository pizzaRepository) {

        return args -> {
            if (pizzaRepository.count()==0){
                pizzaRepository.save(new Pizza(0L,"Hawaii","ost,tomatsås,skinska,ananas",80));

            }
        };
    }


}
