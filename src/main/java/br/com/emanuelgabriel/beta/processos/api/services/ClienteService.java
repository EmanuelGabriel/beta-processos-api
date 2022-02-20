package br.com.emanuelgabriel.beta.processos.api.services;

import br.com.emanuelgabriel.beta.processos.api.domain.mapper.ClienteModelMapper;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.GenericMapper;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.ClienteResponseDTO;
import br.com.emanuelgabriel.beta.processos.api.domain.repository.ClienteRepository;
import br.com.emanuelgabriel.beta.processos.api.services.exceptions.ClienteNaoEncontradoException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private GenericMapper genericMapper;

    @Autowired
    private ClienteModelMapper mapper;

    /**
     * @return List<ClienteResponseDTO>
     */
    public Page<ClienteResponseDTO> buscarTodosClientes(Pageable pageable) {
        var pageCliente = clienteRepository.findAll(pageable);
        log.info("Busca todos os clientes paginados - PageNumber: {}; PageSize: {}", pageable.getPageNumber(), pageable.getPageSize());
        return mapper.mapEntityPageToDTO(pageable, pageCliente);
    }


    /**
     * @param id
     * @return ClienteResponseDTO
     */
    public ClienteResponseDTO buscarPorID(Long id) {
        log.info("Buscar cliente por ID - {}", id);
        var idCliente = clienteRepository.findById(id);
        if (!idCliente.isPresent()) {
            throw new ClienteNaoEncontradoException("Cliente de ID não encontrado");
        }
        return genericMapper.paraObjeto(idCliente.get(), ClienteResponseDTO.class);
    }
}
