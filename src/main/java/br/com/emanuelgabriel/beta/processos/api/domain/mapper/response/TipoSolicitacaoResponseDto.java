package br.com.emanuelgabriel.beta.processos.api.domain.mapper.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author emanuel.sousa
 *
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoSolicitacaoResponseDto {

	private Long id;
	private String tipoSolicitacao;

}
