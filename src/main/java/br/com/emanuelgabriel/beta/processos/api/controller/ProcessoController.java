/**
 * 
 */
package br.com.emanuelgabriel.beta.processos.api.controller;

import java.net.URI;
import java.util.List;

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

import br.com.emanuelgabriel.beta.processos.api.domain.mapper.request.ProcessoRequestDto;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.ProcessoResponseDto;
import br.com.emanuelgabriel.beta.processos.api.services.ProcessoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * @author emanuel.sousa
 *
 */

@Tag(name = "Recurso de Processos", description = "Gerencia o recurso de processos")
@Slf4j
@RestController
@RequestMapping(value = "/v1/processos", produces = MediaType.APPLICATION_JSON_VALUE)
public class ProcessoController {

	@Autowired
	private ProcessoService processoService;

	@GetMapping(value = "{idProcesso}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ProcessoResponseDto> buscarPorId(@PathVariable Long idProcesso) {
		log.info("GET /v1/processos/{}", idProcesso);
		var processo = processoService.buscarPorId(idProcesso);
		return processo != null ? ResponseEntity.ok().body(processo) : ResponseEntity.notFound().build();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<ProcessoResponseDto> criar(@Valid @RequestBody ProcessoRequestDto request) {
		log.info("POST /v1/processos - body {}", request);
		var processo = processoService.criar(request);
		var location = getUri(processo.getId());
		return ResponseEntity.created(location).build();
	}

	@GetMapping
	public ResponseEntity<List<ProcessoResponseDto>> buscarTodos() {
		log.info("GET /v1/processos");
		var processos = processoService.buscarTodos();
		return processos != null ? ResponseEntity.ok().body(processos) : ResponseEntity.ok().build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
