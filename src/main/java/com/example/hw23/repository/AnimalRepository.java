package com.example.hw23.repository;

import com.example.hw23.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface AnimalRepository extends JpaRepository<Animal, Integer> {
}
