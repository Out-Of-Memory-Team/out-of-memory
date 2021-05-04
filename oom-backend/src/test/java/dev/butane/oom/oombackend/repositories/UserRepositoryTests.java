package dev.butane.oom.oombackend.repositories;

import dev.butane.oom.oombackend.models.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
@Testcontainers
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTests {

    @Container
    static PostgreSQLContainer database = new PostgreSQLContainer("postgres:12").withDatabaseName("oom")
            .withPassword("password")
            .withUsername("Justin_Gottfried@hotmail.com");

    @DynamicPropertySource
    static void setDataSourceProperties(DynamicPropertyRegistry propertyRegistry) {
        propertyRegistry.add("spring.datasource.url", database::getJdbcUrl);
        propertyRegistry.add("spring.datasource.password", database::getPassword);
        propertyRegistry.add("spring.datasource.username", database::getUsername);
    }

    @Autowired
    private UserRepository userRepository;

    @Test
    public void repositoryShouldReturnAllUsers() {

        userRepository.save(new User(UUID.randomUUID(), "james123", "james@something.de", "James", "Sunderland"));
        userRepository.save(new User(UUID.randomUUID(), "frank12", "frank@something.de", "Frank", "Mercury"));
        userRepository.save(new User(UUID.randomUUID(), "jay2", "jay@something.de", "Jay", "Z"));

        long numUsers = userRepository.count();

        assertEquals(3, numUsers);
    }
}
