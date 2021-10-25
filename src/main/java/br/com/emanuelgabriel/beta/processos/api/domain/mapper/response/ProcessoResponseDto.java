package br.com.emanuelgabriel.beta.processos.api.domain.mapper.response;

import java.time.LocalDateTime;
import java.util.List;

import br.com.emanuelgabriel.beta.processos.api.domain.mapper.request.TipoSolicitacaoRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author emanuel.sousa
 * @since 22/10/2021
 *
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoResponseDto {

	private Long id;
	private Long protocolo;
	private LocalDateTime inicioProcesso;
	private LocalDateTime atualizacaoProcesso;
	private LocalDateTime prazoEstimado;
	private TipoSolicitacaoRequestDto tipoSolicitacao;
	private List<AnexoProcessoResponseDto> anexosProcesso;

}
