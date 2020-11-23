package dev.butane.oom.oombackend.controllers;

import dev.butane.oom.oombackend.models.Flashcard;
import dev.butane.oom.oombackend.repositories.FlashcardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class FlashcardController {

    @Autowired
    private final FlashcardRepository flashcardRepository;

    public FlashcardController(FlashcardRepository flashcardRepository) {
        this.flashcardRepository = flashcardRepository;
    }

    // Reads all cards TODO: By specific user
    @GetMapping("/cards")
    public List<Flashcard> getFlashcards() {
        return (List<Flashcard>) flashcardRepository.findAll();
    }

    // Read card by Id TODO: By specific user
    @GetMapping("/cards/{id}")
    public Optional<Flashcard> getFlashcardById(@PathVariable long id) {
        return flashcardRepository.findById(id);
    }

    // Create a card TODO: of specific user
    @PostMapping("/cards")
    public void createFlashcard(@RequestBody Flashcard card) {
        flashcardRepository.save(card);
    }

    // Update a card TODO: of specific user
    @PutMapping("/cards/{id}")
    public void updateFlashcard(@RequestBody Flashcard card) {
        flashcardRepository.save(card);
    }
}
