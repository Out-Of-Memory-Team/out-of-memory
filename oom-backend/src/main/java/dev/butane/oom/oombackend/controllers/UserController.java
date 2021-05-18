package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.User;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    // Get all users
    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    // Get user by Id
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable UUID id) {
        return userRepository.findById(id);
    }

    // Creates or Update an user
    @PutMapping("/users")
    public User createOrUpdateUser(@RequestBody User user) {
        return userRepository.save(user);
    }
    
    // Deletes user by Id
    @CrossOrigin(origins = "http://localhost:4200")
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id) { userRepository.deleteById(id); }

    // Get users by query
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/query/{keyword}")
    public Optional<List<String[]>> getUserByKeyword(@PathVariable String keyword) {
        return userRepository.findByKeyword(keyword, PageRequest.of(0,5));
    }

    // Get users by username
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/users/name/{name}")
    public Optional<User> getUserByUsername(@PathVariable String name) {
        return userRepository.findByUsername(name);
    }
}
