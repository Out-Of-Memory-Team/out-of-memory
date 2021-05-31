package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.Deck;
import dev.butane.oom.oombackend.models.Flashcard;
import dev.butane.oom.oombackend.models.dto.FlashcardDTO;
import dev.butane.oom.oombackend.repositories.DeckRepository;
import dev.butane.oom.oombackend.repositories.FlashcardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class FlashcardController {

    private final FlashcardRepository flashcardRepository;
    private final DeckRepository deckRepository;

    public FlashcardController(FlashcardRepository flashcardRepository, DeckRepository deckRepository) {
        this.flashcardRepository = flashcardRepository;
        this.deckRepository = deckRepository;
    }

    // Get all cards TODO: By specific user
    @GetMapping("/cards")
    protected List<FlashcardDTO> getFlashcards() {
        return FlashcardDTO.map(flashcardRepository.findAll());
    }

    // Get card by Id TODO: By specific user
    @GetMapping("/cards/{id}")
    protected Optional<FlashcardDTO> getFlashcardById(@PathVariable UUID id) {
        return FlashcardDTO.map(flashcardRepository.findById(id));
    }

    // Create or Update a card TODO: of specific user
    @PutMapping("/cards")
    protected FlashcardDTO createOrUpdateFlashcard(@RequestBody FlashcardDTO card) {
        Deck deck = deckRepository.findById(card.getDeckId()).orElseThrow(RuntimeException::new);
        if(card.getIndex()==-1)
            card.setIndex(deck.getFlashcards().size());
        return FlashcardDTO.map(flashcardRepository.save(card.apply(deck)));
    }

    // Delete a card
    @DeleteMapping("/cards/{id}")
    protected void deleteFlashcard(@PathVariable UUID id) {
        flashcardRepository.deleteById(id);
    }
}
