package br.com.estudosjava.apirest.resources;

import br.com.estudosjava.apirest.domain.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/user")
public class UserResources {

    @GetMapping(value ="/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id){
        User user = new User(1, "Bruno", "teste@gmail.com", "12345678");
        System.out.println("Usuario encontrado: " + user.getEmail());
        return ResponseEntity.ok().body(user);
    }
}
