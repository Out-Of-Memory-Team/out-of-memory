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
}
