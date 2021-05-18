package dev.butane.oom.oombackend.models.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;
import dev.butane.oom.oombackend.models.Deck;
import dev.butane.oom.oombackend.models.Flashcard;
import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FlashcardDTO {

    private UUID cardId;
    private String front;
    private String back;
    private UUID deckId;
    private int index;

    public static FlashcardDTO map(Flashcard card) {
        if(card == null)
            return null;
        return new FlashcardDTO(card.getCardId(), card.getFront(), card.getBack(), card.getDeck().getDeckId(), card.getIndex());
    }

    public Flashcard apply(Deck deck) {
        return new Flashcard(getCardId(), getFront(), getBack(), deck, index);
    }

    public static List<FlashcardDTO> map(Iterable<Flashcard> cards) {
        return StreamSupport.stream(cards.spliterator(), false).map(FlashcardDTO::map).collect(Collectors.toList());
    }

    public static Optional<FlashcardDTO> map(Optional<Flashcard> card) {
        return Optional.ofNullable(FlashcardDTO.map(card.get()));
    }
}
