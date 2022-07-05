package com.example.hw23.controller;

import com.example.hw23.entity.Person;
import com.example.hw23.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public @ResponseBody Person getPerson(@PathVariable Integer id) {
        return this.personService.get(id);
    }

    @GetMapping
    public @ResponseBody List<Person> getAllPersons() {
        return personService.getAll();
    }

    @PatchMapping
    @Transactional
    public @ResponseBody Person updateAnimal(@RequestBody Person person) {
        return this.personService.update(person);
    }

    @PostMapping
    public void saveAnimal(@RequestBody Person person) {
        personService.save(person);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleteAnimal(@PathVariable Integer id) {
        this.personService.delete(id);
    }
}
