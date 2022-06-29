package com.example.hw23.repository;

import com.example.hw23.entity.Animal;
import com.example.hw23.entity.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

public class AnimalRepositoryImpl {

    private final EntityManager entityManager;
    private PersonRepositoryImpl personRepository;

    @Autowired
    public AnimalRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Animal getAnimal(int id) {
        Session session = entityManager.unwrap(Session.class);
        Animal animal = session.get(Animal.class, id);
        return animal;
    }

    public List<Animal> getALLAnimals() {
        Session session = entityManager.unwrap(Session.class);
        Query<Animal> query = session.createQuery("from Animal", Animal.class);
        List<Animal> animals = query.getResultList();
        return animals;
    }

    public void saveAnimal(Animal animal) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(animal);
//        if (animal.getOwnerId() != 0) {
//          personRepository.addAnimal(animal);
//        }
    }

    public void deleteAnimal(int id) {
        Session session = entityManager.unwrap(Session.class);
        session.remove(session.get(Animal.class, id));
    }

    public Animal updateAnimal(int id, Animal animal) {
        Session session = entityManager.unwrap(Session.class);
        session.update(String.valueOf(id), animal);
        return animal;
    }

//    public List<Animal> getAnimalByPersonId(Integer personId) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Animal> query = session.createQuery("from Animal where ownerId = personId", Animal.class);
//        List<Animal> animals = query.getResultList();
//        return animals;
//    }
}