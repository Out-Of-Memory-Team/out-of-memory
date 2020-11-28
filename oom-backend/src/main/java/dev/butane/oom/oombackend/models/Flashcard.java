package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "flashcard")
public class Flashcard {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name = "cardId")
    @NotNull
    private UUID cardId;

    @NotNull
    private final String title;

    @NotNull
    private final String front;

    @NotNull
    private final String back;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deckId")
    private Deck deck;

    public Flashcard(String title, String front, String back, Deck deck) {
        this.cardId = UUID.randomUUID();
        this.title = title;
        this.front = front;
        this.back = back;
        this.deck = deck;
    }

    public Flashcard() {
        this.title = "";
        this.front = "";
        this.back = "";
        this.deck = new Deck();
    }

    public UUID getCardId() {
        return cardId;
    }

    public String getTitle() {
        return title;
    }

    public String getFront() {
        return front;
    }

    public String getBack() {
        return back;
    }

    public String toString() {
        return "ID: " + cardId + ", Title: " + title + ", Front: " + front + ", Back: " + back + ", Deck: " + deck.getDeckId();
    }

}

