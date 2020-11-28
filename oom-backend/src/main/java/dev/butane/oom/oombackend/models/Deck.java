package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

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
    @ManyToOne
    @JoinColumn(name = "maintainer")
    private User maintainer;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "collaborator",
        joinColumns = @JoinColumn(name = "deckId"),
        inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> collaborators = new HashSet<User>();
    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL)
    private List<Flashcard> flashcards = new ArrayList<Flashcard>();
    @ManyToMany(mappedBy = "decks", fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Tag> tags = new HashSet<Tag>();

    public Deck(String title, String description, Visibility visibility, User maintainer) {
        this.deckId = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.visibility = visibility;
        this.maintainer = maintainer;
    }

    public Deck() {
        this.title = "";
        this.description = "";
        this.visibility = Visibility.PRIVATE;
        this.maintainer = new User();
        this.collaborators = null;
        this.flashcards = null;
        this.tags = null;
    }

    //Getter
    public UUID getDeckId() { return deckId; }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public Visibility isVisibility() { return visibility; }

    public User getMaintainer() { return maintainer; }

    public Set<User> getCollaborators() { return collaborators; }

    public Set<Tag> getTags() { return tags; }

    public List<Flashcard> getFlashcards() { return flashcards; }

    //Setter
    public void setTitle(String title) { this.title = title; }

    public void setDescription(String description) { this.description = description; }

    public void setVisibility(Visibility visibility) { this.visibility = visibility; }

    public void setMaintainer(User maintainer) { this.maintainer = maintainer; }

    public void setCollaborators(Set<User> collaborators) { this.collaborators = collaborators; }

    public void setTags(Set<Tag> tags) { this.tags = tags; }

    public void setFlashcards(List<Flashcard> flashcards) { this.flashcards = flashcards; }

    @Override
    public String toString() {
        return "Deck{" +
                "deckId=" + deckId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", visibility=" + visibility +
                ", maintainer='" + maintainer + '\'' +
                ", collaborators=" + collaborators +
                ", flashcards=" + flashcards +
                ", tags=" + tags +
                '}';
    }
}
