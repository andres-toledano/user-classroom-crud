package com.example.UserClassroomCRUD.controller;


import com.example.UserClassroomCRUD.model.Classroom;
import com.example.UserClassroomCRUD.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/classroom")
public class ClassroomController {

    private final ClassroomService classroomService;

    @Autowired
    public ClassroomController(ClassroomService classroomService) {
        this.classroomService = classroomService;
    }

    // Obtener todas las aulas
    @GetMapping
    public List<Classroom> getAllClassrooms() {
        return classroomService.getAllClassrooms();
    }

    // Obtener aula por ID
    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getClassroomById(@PathVariable String id) {
        Optional<Classroom> classroom = classroomService.getClassroomById(id);
        return classroom.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    // Crear aula
    @PostMapping
    public ResponseEntity<Classroom> createClassroom(@RequestBody Classroom classroom) {
        Classroom savedClassroom = classroomService.saveClassroom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedClassroom);
    }

    // Actualizar aula
    @PutMapping("/{id}")
    public ResponseEntity<Classroom> updateClassroom(@PathVariable String id, @RequestBody Classroom classroom) {
        if (classroomService.getClassroomById(id).isPresent()) {
            classroom.setId(id);
            Classroom updatedClassroom = classroomService.saveClassroom(classroom);
            return ResponseEntity.ok(updatedClassroom);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    // Eliminar aula
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteClassroom(@PathVariable String id) {
        if (classroomService.getClassroomById(id).isPresent()) {
            classroomService.deleteClassroom(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

