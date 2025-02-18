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
            User u1 = new User(null, "Rafael Almeida", "rafaelalmeida@gmail.com", "Z20pEKt6");
            User u2 = new User(null, "Bruna Souza", "brunasouza@gmail.com", "8Ripa0kP");
            User u3 = new User(null, "João Carlos", "joãocarlos@gmail.com", "K8Er6wfL");
            User u4 = new User(null, "Cláudia Vieira", "cláudiavieira@gmail.com", "GKSWuU4V");
            User u5 = new User(null, "Renan Oliveira", "renanoliveira@gmail.com", "saFAklYT");
            User u6 = new User(null, "Patrícia Lima", "patrícialima@gmail.com", "rPKjzhwy");
            User u7 = new User(null, "Juliana Silva", "julianasilva@gmail.com", "kq9kig5k");
            User u8 = new User(null, "Rafael Almeida2", "rafaelalmeida2@gmail.com", "dg17zJSD");
            User u9 = new User(null, "Roberto Almeida", "robertoalmeida@gmail.com", "rE0pCiM6");
            User u10 = new User(null, "Rafael Costa", "rafaelcosta@gmail.com", "sBjJpOAE");

            userRepository.saveAll(List.of(u1, u2, u3, u4, u5, u6, u7, u8, u9, u10));
        };
    }

}
