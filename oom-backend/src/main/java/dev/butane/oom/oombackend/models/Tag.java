package dev.butane.oom.oombackend.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Tag {
    @Id
    private String name;

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {

    }

    public String getTag() {
        return name;
    }

    public void setTag(String tag) {
        this.name = name;
    }
}
