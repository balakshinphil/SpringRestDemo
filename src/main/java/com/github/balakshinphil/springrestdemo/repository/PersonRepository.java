package com.github.balakshinphil.springrestdemo.repository;

import com.github.balakshinphil.springrestdemo.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {
    Optional<Person> findById(Long id);

    boolean existsById(Long id);

    boolean existsByName(String name);

    List<Person> findAll();
}
