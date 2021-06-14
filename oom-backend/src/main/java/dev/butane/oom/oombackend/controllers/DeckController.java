package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.Deck;
import dev.butane.oom.oombackend.models.User;
import dev.butane.oom.oombackend.repositories.DeckRepository;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
public class DeckController {

    private final DeckRepository deckRepository;
    private final UserRepository userRepository;

    public DeckController(DeckRepository deckRepository, UserRepository userRepository) {
        this.deckRepository = deckRepository;
        this.userRepository = userRepository;
    }

    // Get all decks
    @GetMapping("/decks")
    public Optional<Deck[]> getDecks(Principal principal){
        return deckRepository.findAllDecksByUser(getCurrentUser(principal));
    }

    // Get deck by id
    @GetMapping("/decks/{id}")
    public Optional<Deck> getDeck(@PathVariable UUID id, Principal principal) {
        return deckRepository.findById(id);
    }

    // Create or Update a Deck
    @PutMapping("/decks")
    public Deck createOrUpdateDeck(@RequestBody Deck deck, Principal principal) {
        if(deck.getMaintainer() == this.getCurrentUser(principal) || deck.getCollaborators().contains(this.getCurrentUser(principal)))
            return deckRepository.save(deck);
        throw new RuntimeException();
    }

    // Delete a Deck
    @DeleteMapping("/decks/{id}")
    public void deleteDeck(@PathVariable UUID id, Principal principal) {
        deckRepository.deleteById(id);
    }

    private User getCurrentUser(Principal principal) {
        return userRepository.findById(UUID.fromString(principal.getName())).orElseThrow(RuntimeException::new);
    }
}
