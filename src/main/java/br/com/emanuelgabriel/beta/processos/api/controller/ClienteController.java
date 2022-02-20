package br.com.emanuelgabriel.beta.processos.api.controller;

import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.ClienteResponseDTO;
import br.com.emanuelgabriel.beta.processos.api.services.ClienteService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Recurso de Clientes", description = "Gerencia o recurso de clientes")
@Slf4j
@RestController
@RequestMapping(value = "/v1/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public ResponseEntity<Page<ClienteResponseDTO>> buscarTodosClientes(@PageableDefault(page = 0, size = 10, sort = "id") Pageable pageable) {
        log.info("GET /api/v1/clientes");
        var pageClienteDto = clienteService.buscarTodosClientes(pageable);
        return pageClienteDto != null ? ResponseEntity.ok().body(pageClienteDto) : ResponseEntity.ok().build();
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<ClienteResponseDTO> buscarPorID(@PathVariable Long id) {
        log.info("GET /api/v1/clientes/{}", id);
        var idCliente = clienteService.buscarPorID(id);
        return idCliente != null ? ResponseEntity.ok().body(idCliente) : ResponseEntity.notFound().build();
    }

}
