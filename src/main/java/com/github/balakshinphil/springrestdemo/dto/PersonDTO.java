package com.github.balakshinphil.springrestdemo.dto;

import com.github.balakshinphil.springrestdemo.model.Person;

public class PersonDTO {
    private final String name;
    private final Integer age;
    private final String sex;



    public PersonDTO(Person person) {
        this.name = person.getName();
        this.age = person.getAge();
        this.sex = person.getSex() ? "Male" : "Female";
    }



    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }
}
