package br.com.emanuelgabriel.beta.processos.api.domain.mapper.request;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoSolicitacaoInputCodRequestDto {

	@NotBlank(message = "Id não pode ser vazio")
	private Long id;

}
