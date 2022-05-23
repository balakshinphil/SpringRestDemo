package com.github.balakshinphil.springrestdemo.service;

import com.github.balakshinphil.springrestdemo.dto.PersonDTO;
import com.github.balakshinphil.springrestdemo.model.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {
    Map<String, Long> addPerson(Person person);

    void updatePerson(Long id, Person person);

    PersonDTO getPerson(Long id);

    List<PersonDTO> getAllPeople();

    void deletePerson(Long id);
}
