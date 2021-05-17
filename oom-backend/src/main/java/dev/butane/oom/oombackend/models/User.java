package dev.butane.oom.oombackend.models;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import com.sun.istack.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.*;

public interface User extends UserDetails {

    @Override
    public boolean isEnabled();

    @Override
    public List<GrantedAuthority> getAuthorities();

}

