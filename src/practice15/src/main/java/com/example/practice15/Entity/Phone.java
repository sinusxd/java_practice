package com.example.practice15.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "creation_year")
    String creationYear;

    public String getName() {
        return name;
    }

    public String getCreationYear() {
        return creationYear;
    }
}
