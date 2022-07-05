package com.example.hw23.service;

import com.example.hw23.entity.Animal;
import com.example.hw23.entity.Person;
import com.example.hw23.repository.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepositoryImpl personRepository;
@Autowired
    public PersonService(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    public Person get(int id) {
        return personRepository.getPerson(id);
    }

    public List<Person> getAll() {
        return personRepository.getAllPersons();
    }

    public void save(Person person) {
        personRepository.savePerson(person);
    }

    public void delete(int id) {
        personRepository.deletePerson(id);
    }

    public Person update(Person person){
        return personRepository.updatePerson(person);
    }
}
