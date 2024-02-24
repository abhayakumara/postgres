package com.postgres.datastore.service;

import com.postgres.datastore.model.User;
import com.postgres.datastore.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).stream().findFirst().orElse(null);
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email).stream().findFirst().orElse(null);
    }
}
