package com.example.hw23.repository;

import com.example.hw23.entity.Animal;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AnimalRepositoryImpl {

    // private final EntityManager entityManager;
    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalRepositoryImpl(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Optional<Animal> getAnimal(int id) {
//        Session session = entityManager.unwrap(Session.class);
//        Animal animal = session.get(Animal.class, id);
        return animalRepository.findById(id);
    }

    public List<Animal> getALLAnimals() {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Animal> query = session.createQuery("from Animal", Animal.class);
//        List<Animal> animals = query.getResultList();
        return (List<Animal>) animalRepository.findAll();
    }

    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
//        Session session = entityManager.unwrap(Session.class);
//        session.saveOrUpdate(animal);
//        if (animal.getOwnerId() != 0) {
//          personRepository.addAnimal(animal);
//        }
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
//        Session session = entityManager.unwrap(Session.class);
//        session.remove(session.get(Animal.class, id));
    }

//    public Animal updateAnimal(int id, Animal animal) {
////        Session session = entityManager.unwrap(Session.class);
////        session.update(String.valueOf(id), animal);
//       return animalRepository.;
//        return animal;
    // }

//    public List<Animal> getAnimalByPersonId(Integer personId) {
//        Session session = entityManager.unwrap(Session.class);
//        Query<Animal> query = session.createQuery("from Animal where ownerId = personId", Animal.class);
//        List<Animal> animals = query.getResultList();
//        return animals;
//    }
}
