//package com.example.hw23.service;
//
//import com.example.hw23.entity.Person;
//import com.example.hw23.repository.PersonRepository;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mockito;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//class PersonServiceTest {
//    private final PersonRepository personRepository = Mockito.mock(PersonRepository.class);
//    private final PersonService personService = new PersonService(this.personRepository);
//
//    @Test
//    void getPerson() {
//        Person smith = Person.builder().personId(2).surname("Smith").build();
//
//        Mockito
//                .when(this.personRepository.findById(Mockito.anyInt()))
//                .thenReturn(Optional.of(smith));
//
//        Assertions.assertEquals(smith, personService.getPerson(Mockito.anyInt()));
//        Mockito.verify(this.personRepository).findById(Mockito.anyInt());
//    }
//
//    @Test
//    void getAllPersons() {
//        Person Smith = Person.builder().personId(1).surname("Smith").build();
//        Person John = Person.builder().personId(2).surname("John").build();
//        Person Grey = Person.builder().personId(3).surname("Grey").build();
//        List<Person> persons = new ArrayList<>();
//        persons.add(Smith);
//        persons.add(John);
//        persons.add(Grey);
//
//        Mockito
//                .when(this.personRepository.findAll())
//                .thenReturn(persons);
//        Assertions.assertEquals(persons, personService.getAllPersons());
//        Mockito.verify(this.personRepository).findAll();
//    }
//
//    @Test
//    void savePerson() {
//        Person smith = Person.builder().personId(2).surname("Smith").build();
//        Person john = Person.builder().personId(1).surname("john").build();
//
//        Mockito
//                .when(this.personRepository.save(Mockito.any()))
//                .thenReturn(smith);
//
//        Assertions.assertEquals(smith, personService.savePerson(john));
//        Mockito.verify(this.personRepository).save(john);
//    }
//
//    @Test
//    void deletePerson() {
//        Person smith = Person.builder().personId(2).surname("Smith").build();
//        personService.deletePerson(smith.getPersonId());
//        Mockito.verify(this.personRepository).deleteById(Mockito.anyInt());
//    }
//
//    @Test
//    void updatePerson() {
//        Person smith = Person.builder().personId(2).surname("Smith").build();
//        Person john = Person.builder().personId(1).surname("john").build();
//
//        Mockito
//                .when(this.personRepository.save(Mockito.any()))
//                .thenReturn(smith);
//
//        Assertions.assertEquals(smith, this.personService.updatePerson(john));
//        Mockito.verify(this.personRepository).save(john);
//    }
//}