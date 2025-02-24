package br.com.estudosjava.apirest.resources;

import br.com.estudosjava.apirest.domain.User;
import br.com.estudosjava.apirest.domain.dto.UserDTO;
import br.com.estudosjava.apirest.services.Impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserResourcesTest {

    public static final Integer ID = 1;
    public static final String NOME = "Teste";
    public static final String EMAIL = "Teste@gmail.com";
    public static final String SENHA = "12345678";
    public static final int INDEX = 0;
    private User user;
    private UserDTO userDTO;

    @InjectMocks
    private UserResources resources;

    @Mock
    private UserServiceImpl service;

    @Mock
    private ModelMapper mapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }
    private void startUser() {
        user = new User(ID, NOME, EMAIL, SENHA);
        userDTO = new UserDTO(ID, NOME, EMAIL, SENHA);
    }
}