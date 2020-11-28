package dev.butane.oom.oombackend.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "decktags",
            joinColumns = @JoinColumn(name = "name"),
            inverseJoinColumns = @JoinColumn(name = "deckId")
    )
    private Set<Deck> decks = new HashSet<Deck>();

    public Tag(String name) {
        this.name = name;
    }

    public Tag() {

    }

    public String getTag() {
        return name;
    }

    public Set<Deck> getDecks() { return decks; }

    public void setTag(String tag) {
        this.name = name;
    }
}
