package br.com.estudosjava.apirest.services;

import br.com.estudosjava.apirest.domain.User;
import br.com.estudosjava.apirest.domain.dto.UserDTO;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();

    User create(UserDTO user);

    User update(UserDTO user);

    void delete(Integer id);
}
