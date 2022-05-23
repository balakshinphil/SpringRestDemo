package com.github.balakshinphil.springrestdemo.service;

import com.github.balakshinphil.springrestdemo.exception.PersonExistsException;
import com.github.balakshinphil.springrestdemo.dto.PersonDTO;
import com.github.balakshinphil.springrestdemo.exception.PersonNotFoundException;
import com.github.balakshinphil.springrestdemo.model.Person;
import com.github.balakshinphil.springrestdemo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }



    @Override
    public Map<String, Long> addPerson(Person person) {
        if (personRepository.existsByName(person.getName())) {
            throw new PersonExistsException(String.format("Person with name '%s' already exists!", person.getName()));
        }

        personRepository.save(person);

        return Map.of("id", person.getId());
    }


    @Override
    public void updatePerson(Long id, Person person) {
        Person oldPerson = getPersonByIdOrThrow(id);
        person.setId(oldPerson.getId());

        personRepository.save(person);
    }


    @Override
    public PersonDTO getPerson(Long id) {
        Person person = getPersonByIdOrThrow(id);
        return new PersonDTO(person);
    }


    @Override
    public List<PersonDTO> getAllPeople() {
        return personRepository.findAll().stream().map(PersonDTO::new).collect(Collectors.toList());
    }


    @Override
    public void deletePerson(Long id) {
        Person person = getPersonByIdOrThrow(id);
        personRepository.delete(person);
    }



    private Person getPersonByIdOrThrow(Long id) {
        Optional<Person> person = personRepository.findById(id);

        if (person.isEmpty()) {
            throw new PersonNotFoundException(String.format("Person with id %d not found!", id));
        }

        return person.get();
    }
}
