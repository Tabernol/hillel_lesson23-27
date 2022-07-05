package com.example.hw23.repository;

import com.example.hw23.entity.Animal;
import com.example.hw23.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepositoryImpl {
    @Autowired
    private PersonRepository personRepository;


    public Person getPerson(int id) {
        return personRepository.findById(id).get();
    }

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public void savePerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Person person) {
    personRepository.save(person);
        return person;
    }
}
