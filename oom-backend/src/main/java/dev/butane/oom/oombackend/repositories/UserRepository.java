package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CrudRepository<User, UUID> {
    Optional<User> findByUsername (String username);

    @Query(
            "SELECT u.username, CONCAT( u.firstName, ' ', u.lastName ) FROM User u WHERE u.username LIKE %?1%"
                    + "OR u.firstName LIKE %?1%"
                    + "OR u.firstName LIKE %?1%"
                    + "OR CONCAT(u.firstName, u.lastName) LIKE %?1%"
                    + "OR u.email LIKE %?1%"
    )
    Optional<List<String[]>> findByKeyword(String keyword, Pageable pageable);

    Optional<User> findByUsernameOrEmail(String username, String email);

}
