package com.example.springboot_labb2.repositories;

import com.example.springboot_labb2.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonsRepository extends JpaRepository<Person, Long> {

   Person findPersonByName(String name);

   List<Person> findAllByName(String name);

   Person findByNameAndId(String name, Long id);


}

