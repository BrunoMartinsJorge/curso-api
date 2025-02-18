package br.com.estudosjava.apirest.services.Impl;

import br.com.estudosjava.apirest.domain.User;
import br.com.estudosjava.apirest.repositories.UserRepository;
import br.com.estudosjava.apirest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElse(null); // Assim ele retonara um valou ou um nulo;
    }
}
