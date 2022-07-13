package com.example.hw23.service;

import com.example.hw23.entity.Animal;
import com.example.hw23.entity.Person;
import com.example.hw23.repository.PersonRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;


@Service
@EnableCaching
public class PersonService {
    //private final PersonRepository personRepository;
    private final EntityManager entityManager;

    @Autowired
    public PersonService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Cacheable(value = "personId")
    public Person getPerson(int id) {
        System.out.println("cache person`s is working");
        return entityManager.unwrap(Session.class).get(Person.class, id);
    }

    public List<Person> getAllPersons() {
        return entityManager.unwrap(Session.class)
                .createQuery("from Person ", Person.class).getResultList();
    }

    public Person savePerson(Person person) {
        entityManager.unwrap(Session.class).save(person);
        return person;
    }

    public void deletePerson(int id) {
        entityManager.unwrap(Session.class)
                .createQuery("DELETE from Person where id =:personId")
                .setParameter("personId", id)
                .executeUpdate();
    }

    public Person updatePerson(Person person) {
        entityManager.unwrap(Session.class).saveOrUpdate(person);
        return person;
    }
}
