package br.com.emanuelgabriel.beta.processos.api.domain.mapper;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.Cliente;
import br.com.emanuelgabriel.beta.processos.api.domain.mapper.response.ClienteResponseDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * ClienteModelMapper
 */

@Component
public class ClienteModelMapper {

    @Autowired
    private ModelMapper modelMapper;

    /**
     * @param cliente
     * @return dto
     * @author emanuel.sousa
     */
    public ClienteResponseDTO entityToDTO(Cliente cliente) {
        return modelMapper.map(cliente, ClienteResponseDTO.class);
    }

    /**
     * @param dto
     * @return entity
     * @author emanuel.sousa
     */
    public Cliente dtoToEntity(ClienteResponseDTO dto) {
        return this.modelMapper.map(dto, Cliente.class);
    }


    /**
     * @param clientes
     * @return List
     * @author emanuel.sousa
     */
    public List<ClienteResponseDTO> listEntityToDTO(List<Cliente> clientes) {
        return clientes.stream().map(this::entityToDTO).collect(Collectors.toList());
    }


    /**
     * @param categorias
     * @return List<Cliente>
     */
    public List<Cliente> listDtoToEntity(List<ClienteResponseDTO> categorias) {
        return categorias.stream().map(this::dtoToEntity).collect(Collectors.toList());
    }

    /**
     * @param pageable
     * @param pageCliente
     * @return Page<ClienteResponseDTO>
     */
    public Page<ClienteResponseDTO> mapEntityPageToDTO(Pageable pageable, Page<Cliente> pageCliente) {
        List<ClienteResponseDTO> listDtos = listEntityToDTO(pageCliente.getContent());
        return new PageImpl<>(listDtos, pageable, pageCliente.getTotalElements());
    }
}
