package com.example.UserClassroomCRUD.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "classroom")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Classroom {

    @Id
    @Column(name = "id", length = 4)
    private String id;

    @Column(name = "name", nullable = false, length = 40)
    private String name;

    @Column(name = "block", nullable = false, length = 5)
    private String block;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "number", nullable = false)
    private Integer number;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;
}


