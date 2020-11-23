package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
public class Deck {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private UUID deckId;
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private Visibility visibility;
    private String maintainer;

    @OneToMany //1:n
    private List<User> collaborators;
    @OneToMany
    private List<Flashcard> flashcards;
    @OneToMany
    private List<Tag> tags;

    public Deck(String title, String description, Visibility visibility, String maintainer, List<User> collaborators, List<Flashcard> flashcards, List<Tag> tags) {
        this.deckId = UUID.randomUUID();
        this.title = title;
        this.description = description;
        this.visibility = visibility;
        this.maintainer = maintainer;
        this.collaborators = collaborators;
        this.flashcards = flashcards;
        this.tags = tags;
    }

    public Deck() {
        this.title = "";
        this.description = "";
        this.visibility = Visibility.PRIVATE;
        this.maintainer = "";
        this.collaborators = null;
        this.flashcards = null;
        this.tags = null;
    }

    //Getter
    public UUID getDeckId() { return deckId; }

    public String getTitle() { return title; }

    public String getDescription() { return description; }

    public Visibility isVisibility() { return visibility; }

    public String getMaintainer() { return maintainer; }

    public List<User> getCollaborators() { return collaborators; }

    public List<Tag> getTags() { return tags; }

    public List<Flashcard> getFlashcards() { return flashcards; }

    //Setter
    public void setTitle(String title) { this.title = title; }

    public void setDescription(String description) { this.description = description; }

    public void setVisibility(Visibility visibility) { this.visibility = visibility; }

    public void setMaintainer(String maintainer) { this.maintainer = maintainer; }

    public void setCollaborators(List<User> collaborators) { this.collaborators = collaborators; }

    public void setTags(List<Tag> tags) { this.tags = tags; }

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
