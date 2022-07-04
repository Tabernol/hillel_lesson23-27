package com.example.hw23.service;

import com.example.hw23.entity.Animal;
import com.example.hw23.repository.AnimalRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnimalService {

    private final AnimalRepositoryImpl animalRepository;

    @Autowired
    public AnimalService(AnimalRepositoryImpl animalRepository) {
        this.animalRepository = animalRepository;
    }

    public Animal get(int id) {
        return animalRepository.getAnimal(id);
    }

    public List<Animal> getAll() {
        return animalRepository.getALLAnimals();
    }

    public void save(Animal animal) {
        animalRepository.saveAnimal(animal);
    }

    public void delete(int id) {
        animalRepository.deleteAnimal(id);
    }

    public Animal update(int id, Animal animal) {
        return animalRepository.updateAnimal(id, animal);
    }

}
