package dev.butane.oom.oombackend.models;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "flashcard")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property="deckId")
public class Flashcard {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "pg-uuid")
    @Column(name = "cardId")
    @NotNull
    private UUID cardId;

    @NotNull
    private String front;

    @NotNull
    private String back;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @JoinColumn(name = "deckId")
    @JsonProperty("deckId")
    private Deck deck;

    @NotNull
    private int index;
}

