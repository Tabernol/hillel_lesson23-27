package com.example.hw23.service;

import com.example.hw23.entity.Animal;
import com.example.hw23.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@EnableCaching
public class AnimalService {

    private final AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    @Cacheable(value = "animalId")
    public Animal getAnimal(int id) {
        System.out.println("Cache animal`s is working");
        return animalRepository.findById(id).get();
    }

    public List<Animal> getAllAnimals() {
        return (List<Animal>) animalRepository.findAll();
    }

    public Animal saveAnimal(Animal animal) {
        animalRepository.save(animal);
        return animal;
    }

    public void deleteAnimal(int id) {
        animalRepository.deleteById(id);
    }

    public Animal updateAnimal(Animal animal) {
        return animalRepository.save(animal);
    }

}
