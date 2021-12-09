package com.example.springboot_labb2.controller;

import com.example.springboot_labb2.repositories.PizzaRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PizzaControllerSpringBootTest {

    @Autowired
    private PizzaController pizzaController;

    @Test
    void getAllPizzas() {

        assertThat(pizzaController.pizzas()).isNotEmpty();

    }


}