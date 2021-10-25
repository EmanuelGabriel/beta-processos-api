package br.com.emanuelgabriel.beta.processos.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.TipoSolicitacao;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.GenericMapper;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.request.TipoSolicitacaoRequestDto;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.TipoSolicitacaoResponseDto;
import br.com.emanuelgabriel.beta.processos.api.domain.repository.TipoSolicitacaoRepository;
import br.com.emanuelgabriel.beta.processos.api.services.exceptions.RegraNegocioException;
import br.com.emanuelgabriel.beta.processos.api.services.exceptions.TipoSolicitacaoNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class TipoSolicitacaoService {

	@Autowired
	private TipoSolicitacaoRepository tipoSolicitacaoRepository;

	@Autowired
	private GenericMapper mapper;

	public TipoSolicitacaoResponseDto buscarPorID(Long idTipoSolicitacao) {
		log.info("Busca tipo de solicitação por ID: {}", idTipoSolicitacao);
		var tipoSolicitacao = tipoSolicitacaoRepository.findById(idTipoSolicitacao).orElseThrow(
				() -> new TipoSolicitacaoNaoEncontradoException("Tipo de solicitação de ID não encontrado"));
		return mapper.paraObjeto(tipoSolicitacao, TipoSolicitacaoResponseDto.class);
	}

	public List<TipoSolicitacaoResponseDto> buscarTodos() {
		log.info("Busca todos os tipos de solicitações");
		return mapper.paraLista(tipoSolicitacaoRepository.findAll(), TipoSolicitacaoResponseDto.class);
	}

	public TipoSolicitacaoResponseDto criar(TipoSolicitacaoRequestDto request) {
		log.info("Cria um tipo de solicitação - body: {}", request);
		var tipoSolicitacaoExistente = tipoSolicitacaoRepository.findByTipoSolicitacao(request.getTipoSolicitacao());
		if (tipoSolicitacaoExistente != null && !tipoSolicitacaoExistente.equals(request)) {
			throw new RegraNegocioException("Já existe tipo de solicitação registrada com este nome");
		}
	
		var tipoSolicitacaoSalvo = mapper.paraObjeto(request, TipoSolicitacao.class);
	
		return mapper.paraObjeto(tipoSolicitacaoRepository.save(tipoSolicitacaoSalvo), TipoSolicitacaoResponseDto.class);
	}

}
