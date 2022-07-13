package com.example.hw23.service;

import com.example.hw23.entity.Animal;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
@EnableCaching
public class AnimalService {

//    private final EntityManager entityManager;
    private final SessionFactory factory;

    @Autowired
    public AnimalService(SessionFactory factory) {
        this.factory = factory;
//        this.entityManager = entityManager;
    }

    @Cacheable(value = "animalId")
    public Animal getAnimal(int id) {
        System.out.println("Cache animal`s is working");
       return factory.unwrap(Session.class).get(Animal.class, id);
    }

    public List<Animal> getAllAnimals() {
       return factory.unwrap(Session.class)
               .createQuery("from Animal", Animal.class).getResultList();

    }

    public Animal saveAnimal(Animal animal) {
      factory.unwrap(Session.class).save(animal);
        return animal;
    }

    public void deleteAnimal(int id) {
       factory.unwrap(Session.class)
                .createQuery("DELETE from Animal " + "WHERE id =: animalId")
                .setParameter("animalId", id)
                .executeUpdate();
    }

    public Animal updateAnimal(Animal animal) {
       factory.unwrap(Session.class).saveOrUpdate(animal);
        return animal;
    }
}
