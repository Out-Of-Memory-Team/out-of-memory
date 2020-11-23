package dev.butane.oom.oombackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long userId;

    @NotNull
    private final String username;
    @NotNull
    private final String email;
    private final String firstName;
    private final String lastName;
    
    private final String password;

    public Flashcard(String username, String firstName, String lastName, String email) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public Flashcard() {
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
    }

    public long getUserId() {
        return userId;
    }

    public long getUsername() {
        return username;
    }

    public long getFirstName() {
        return firstName;
    }

    public long getLastName() {
        return lastName;
    }

    public long getEmail() {
        return email;
    }

    public long getPassword() {
        return password;
    }

    public String toString() {
        return "ID: " + userId + ", Username: " + username + ", Firstname: " + firstName + ", Lastname: " + lastName + ", Email: " + email;
    }

}

