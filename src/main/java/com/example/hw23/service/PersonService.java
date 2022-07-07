package com.example.hw23.service;

import com.example.hw23.entity.Person;
import com.example.hw23.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableCaching
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Cacheable(value = "personId")
    public Person getPerson(int id) {
        System.out.println("cache person`s is working");
        return personRepository.findById(id).get();
    }

    public List<Person> getAllPersons() {
        return (List<Person>) personRepository.findAll();
    }

    public Person savePerson(Person person) {
        personRepository.save(person);
        return person;
    }

    public void deletePerson(int id) {
        personRepository.deleteById(id);
    }

    public Person updatePerson(Person person) {
        return personRepository.save(person);
    }
}
