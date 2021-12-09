package com.example.springboot_labb2.controller;

import com.example.springboot_labb2.dtos.PersonDto;
import com.example.springboot_labb2.entities.Person;
import com.example.springboot_labb2.mappers.PersonMapper;
import com.example.springboot_labb2.repositories.PersonsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonController {

    private final PersonsRepository personsRepository;
    private final ModelMapper mapper;

    public PersonController(PersonsRepository personsRepository, ModelMapper mapper) {
        this.personsRepository = personsRepository;
        this.mapper = mapper;
    }

    @GetMapping("/persons")
    List<Person> getAllPersons() {
        return personsRepository.findAll();
    }

    @GetMapping("/persons/{id}")
    Optional<Person> getOnePerson(@PathVariable("id") Long id){
       return personsRepository.findById(id);
    }

    @GetMapping("/search")
    Person findAPerson(String name) {
        return personsRepository.findPersonByName(name);
    }

    @PostMapping("/persons")
    PersonDto saveAsPerson(@RequestBody PersonDto personDto) {
        return PersonMapper.entityoToDto(personsRepository.save(mapper.map(personDto, Person.class)));
    }

}
