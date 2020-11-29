package dev.butane.oom.oombackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class OomBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(OomBackendApplication.class, args);
	}

}
