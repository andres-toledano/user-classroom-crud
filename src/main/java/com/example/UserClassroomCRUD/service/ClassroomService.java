package com.example.UserClassroomCRUD.service;


import com.example.UserClassroomCRUD.model.Classroom;
import com.example.UserClassroomCRUD.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    @Autowired
    public ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    // Obtener todos los classrooms
    public List<Classroom> getAllClassrooms() {
        List<Classroom> classrooms = classroomRepository.findAll();
        System.out.println("Aulas encontradas: " + classrooms.size());
        for (Classroom classroom : classrooms) {
            System.out.println("Aula: " + classroom.getName());
        }
        return classrooms;
    }

    // Obtener classroom por ID
    public Optional<Classroom> getClassroomById(String id) {
        return classroomRepository.findById(id);
    }

    // Crear o actualizar classroom
    public Classroom saveClassroom(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    // Eliminar classroom
    public void deleteClassroom(String id) {
        classroomRepository.deleteById(id);
    }
}


