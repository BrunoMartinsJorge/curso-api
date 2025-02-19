package br.com.estudosjava.apirest.services.Impl;

import br.com.estudosjava.apirest.domain.User;
import br.com.estudosjava.apirest.domain.dto.UserDTO;
import br.com.estudosjava.apirest.repositories.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NOME = "Teste";
    public static final String EMAIL = "Teste@gmail.com";
    public static final String SENHA = "12345678";
    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDTO userDTO;
    private Optional<User> userOptional;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void quandoBuscarPorIdRetorneUmaInstanciaDeUser() {
        // Quando o findById for chamado e passado-se um número inteiro, deve-se retornar um optional de User.
        Mockito.when(repository.findById(Mockito.anyInt())).thenReturn(userOptional);

        User response = service.findById(ID);

        // Aqui está sendo verificado se o valor sejá nulo.
        Assertions.assertNotNull(response);

        // Depois de verificar se o objeto não é nulo, assim então é liberado para validar as demais validações.

        // Aqui está sendo realizada uma verificação para que sempre seja retornado um User.
        Assertions.assertEquals(User.class, response.getClass());

        // Aqui está sendo realizada uma verificação para que sempre seja um Id.
        Assertions.assertEquals(ID, response.getId());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
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
        userOptional = Optional.of(new User(ID, NOME, EMAIL, SENHA));
    }
}