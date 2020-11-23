package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @NotNull
    private final String username;
    @NotNull
    private final String email;
    private final String firstName;
    private final String lastName;

    public User(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String toString() {
        return "ID: " + userId + ", Username: " + username + ", Firstname: " + firstName + ", Lastname: " + lastName + ", Email: " + email;
    }

}

