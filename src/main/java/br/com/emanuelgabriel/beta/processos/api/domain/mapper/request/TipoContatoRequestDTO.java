package br.com.emanuelgabriel.beta.processos.api.domain.mapper.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoContatoRequestDTO {

	private String nome;

}
