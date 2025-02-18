package br.com.estudosjava.apirest.services;

import br.com.estudosjava.apirest.domain.User;

public interface UserService {

    User findById(Integer id);
}
