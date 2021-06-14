package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.Deck;
import dev.butane.oom.oombackend.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeckRepository extends CrudRepository<Deck, UUID> {
    @Query(
            "SELECT d FROM Deck d WHERE d.maintainer = ?1"
            + "OR ?1 MEMBER OF d.collaborators"
    )
    Optional<Deck[]> findAllDecksByUser(User user);
}
