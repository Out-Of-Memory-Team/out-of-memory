package dev.butane.oom.oombackend;

import dev.butane.oom.oombackend.models.User;
import dev.butane.oom.oombackend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class DemoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        User user = new User();
        user.setUsername("leonhard");
        user.setPassword(passwordEncoder.encode("leonhard"));

        userRepository.save(user);
    }
}