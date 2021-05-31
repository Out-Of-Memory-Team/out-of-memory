package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.Deck;
import dev.butane.oom.oombackend.repositories.DeckRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
public class DeckController {

    private  final DeckRepository deckRepository;

    public DeckController(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }

    // Get all decks
    @GetMapping("/decks")
    protected ArrayList<Deck> getDecks(){ return (ArrayList<Deck>) deckRepository.findAll(); }

    // Get deck by id
    @GetMapping("/decks/{id}")
    protected Optional<Deck> getDeck(@PathVariable UUID id) { return deckRepository.findById(id);}

    // Create or Update a Deck
    @PutMapping("/decks")
    protected Deck createOrUpdateDeck(@RequestBody Deck deck) {
        return deckRepository.save(deck);
    }

    // Delete a Deck
    @DeleteMapping("/decks/{id}")
    protected void deleteDeck(@PathVariable UUID id) { deckRepository.deleteById(id);}
}
