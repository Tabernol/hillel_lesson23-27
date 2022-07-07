package com.example.hw23.service;


import com.example.hw23.entity.Animal;
import com.example.hw23.entity.Person;
import com.example.hw23.repository.AnimalRepository;
import com.example.hw23.repository.PersonRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;
import java.util.function.BooleanSupplier;

class AnimalServiceTest {
    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
    private final AnimalRepository animalRepository = Mockito.mock(AnimalRepository.class);
   // private final PersonService personService = new PersonService(this.personRepository);
    private final AnimalService animalService = new AnimalService(this.animalRepository); //, this.personService);


    @Test
    void getAnimal() {
        Animal elephant = Animal.builder().animalId(9).name("Elephant").ownerId(1).build();
        Mockito
                .when(this.animalRepository.findById(Mockito.anyInt()))
                .thenReturn(Optional.of(elephant));

        Assertions.assertEquals(elephant, this.animalService.getAnimal(Mockito.anyInt()));
    }

    @Test
    void getAllAnimals() {
    }

    @Test
    void saveAnimal() {
        Animal elephant = Animal.builder().animalId(9).name("Elephant").ownerId(1).build();
        Mockito
                .when(this.animalRepository.save(Mockito.any()))
                .thenReturn(elephant);

        Assertions.assertEquals(elephant, this.animalService.saveAnimal(elephant));
    }

    @Test
    void deleteAnimal() {
        Animal elephant = Animal.builder().animalId(9).name("Elephant").ownerId(1).build();

        this.animalService.deleteAnimal(elephant.getAnimalId());

        Mockito.verify(this.animalRepository).deleteById(Mockito.anyInt());
    }

    @Test
    void updateAnimal() {
        Animal elephant = Animal.builder().animalId(9).name("Elephant").ownerId(1).build();
        Animal turtle = Animal.builder().animalId(9).name("Turtle").ownerId(23).build();

        Mockito
                .when(this.animalRepository.save(Mockito.any()))
                .thenReturn(turtle);

        Assertions.assertEquals(elephant, animalService.updateAnimal(elephant));
        // Mockito.verify(this.animalRepository).save(elephant);
    }
}