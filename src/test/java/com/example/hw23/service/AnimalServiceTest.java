package com.example.hw23.service;

import com.example.hw23.entity.Animal;
import com.example.hw23.repository.AnimalRepository;
import com.example.hw23.repository.AnimalRepositoryImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class AnimalServiceTest {
//
//    //    private final AnimalRepositoryI animalRepository = Mockito.mock(AnimalRepository.class);
////
////    private final AnimalRepository spy = Mockito.spy(animalRepository);
//    @Autowired
//   // private AnimalRepositoryImpl animalRepository;
//    private final AnimalService animalServ = new AnimalService(new AnimalRepositoryImpl());
//
//    @Test
//    public void saveAnimalTest() {
//        Animal animal = new Animal(1, "mouse", 2);
//        assertEquals("mouse", animalServ.save(animal).getName());
//    }
//
//
////    @Test
////    void get() {
////        Animal animal = new Animal(1, "sheep", 2);
////        assertEquals(animal, animalService.get(1));
////
////    }
}