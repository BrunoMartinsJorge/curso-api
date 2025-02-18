package br.com.estudosjava.apirest.services.Impl;

import br.com.estudosjava.apirest.domain.User;
import br.com.estudosjava.apirest.domain.dto.UserDTO;
import br.com.estudosjava.apirest.repositories.UserRepository;
import br.com.estudosjava.apirest.services.UserService;
import br.com.estudosjava.apirest.services.exceptions.ObjectNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findById(Integer id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!")); // Assim ele retonara um valou ou um nulo;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User create(UserDTO user) {
        return userRepository.save(modelMapper.map(user, User.class));
    }
}
