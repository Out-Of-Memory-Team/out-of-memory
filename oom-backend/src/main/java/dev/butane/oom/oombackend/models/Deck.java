package dev.butane.oom.oombackend.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "deck")
public class Deck {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name = "deckId")
    @NotNull
    private UUID deckId;

    @NotNull
    private String title;

    @NotNull
    private String description;

    @NotNull
    private Visibility visibility;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "maintainer")
    private User maintainer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "collaborator",
        joinColumns = @JoinColumn(name = "deckId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> collaborators = new HashSet<User>();

    @OneToMany(mappedBy = "deck", cascade = {CascadeType.ALL})
    private List<Flashcard> flashcards = new ArrayList<Flashcard>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "decktags",
        joinColumns = @JoinColumn(name = "deckId"),
        inverseJoinColumns = @JoinColumn(name = "name")
    )
    private Set<Tag> tags = new HashSet<Tag>();

    public Deck(String title, String description, Visibility visibility, User maintainer, Set<Tag> tags) {
        this.deckId = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.visibility = visibility;
        this.maintainer = maintainer;
        this.tags = tags;
    }

    public Deck() {
        this.title = "";
        this.description = "";
        this.visibility = Visibility.PRIVATE;
        this.maintainer = new User();
        this.collaborators = null;
        this.flashcards = null;
    }
}
