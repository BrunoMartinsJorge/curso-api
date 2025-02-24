package br.com.estudosjava.apirest.services.Impl;

import br.com.estudosjava.apirest.domain.User;
import br.com.estudosjava.apirest.domain.dto.UserDTO;
import br.com.estudosjava.apirest.repositories.UserRepository;
import br.com.estudosjava.apirest.services.exceptions.DataIntegratyViolationException;
import br.com.estudosjava.apirest.services.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class UserServiceImplTest {

    public static final Integer ID = 1;
    public static final String NOME = "Teste";
    public static final String EMAIL = "Teste@gmail.com";
    public static final String SENHA = "12345678";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado!";
    public static final int INDEX = 0;
    public static final String E_MAIL_JA_ESTA_CADASTRADO_EM_NOSSO_SISTEMA = "E-mail já está cadastrado em nosso sistema!";
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
        when(repository.findById(anyInt())).thenReturn(userOptional);

        User response = service.findById(ID);

        // Aqui está sendo verificado se o valor sejá nulo.
        assertNotNull(response);

        // Depois de verificar se o objeto não é nulo, assim então é liberado para validar as demais validações.

        // Aqui está sendo realizada uma verificação para que sempre seja retornado um User.
        assertEquals(User.class, response.getClass());

        // Aqui está sendo realizada uma verificação para que sempre seja um Id.
        assertEquals(ID, response.getId());
        // Aqui está sendo realizada uma verificação para que sempre seja um Nome.
        assertEquals(NOME, response.getNome());
        // Aqui está sendo realizada uma verificação para que sempre seja um Email.
        assertEquals(EMAIL, response.getEmail());
    }

    @Test
    void quandoBuscarPorIdRetorneUmaExceptionObjetoNaoEncontrado(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));

        try{
            service.findById(ID);
        }catch (Exception ex){
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
    }

    @Test
    void quandoBuscarTodosRetorneUmaListaDeUsuarios () {
        when(repository.findAll()).thenReturn(List.of(user));
        List<User> response = service.findAll();

        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(INDEX).getClass());

        assertEquals(ID, response.get(INDEX).getId());
        assertEquals(NOME, response.get(INDEX).getNome());
        assertEquals(EMAIL, response.get(INDEX).getEmail());
        assertEquals(SENHA, response.get(INDEX).getSenha());
    }

    @Test
    void quandoCriarRetorneSucesso() {
        when(repository.save(any())).thenReturn(user);

        User response = service.create(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(SENHA, response.getSenha());
    }

    @Test
    void quandoCriarRetorneUmaExecaoDeIntegridadeDeDados() {
        when(repository.findByEmail(anyString())).thenReturn(userOptional);

        try{
            userOptional.get().setId(2);
            service.create(userDTO);
        }catch (Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals(E_MAIL_JA_ESTA_CADASTRADO_EM_NOSSO_SISTEMA, e.getMessage());
        }
    }

    @Test
    void quandoAlterarRetorneSucesso() {
        when(repository.save(any())).thenReturn(user);

        User response = service.update(userDTO);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NOME, response.getNome());
        assertEquals(EMAIL, response.getEmail());
        assertEquals(SENHA, response.getSenha());
    }

    @Test
    void quandoAlterarRetorneUmaExecaoDeIntegridadeDeDados() {
        when(repository.findByEmail(anyString())).thenReturn(userOptional);

        try{
            userOptional.get().setId(2);
            service.create(userDTO);
        }catch (Exception e){
            assertEquals(DataIntegratyViolationException.class, e.getClass());
            assertEquals(E_MAIL_JA_ESTA_CADASTRADO_EM_NOSSO_SISTEMA, e.getMessage());
        }
    }

    private void startUser() {
        user = new User(ID, NOME, EMAIL, SENHA);
        userDTO = new UserDTO(ID, NOME, EMAIL, SENHA);
        userOptional = Optional.of(new User(ID, NOME, EMAIL, SENHA));
    }
}