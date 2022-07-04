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

    private final EntityManager entityManager;
    private AnimalRepositoryImpl animalRepository;
    private Person person;

    @Autowired
    public PersonRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Person getPerson(int id) {
        Session session = entityManager.unwrap(Session.class);
        Person person = session.get(Person.class, id);
        return person;
    }

    public List<Person> getAllPersons() {
        Session session = entityManager.unwrap(Session.class);
        Query<Person> query = session.createQuery("from Person", Person.class);
        List<Person> persons = query.getResultList();
        return persons;
    }

    public void savePerson(Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(person);
    }

    public void deletePerson(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(Person.class, id));
    }

    public Person updatePerson(int id, Person person) {
        Session session = entityManager.unwrap(Session.class);
        session.update(String.valueOf(id), person);
        return person;
    }

//    public void addAnimal(Animal animal) {
//        if (person.getPet() == null) {
//            person.setPet(new ArrayList<>());
//        }
//        person.getPet().add(animal);
//    }
}
