package br.com.estudosjava.apirest.resources.exceptions;

import br.com.estudosjava.apirest.services.exceptions.DataIntegratyViolationException;
import br.com.estudosjava.apirest.services.exceptions.ObjectNotFoundException;
import org.apache.catalina.connector.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ReourceEcxeptionHandlerTest {

    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado!";
    public static final String EMAIL_JA_CADASTRADO = "Email já cadastrado!";
    @InjectMocks
    private ReourceEcxeptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void quandoObjetoNaoEncontradoExceptionEntaoRetorneUmResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler.objectNotFound(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO), new MockHttpServletRequest());

        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(OBJETO_NAO_ENCONTRADO, response.getBody().getError());
        assertEquals(404, response.getBody().getStatus());
        assertNotEquals("/uder/2", response.getBody().getPath());
        assertNotEquals(LocalDateTime.now(), response.getBody().getTimestamp());
    }

    @Test
    void quandoViolacaoDeIntegridadeDeDadosEntaoRetorneUmResponseEntity() {
        ResponseEntity<StandardError> response = exceptionHandler.dataIntegratyViolation(new DataIntegratyViolationException(EMAIL_JA_CADASTRADO), new MockHttpServletRequest());
        assertNotNull(response);
        assertNotNull(response.getBody());
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertEquals(ResponseEntity.class, response.getClass());
        assertEquals(StandardError.class, response.getBody().getClass());
        assertEquals(EMAIL_JA_CADASTRADO, response.getBody().getError());
        assertEquals(400, response.getBody().getStatus());
    }
}