package dev.butane.oom.oombackend.models;

import com.sun.istack.NotNull;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@Entity
public class Flashcard {

    // TODO: Instead of cardId, use UUID
    @Id
    @NotNull
    private String cardId;

    @NotNull
    private final String title;

    @NotNull
    private final String front;

    @NotNull
    private final String back;

// TODO: Flashcard can be into a specific deck. So here we need a variable of type "Deck"
// TODO: Who is the Maintainer + Collaboratos + Tags etc.

    public Flashcard(String title, String front, String back) {
        this.cardId = UUID.randomUUID().toString();
        this.title = title;
        this.front = front;
        this.back = back;
    }

    public Flashcard() {
        this.title = "";
        this.front = "";
        this.back = "";
    }

    public String getCardId() {
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
        return "ID: " + cardId + ", Title: " + title + ", Front: " + front + ", Back: " + back;
    }

}

