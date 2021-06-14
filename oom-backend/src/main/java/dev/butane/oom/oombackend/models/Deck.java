package dev.butane.oom.oombackend.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="deckId")
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

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "maintainer")
    private User maintainer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinTable(name = "collaborator",
        joinColumns = @JoinColumn(name = "deckId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> collaborators = new HashSet<User>();

    @OneToMany(mappedBy = "deck", cascade = {CascadeType.ALL})
    @OrderBy("index ASC")
    private List<Flashcard> flashcards = new ArrayList<Flashcard>();

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "decktags",
        joinColumns = @JoinColumn(name = "deckId"),
        inverseJoinColumns = @JoinColumn(name = "name")
    )
    private Set<Tag> tags = new HashSet<Tag>();
}
