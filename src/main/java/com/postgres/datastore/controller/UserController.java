package com.postgres.datastore.controller;

import com.postgres.datastore.model.User;
import com.postgres.datastore.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/users/{id}")
    public User findUser(@PathVariable Integer id) {
        return userService.getUser(id);
    }

    @GetMapping("/users")
    public List<User> findAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{username}")
    public User findUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping("users/{email}")
    public User findUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }
}
