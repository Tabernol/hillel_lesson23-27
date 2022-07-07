package com.example.hw23.controller;

import com.example.hw23.entity.Animal;
import com.example.hw23.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.transaction.Transactional;
import java.util.List;


@RestController
@RequestMapping("/animal")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/{id}")
    public @ResponseBody Animal getAnimal(@PathVariable Integer id) {

        return this.animalService.getAnimal(id);
    }

    @GetMapping()
    public @ResponseBody List<Animal> getAllAnimals() {
        return animalService.getAllAnimals();
    }

    @PatchMapping
    @Transactional
    public @ResponseBody Animal updateAnimal(@RequestBody Animal animal) {
        return this.animalService.updateAnimal(animal);
    }

    @PostMapping
    public Animal saveAnimal(@RequestBody Animal animal) {
        animalService.saveAnimal(animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteAnimal(@PathVariable Integer id) {
        this.animalService.deleteAnimal(id);
    }
}
