package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.Flashcard;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlashcardRepository extends CrudRepository<Flashcard, Long> { }
