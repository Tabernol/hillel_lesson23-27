package com.example.hw23.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @Column(name = "id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int animalId;

    @Column(name = "name")
    private String name;

    @Column(name = "owner_id")
    private int ownerId;
}
