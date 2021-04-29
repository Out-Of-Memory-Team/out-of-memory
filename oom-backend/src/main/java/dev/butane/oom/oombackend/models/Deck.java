package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
