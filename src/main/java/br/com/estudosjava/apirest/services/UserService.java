package br.com.estudosjava.apirest.services;

import br.com.estudosjava.apirest.domain.User;

import java.util.List;

public interface UserService {

    User findById(Integer id);

    List<User> findAll();
}
