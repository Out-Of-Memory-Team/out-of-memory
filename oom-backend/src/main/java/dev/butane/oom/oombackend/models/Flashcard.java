package dev.butane.oom.oombackend.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Flashcard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cardId;

    private final String title;

    private final String front;

    private final String back;

// TODO: Flashcard can be into a specific deck. So here we need a variable of type "Deck"
// TODO: Who is the Maintainer + Collaboratos + Tags etc.

    public Flashcard(String title, String front, String back) {
        this.title = title;
        this.front = front;
        this.back = back;
    }

    public Flashcard() {
        this.title = "";
        this.front = "";
        this.back = "";
    }

    public long getCardId() {
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

