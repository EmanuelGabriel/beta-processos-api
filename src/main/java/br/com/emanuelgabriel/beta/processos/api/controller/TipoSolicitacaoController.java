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

import br.com.emanuelgabriel.beta.processos.api.domain.mapper.request.TipoSolicitacaoRequestDto;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.TipoSolicitacaoResponseDto;
import br.com.emanuelgabriel.beta.processos.api.services.TipoSolicitacaoService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * @author emanuel.sousa
 *
 */

@Tag(name = "Recurso de Tipo de Solicitação", description = "Gerencia o recurso de tipo de solicitação")
@Slf4j
@RestController
@RequestMapping(value = "/v1/tipo-solicitacao", produces = MediaType.APPLICATION_JSON_VALUE)
public class TipoSolicitacaoController {

	@Autowired
	private TipoSolicitacaoService tipoSolicitacaoService;

	@GetMapping
	public ResponseEntity<List<TipoSolicitacaoResponseDto>> buscarTodos() {
		log.info("GET /v1/tipo-solicitacao");
		var tipoSolicitacoes = tipoSolicitacaoService.buscarTodos();
		return tipoSolicitacoes != null ? ResponseEntity.ok().body(tipoSolicitacoes) : ResponseEntity.ok().build();
	}

	@GetMapping(value = "{idTipoSolicitacao}")
	public ResponseEntity<TipoSolicitacaoResponseDto> buscarPorId(@PathVariable Long idTipoSolicitacao) {
		log.info("GET /v1/tipo-solicitacao/{}", idTipoSolicitacao);
		var tipoSolicitacao = tipoSolicitacaoService.buscarPorID(idTipoSolicitacao);
		return tipoSolicitacao != null ? ResponseEntity.ok().body(tipoSolicitacao) : ResponseEntity.notFound().build();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping
	public ResponseEntity<TipoSolicitacaoResponseDto> criar(@Valid @RequestBody TipoSolicitacaoRequestDto request) {
		log.info("POST /v1/tipo-solicitacao - body {}", request);
		var tipoSolicitacaoResponse = tipoSolicitacaoService.criar(request);
		var location = getUri(tipoSolicitacaoResponse.getId());
		return ResponseEntity.created(location).build();
	}

	private URI getUri(Long id) {
		return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
	}

}
