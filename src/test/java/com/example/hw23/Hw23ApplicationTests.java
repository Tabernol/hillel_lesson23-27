package com.example.hw23;

import com.example.hw23.controller.AnimalController;
import com.example.hw23.controller.PersonController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Hw23ApplicationTests {
    @Autowired
    private AnimalController animalController;

    @Autowired
    private PersonController personController;

    @Test
    void contextLoads() {
        Assertions.assertNotNull(this.animalController);
        Assertions.assertNotNull(this.personController);
    }

}
