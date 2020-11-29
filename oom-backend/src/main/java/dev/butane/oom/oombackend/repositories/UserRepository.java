package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername (String username);
}