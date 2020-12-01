package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.User;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.http.HttpStatus;
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

    // Create an user
    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    // Reads user by Id
    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable UUID id) {
        return userRepository.findById(id);
    }

    // Update an user
    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@RequestBody User user) {
        userRepository.save(user);
    }
    
    // Deletes user by Id
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id) { userRepository.deleteById(id); }
}
