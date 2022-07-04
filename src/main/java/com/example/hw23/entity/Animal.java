package com.example.hw23.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "animals")
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @Column(name = "id")
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "owner_id")
    private int ownerId;

//    @ManyToOne
//    @JoinColumn(name = "owner_id", nullable = false)
//    private Person ownerId;
}
