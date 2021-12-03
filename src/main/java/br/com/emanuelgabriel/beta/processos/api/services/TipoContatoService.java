package br.com.emanuelgabriel.beta.processos.api.services;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.ContactType;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.GenericMapper;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.request.TipoContatoRequestDTO;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.TipoContatoResponseDTO;
import br.com.emanuelgabriel.beta.processos.api.domain.repository.TipoContatoRepository;
import br.com.emanuelgabriel.beta.processos.api.services.exceptions.TipoContatoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TipoContatoService {

	@Autowired
	private GenericMapper mapper;

	@Autowired
	private TipoContatoRepository tipoContatoRepository;

	public TipoContatoResponseDTO buscarPorId(Integer codTipoContato) {
		log.info("Busca tipo de contato por ID {}", codTipoContato);
		var tipoContato = tipoContatoRepository.findById(codTipoContato)
				.orElseThrow(() -> new TipoContatoNaoEncontradoException("Tipo de contato não encontrado"));

		return mapper.paraObjeto(tipoContato, TipoContatoResponseDTO.class);

	}
	
	public TipoContatoResponseDTO criar(TipoContatoRequestDTO request) {
		log.info("Criar um tipo de contato por nome: {}", request);
		var tipoContato = mapper.paraObjeto(request, ContactType.class);
		tipoContato.setDataModificacao(LocalDateTime.now());
		return mapper.paraObjeto(tipoContatoRepository.save(tipoContato), TipoContatoResponseDTO.class);
	}
}
