package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.Flashcard;
import dev.butane.oom.oombackend.repositories.FlashcardRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class FlashcardController {

    private final FlashcardRepository flashcardRepository;

    public FlashcardController(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    // Get all cards TODO: By specific user
    @GetMapping("/cards")
    public List<Flashcard> getFlashcards() {
        return (List<Flashcard>) flashcardRepository.findAll();
    }

    // Get card by Id TODO: By specific user
    @GetMapping("/cards/{id}")
    public Optional<Flashcard> getFlashcardById(@PathVariable UUID id) {
        return flashcardRepository.findById(id);
    }

    // Create or Update a card TODO: of specific user
    @PutMapping("/cards")
    public Flashcard createorUpdateFlashcard(@RequestBody Flashcard card) {
        return flashcardRepository.save(card);
    }

    // Delete a card
    @DeleteMapping("/cards/{id}")
    public void deleteFlashcard(@PathVariable UUID id) {
        flashcardRepository.deleteById(id);
    }
}
