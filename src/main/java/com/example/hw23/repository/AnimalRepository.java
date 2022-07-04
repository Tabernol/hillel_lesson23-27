package com.example.hw23.repository;

import com.example.hw23.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface AnimalRepository extends CrudRepository<Animal, Integer> {
}
