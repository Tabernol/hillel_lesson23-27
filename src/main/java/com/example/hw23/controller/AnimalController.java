package com.example.hw23.controller;

import com.example.hw23.entity.Animal;
import com.example.hw23.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    @Cacheable(value = "animalId")
    public @ResponseBody Animal getAnimal(@PathVariable Integer id) {
        System.out.println("Cache is working");
        return this.animalService.get(id);
    }

    @GetMapping()
    public @ResponseBody List<Animal> getAllAnimals() {
        return animalService.getAll();
    }

    @PatchMapping
    @Transactional
    public @ResponseBody Animal updateAnimal(@RequestBody Animal animal) {
        return this.animalService.update(animal);
    }

    @PostMapping
    public Animal saveAnimal(@RequestBody Animal animal) {
        animalService.save(animal);
        return animal;

    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteAnimal(@PathVariable Integer id) {
        this.animalService.delete(id);
    }
}
