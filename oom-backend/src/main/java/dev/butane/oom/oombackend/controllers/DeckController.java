package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.Deck;
import dev.butane.oom.oombackend.repositories.DeckRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class DeckController {

    private  final DeckRepository deckRepository;

    public DeckController(DeckRepository deckRepository) {
        this.deckRepository = deckRepository;
    }
    //Create a Deck
    @PutMapping("/decks")
    public void createDeck(@RequestBody Deck deck) {
        deckRepository.save(deck);
    }
    //Delete a Deck
    @DeleteMapping("/decks/{id}")
    public void deleteDeck(@PathVariable UUID id) { deckRepository.deleteById(id);}
    //Get all decks
    @GetMapping("/decks")
    public ArrayList<Deck> getDecks(){ return (ArrayList<Deck>) deckRepository.findAll(); }
    //Get deck by id
    @GetMapping("/decks/{id}")
    public Optional<Deck> getDeck(@PathVariable UUID id) { return deckRepository.findById(id);}
    //Update a deck
    @PutMapping("/decks/{id}")
    public void updateDeck(@PathVariable UUID id, @RequestBody Deck deck){ deckRepository.save(deck);}


}
