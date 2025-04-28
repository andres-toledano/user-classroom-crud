package com.example.UserClassroomCRUD.repository;


import com.example.UserClassroomCRUD.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, String> {
}
