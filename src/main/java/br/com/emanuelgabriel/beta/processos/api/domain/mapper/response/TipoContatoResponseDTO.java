package br.com.emanuelgabriel.beta.processos.api.domain.mapper.response;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoContatoResponseDTO {

	private Integer id;
	private String nome;
	private LocalDate dataModificacao;
}
