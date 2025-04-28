package com.example.UserClassroomCRUD.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Aquí se especifica el auto incremento
    @Column(name = "id")
    private Integer id;

    @Column(name = "uid", unique = true, nullable = false, length = 120)
    private String uid;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "degree", nullable = false, length = 20)
    private String degree;

    @Column(name = "school_number", unique = true, nullable = false, length = 6)
    private String schoolNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private RoleEnum role;

}

