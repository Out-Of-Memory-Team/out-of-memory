package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.User;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Create an user
    @PostMapping("/users")
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }

    // Reads user by Id
    @GetMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        return flashcardRepository.findById(id);
    }

    // Update an user
    @PutMapping("/users/{id}")
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    // Deletes user by Id
    @DeleteMapping("/users/{id}")
    public User getUser(@PathVariable long id) {
        flashcardRepository.deleteById(id);
    }
}
