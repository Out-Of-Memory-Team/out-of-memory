package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.User;
import dev.butane.oom.oombackend.models.dto.UserDTO;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@CrossOrigin()
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

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
    @GetMapping("/users/{id}")
    public Optional<User> getUser(@PathVariable UUID id) {
        return userRepository.findById(id);
    }

    // Get user by username
    @GetMapping("/users/name/{username}")
    public Optional<User> getUserbyUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    // Get current user
    @GetMapping("/user")
    public Optional<User> getCurrentUser(Principal principal) {
        return userRepository.findById(UUID.fromString(principal.getName()));
    }

    // Creates or Update an user
    @PutMapping("/users")
    public User createOrUpdateUser(@RequestBody UserDTO user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(UserDTO.map(user));
    }
    
    // Deletes user by Id
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id) { userRepository.deleteById(id); }
}
