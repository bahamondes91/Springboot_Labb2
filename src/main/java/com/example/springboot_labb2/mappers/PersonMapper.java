package com.example.springboot_labb2.mappers;

import com.example.springboot_labb2.dtos.PersonDto;
import com.example.springboot_labb2.entities.Person;

public class PersonMapper {

    public static Person dtoToEntity(PersonDto personDto) {
        return new Person(personDto.id, personDto.name);
    }

    public static PersonDto entityoToDto(Person person) {
        return new PersonDto(person.getId(), person.getName());
    }
}
