package com.example.hw23.service;

import com.example.hw23.entity.Animal;
import com.example.hw23.entity.Person;
import com.example.hw23.repository.AnimalRepository;
import org.aspectj.lang.annotation.Before;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.*;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



class AnimalServiceTest {
    @InjectMocks
    private final SessionFactory mockFactory = Mockito.mock(SessionFactory.class);
//    private final Session mockSession = Mockito.mock(Session.class);
//    private final Transaction mockTransaction = Mockito.mock(Transaction.class);

    private final AnimalService animalService = new AnimalService(this.mockFactory);

//    @Before("")
//    public void setUp() {
////        factory =  Mockito.mock(SessionFactory.class);
////        mockedSession = Mockito.mock(Session.class);
////        mockedTransaction = Mockito.mock(Transaction.class);
//        Mockito.when(mockFactory.openSession()).thenReturn(mockSession);
//        Mockito.when(mockSession.beginTransaction()).thenReturn(mockTransaction);
//        //loginDAO.setSessionFactory(this.mockedSessionFactory);
//    }

    @Test
    void saveAnimal() {
        Animal horse = Animal.builder().animalId(100).name("horse").ownerId(1).build();
        Animal sheep = Animal.builder().animalId(200).name("sheep").ownerId(2).build();
        Mockito.when(this.mockFactory.unwrap(Session.class).save(Mockito.any())).thenReturn((Serializable) horse);

        Assertions.assertEquals(horse, animalService.saveAnimal(sheep));
        Mockito.verify(this.mockFactory).unwrap(Session.class).save(sheep);
    }

//    @Test
//    void getAnimal() {
//        Animal horse = Animal.builder().animalId(100).name("horse").ownerId(1).build();
//        Mockito
//                .when(this.animalRepository.findById(Mockito.anyInt()))
//                .thenReturn(Optional.of(horse));
//
//        Assertions.assertEquals(horse, animalService.getAnimal(Mockito.anyInt()));
//        Mockito.verify(this.animalRepository).findById(Mockito.anyInt());
//    }
//
//    @Test
//    void updateAnimal() {
//        Animal horse = Animal.builder().animalId(100).name("horse").ownerId(1).build();
//        Animal sheep = Animal.builder().animalId(200).name("sheep").ownerId(2).build();
//
//        Mockito
//                .when(this.animalRepository.save(Mockito.any()))
//                .thenReturn(horse);
//
//        Assertions.assertEquals(horse, this.animalService.updateAnimal(sheep));
//        Mockito.verify(this.animalRepository).save(sheep);
//    }
//
//    @Test
//    void getAllAnimals() {
//        Animal horse = Animal.builder().animalId(100).name("horse").ownerId(1).build();
//        Animal sheep = Animal.builder().animalId(200).name("sheep").ownerId(2).build();
//        Animal rabbit = Animal.builder().animalId(300).name("rabbit").ownerId(1).build();
//        List<Animal> animals = new ArrayList<>();
//        animals.add(horse);
//        animals.add(sheep);
//        animals.add(rabbit);
//
//        Mockito.when(this.animalRepository.findAll()).thenReturn(animals);
//
//        Assertions.assertEquals(animals, animalService.getAllAnimals());
//        Mockito.verify(this.animalRepository).findAll();
//    }
//
//    @Test
//    void deleteAnimal() {
//        Animal horse = Animal.builder().animalId(100).name("horse").ownerId(1).build();
//        animalService.deleteAnimal(horse.getAnimalId());
//        Mockito.verify(this.animalRepository).deleteById(Mockito.anyInt());
//    }
}