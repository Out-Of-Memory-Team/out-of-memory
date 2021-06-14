package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.Role;
import dev.butane.oom.oombackend.models.User;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    @GetMapping("/users")
    protected List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }

    // Get user by Id
    @GetMapping("/users/{id}")
    protected Optional<User> getUser(@PathVariable UUID id) {
        return userRepository.findById(id);
    }

    // Get user by username
    @GetMapping("/users/name/{username}")
    protected Optional<User> getUserbyUsername(@PathVariable String username) {
        return userRepository.findByUsername(username);
    }

    // Get current user
    @GetMapping("/user")
    protected Optional<User> getCurrentUser(Principal principal) {
        return userRepository.findById(UUID.fromString(principal.getName()));
    }

    // Update an user
    @PutMapping("/users")
    public User createOrUpdateUser(@RequestBody User user, Principal principal) {
        if(user.getUserId() == UUID.fromString(principal.getName())) {
            return userRepository.save(user);
        }
        return null;
    }
    
    // Deletes user by Id
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable UUID id, Principal principal) {
        userRepository.deleteById(UUID.fromString(principal.getName()));
    }

    // Get users by query
    @GetMapping("/users/query/{keyword}")
    protected Optional<List<String[]>> getUserByKeyword(@PathVariable String keyword) {
        return userRepository.findByKeyword(keyword, PageRequest.of(0,5));
    }

    // Creates an user
    @PutMapping("/register")
    public User register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        if(user.getUserId()==null) {
            return userRepository.save(user);
        }
        return null;
    }
}
