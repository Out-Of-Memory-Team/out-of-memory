package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "appuser")
public class User {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name = "userId")
    @NotNull
    private UUID userId;

    @NotNull
    private final String username;
    @NotNull
    private final String email;
    private final String firstName;
    private final String lastName;

    public User(String username, String firstName, String lastName, String email) {
        this.userId = UUID.randomUUID();
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

    public String toString() {
        return "ID: " + userId + ", Username: " + username + ", Firstname: " + firstName + ", Lastname: " + lastName + ", Email: " + email;
    }

}

