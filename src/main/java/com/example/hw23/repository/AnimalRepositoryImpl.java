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
    @Autowired
    private AnimalRepository animalRepository;

    // this is where the circular references is declared so I initialize the constructor. why?
//    @Autowired
//    public AnimalRepositoryImpl(AnimalRepository animalRepository) {
//        this.animalRepository = animalRepository;
//    }

    public Animal getAnimal(int id) {
        return animalRepository.findById(id).get();
    }

    public List<Animal> getALLAnimals() {
        return (List<Animal>) animalRepository.findAll();
    }

    public void saveAnimal(Animal animal) {
        animalRepository.save(animal);
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    public Animal updateAnimal(int id, Animal animal) {
        if(animalRepository.existsById(id)){
            animalRepository.findById(id).get().setName(animal.getName());
        }
        else {
            animalRepository.save(animal);
        }
        return animal;
     }
}
