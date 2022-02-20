package br.com.emanuelgabriel.beta.processos.api.domain.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClienteResponseDTO {

    private Long id;
    private String primeiroNome;
    private String ultimoNome;
    private String telefone;
    private String email;
    private String rua;
    private String cidade;
    private String estado;
    private String codigoPostal;

}
