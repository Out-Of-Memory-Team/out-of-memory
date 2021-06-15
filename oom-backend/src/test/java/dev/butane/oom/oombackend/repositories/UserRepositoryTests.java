package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.Role;
import dev.butane.oom.oombackend.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void repositoryShouldReturnAllUsers() {

        userRepository.save(new User(UUID.randomUUID(), "james123", "james@something.de", "James", "Sunderland", "pw123", true, true, true, true, Role.ADMIN));
        userRepository.save(new User(UUID.randomUUID(), "frank12", "frank@something.de", "Frank", "Mercury","pw111", true, true, true, true, Role.DEV));
        userRepository.save(new User(UUID.randomUUID(), "jay2", "jay@something.de", "Jay", "Z", "pw222", true, true, true, true, Role.USER));

        long numUsers = userRepository.count();

        assertEquals(3, numUsers);
    }
}
