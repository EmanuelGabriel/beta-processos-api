package br.com.emanuelgabriel.beta.processos.api.services;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.Processo;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.GenericMapper;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.request.ProcessoRequestDto;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.ProcessoResponseDto;
import br.com.emanuelgabriel.beta.processos.api.domain.repository.ProcessoRepository;
import br.com.emanuelgabriel.beta.processos.api.domain.repository.TipoSolicitacaoRepository;
import br.com.emanuelgabriel.beta.processos.api.services.exceptions.ProcessoNaoEncontradoException;
import br.com.emanuelgabriel.beta.processos.api.services.exceptions.TipoSolicitacaoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProcessoService {
 
	@Autowired
	private ProcessoRepository processoRepository;
	
	@Autowired
	private TipoSolicitacaoRepository tipoSolicitacaoRepository;

	@Autowired
	private GenericMapper mapper;

	@Transactional(readOnly = true)
	public ProcessoResponseDto buscarPorId(Long idProcesso) {
		log.info("Busca um Processo por seu ID: {}", idProcesso);
		var processo = processoRepository.findById(idProcesso)
				.orElseThrow(() -> new ProcessoNaoEncontradoException("Processo de ID não encontrado"));
		return mapper.paraObjeto(processo, ProcessoResponseDto.class);
	}

	public ProcessoResponseDto criar(ProcessoRequestDto request) {
		log.info("Cria um Processo - body {}", request);
		
		var tipoSolicitacao = tipoSolicitacaoRepository.findById(request.getTipoSolicitacao().getId())
				.orElseThrow(() -> new TipoSolicitacaoNaoEncontradoException("Tipo de solicitação de ID não encontrado"));

		var processo = mapper.paraObjeto(request, Processo.class);
		processo.setInicioProcesso(LocalDateTime.now());
		processo.setPrazoEstimado(LocalDateTime.now().plusDays(15)); // TODO: PRAZO DE 15 DIAS
		processo.setTipoSolicitacao(tipoSolicitacao);
		
		var processoSalvo = processoRepository.save(processo);
		
		String numeroProcolo = processo.gerarNumeroDoProtocolo();
		processoSalvo.setNumeroProtocolo(numeroProcolo);
		

//		if (isNull(processo.getProtocolo())) {
//			processo.setProtocolo(processoRepository.gerarNumeroDoProtocolo());
//		}

		return mapper.paraObjeto(processoSalvo, ProcessoResponseDto.class);
	}	
	
	public List<ProcessoResponseDto> buscarTodos() {
		log.info("Buscar todos os processos");
		return mapper.paraLista(processoRepository.findAll(), ProcessoResponseDto.class);
	}

}
