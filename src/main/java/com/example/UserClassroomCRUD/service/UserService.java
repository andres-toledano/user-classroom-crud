package com.example.UserClassroomCRUD.service;


import com.example.UserClassroomCRUD.model.User;
import com.example.UserClassroomCRUD.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Obtener usuario por ID
    public Optional<User> getUserById(Integer id) {
        return userRepository.findById(id);
    }

    // Obtener usuario por UID
    public Optional<User> getUserByUid(String uid) {
        return userRepository.findByUid(uid);
    }


    // Crear o actualizar un usuario
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Eliminar un usuario
    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}

