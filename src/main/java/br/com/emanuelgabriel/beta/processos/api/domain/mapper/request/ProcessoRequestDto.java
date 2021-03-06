package br.com.emanuelgabriel.beta.processos.api.domain.mapper.request;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessoRequestDto {

	@NotNull(message = "Campo tipo solicitação não pode ser nulo ou vazio")
	private TipoSolicitacaoInputCodRequestDto tipoSolicitacao;

}
