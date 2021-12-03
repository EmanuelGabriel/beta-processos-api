package br.com.emanuelgabriel.beta.processos.api.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.emanuelgabriel.beta.processos.api.domain.mapper.request.TipoContatoRequestDTO;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.TipoContatoResponseDTO;
import br.com.emanuelgabriel.beta.processos.api.services.TipoContatoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Tag(name = "Recurso de Tipo de Contato", description = "Gerencia o recurso de Tipo de Contato")
@Slf4j
@RestController
@RequestMapping(value = "/v1/tipo-contatos", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoContatoController {

	@Autowired
	private TipoContatoService tipoContatoService;

	@GetMapping(value = "{codTipoContato}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TipoContatoResponseDTO> buscarPorId(@PathVariable Integer codTipoContato) {
		log.info("GET /v1/tipo-contatos/{}", codTipoContato);

		var tipoContato = tipoContatoService.buscarPorId(codTipoContato);
		return tipoContato != null ? ResponseEntity.ok().body(tipoContato) : ResponseEntity.notFound().build();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<TipoContatoResponseDTO> criar(@Valid @RequestBody TipoContatoRequestDTO request) {
		log.info("POST  /v1/tipo-contatos - body {}", request);
		var tipoProcesso = tipoContatoService.criar(request);
		var location = getUri(tipoProcesso.getId());
		return ResponseEntity.created(location).build();
	}

	private URI getUri(Integer id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
