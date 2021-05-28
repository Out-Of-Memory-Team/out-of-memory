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
        return deckRepository.findAllByMaintainer_UserId(UUID.fromString(principal.getName()));
    }

    // Get deck by id
    @GetMapping("/decks/{id}")
    public Optional<Deck> getDeck(@PathVariable UUID id, Principal principal) {
        User user = userRepository.findById(UUID.fromString(principal.getName())).orElseThrow(RuntimeException::new);
        return deckRepository.findByDeckIdAndMaintainerOrCollaboratorsContains(id, user, new User());
    }

    // Create or Update a Deck
    @PutMapping("/decks")
    public Deck createOrUpdateDeck(@RequestBody Deck deck, Principal principal) {
        //if(deck.getDeckId() == UUID.fromString(principal.getName()))
            return deckRepository.save(deck);
        //throw new RuntimeException();
    }

    // Delete a Deck
    @DeleteMapping("/decks/{id}")
    public void deleteDeck(@PathVariable UUID id, Principal principal) {
        User user = userRepository.findById(UUID.fromString(principal.getName())).orElseThrow(RuntimeException::new);
        deckRepository.deleteByDeckIdAndMaintainer(id, user);
    }
}
