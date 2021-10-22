package br.com.emanuelgabriel.beta.processos.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.beta.processos.api.domain.mapper.GenericMapper;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.ProcessoResponseDto;
import br.com.emanuelgabriel.beta.processos.api.domain.repository.ProcessoRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProcessoService {

	@Autowired
	private ProcessoRepository processoRepository;

	@Autowired
	private GenericMapper mapper;

	@Transactional(readOnly = true)
	public ProcessoResponseDto buscarPorId(Long idProcesso) {
		log.info("Busca um Processo por seu ID: {}", idProcesso);
		return mapper.paraObjeto(processoRepository.findById(idProcesso), ProcessoResponseDto.class);
	}

}
