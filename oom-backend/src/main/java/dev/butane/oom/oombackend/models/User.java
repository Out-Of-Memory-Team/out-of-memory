package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

@Entity
public class User implements UserDetails {

    @Id
    @NotNull
    private String userId;

    @NotNull
    private String username;
    @NotNull
    private String email;
    private String firstName;
    private String lastName;

    private String password;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;

    /*@Enumerated(EnumType.STRING)
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Role> roles;*/

    public User(String username, String firstName, String lastName, String email) {
        this.userId = UUID.randomUUID().toString();
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public User() {
        this.userId = UUID.randomUUID().toString();
        this.username = "";
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.accountNonExpired = true;
        this.accountNonLocked = true;
        this.credentialsNonExpired = true;
        this.enabled = true;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    /*public void grantAuthority(Role authority) {
        if ( roles == null ) roles = new ArrayList<>();
        roles.add(authority);
    }*/

    @Override
    public List<GrantedAuthority> getAuthorities(){
        /*List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority(role.toString())));
        return authorities;*/
        return null;
    }

    public String toString() {
        return "ID: " + userId + ", Username: " + username + ", Firstname: " + firstName + ", Lastname: " + lastName + ", Email: " + email;
    }

}

