package br.com.emanuelgabriel.beta.processos.api.services.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ClienteNaoEncontradoException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public ClienteNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}
