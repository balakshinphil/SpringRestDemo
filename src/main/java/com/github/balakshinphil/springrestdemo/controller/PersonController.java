package com.github.balakshinphil.springrestdemo.controller;

import com.github.balakshinphil.springrestdemo.dto.PersonDTO;
import com.github.balakshinphil.springrestdemo.model.Person;
import com.github.balakshinphil.springrestdemo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @PostMapping("/api/person")
    public Map<String, Long> addPerson(@RequestBody @Valid Person person) {
        return personService.addPerson(person);
    }


    @PostMapping("/api/person/{id}")
    public void updatePerson(@PathVariable Long id, @RequestBody @Valid Person person) {
        personService.updatePerson(id, person);
    }


    @GetMapping("/api/person/{id}")
    public PersonDTO getPerson(@PathVariable Long id) {
        return personService.getPerson(id);
    }


    @GetMapping("/api/persons")
    public List<PersonDTO> getAllPeople() {
        return personService.getAllPeople();
    }


    @DeleteMapping("/api/person/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

}
