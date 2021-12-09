package com.example.springboot_labb2.repositories;

import com.example.springboot_labb2.entities.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PizzaRepository extends JpaRepository<Pizza, Long> {

    List<Pizza> findAllByNameAndPriceGreaterThan(String name, int price);
    List<Pizza> findAllByName(String name);

}
