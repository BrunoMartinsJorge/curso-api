package br.com.estudosjava.apirest.config;

import br.com.estudosjava.apirest.domain.User;
import br.com.estudosjava.apirest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public CommandLineRunner startDB() {
        return args -> {
            User u1 = new User(null, "Teste", "Teste@gmail.com", "12345678");
            User u2 = new User(null, "Teste2", "Teste2@gmail.com", "12345678");
            userRepository.saveAll(List.of(u1, u2));
        };
    }

}
