package dev.butane.oom.oombackend;

import dev.butane.oom.oombackend.models.*;
import dev.butane.oom.oombackend.repositories.DeckRepository;
import dev.butane.oom.oombackend.repositories.FlashcardRepository;
import dev.butane.oom.oombackend.repositories.TagRepository;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class OomBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OomBackendApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FlashcardRepository flashcardRepository, DeckRepository deckRepository, TagRepository tagRepository, UserRepository userRepository) {
		User u = new User("user", "justin", "gottfried", "justin@gottfried.com");
		User u1 = new User("user2", "jay", "G", "jayg@g.com");

		u = userRepository.save(u);
		u1 = userRepository.save(u1);

		Set<Tag> tags = new HashSet<>();
		tags.add(new Tag("test"));
		tags.add(new Tag("wololo"));

		Deck d = new Deck("test", "testinhalt", Visibility.PUBLIC, u, tags);

		d.getCollaborators().add(u1);

		for (int i = 0; i < 10; i++) {
			Flashcard f = new Flashcard("title " + i, "front " + i, "back " + i, d);
			d.getFlashcards().add(f);
		}

		deckRepository.save(d);

		return args -> {};
	}
}
