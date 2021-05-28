package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.Deck;
import dev.butane.oom.oombackend.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface DeckRepository extends CrudRepository<Deck, UUID> {
    Optional<Deck[]> findAllByMaintainer_UserId(UUID maint);
    Optional<Deck> findByDeckIdAndMaintainerOrCollaboratorsContains(UUID id, User maint, User collab);
    Optional<Deck> deleteByDeckIdAndMaintainer(UUID id, User user);
}
