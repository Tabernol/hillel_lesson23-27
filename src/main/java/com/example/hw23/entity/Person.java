package com.example.hw23.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "persons")
public class Person {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name = "surname")
    private String surname;

    @OneToMany(mappedBy = "ownerId", cascade = CascadeType.ALL)
    private List<Animal> pet;
}
