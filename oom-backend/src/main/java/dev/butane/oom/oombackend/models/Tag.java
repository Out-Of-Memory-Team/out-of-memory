package dev.butane.oom.oombackend.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "tag")
public class Tag {
    @Id
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {

    }

}
