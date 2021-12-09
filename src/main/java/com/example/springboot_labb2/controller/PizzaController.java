package com.example.springboot_labb2.controller;

import com.example.springboot_labb2.entities.Pizza;
import com.example.springboot_labb2.repositories.PizzaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PizzaController {


    private final PizzaRepository pizzaRepository;


    public PizzaController(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    @GetMapping("/pizzas")
    public List<Pizza> pizzas() {
        return pizzaRepository.findAll();
    }

    @GetMapping("/pizzas/{id}")
    public Optional<Pizza> findOnePizza(@PathVariable long id) {
        return pizzaRepository.findById(id);
    }

    @PostMapping("/pizzas")
    public ResponseEntity<Pizza> createPizza(@Validated @RequestBody Pizza pizza) {
        pizzaRepository.save(pizza);
        return new ResponseEntity<Pizza>(pizza, HttpStatus.CREATED);

    }

    @DeleteMapping("/pizzas/{id}")
    public void deletePizza(@PathVariable("id") long id) {
        pizzaRepository.deleteById(id);
    }


    @PatchMapping("/pizzas/{id}")
    public ResponseEntity<Pizza> updatePizza(@RequestBody Pizza pizza, @PathVariable long id) {
        Optional<Pizza> newPizza = pizzaRepository.findById(id);
        if (newPizza.isEmpty())
            return ResponseEntity.notFound().build();

        var oldPizza = newPizza.get();

        if (pizza.getName() != null && !pizza.getName().isEmpty()) {
            oldPizza.setName(pizza.getName());
        }
        if (pizza.getIngridients() != null && !pizza.getIngridients().isEmpty()) {
            oldPizza.setIngridients(pizza.getIngridients());
        }

        pizzaRepository.save(oldPizza);
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/pizzas/find")
    @ResponseBody
    public List<Pizza> findAll(@RequestParam(required = false) String name) {
        return pizzaRepository.findAllByName(name);
    }


}
