package br.com.emanuelgabriel.beta.processos.api.domain.mapper.response;

import java.time.LocalDateTime;

import br.com.emanuelgabriel.beta.processos.api.domain.enumerator.EnumAtendeAnexoProcesso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AnexoProcessoResponseDto {

	private Long id;
	private String caminhoArquivo;
	private EnumAtendeAnexoProcesso atende;
	private LocalDateTime dataTriagem;
	private String observacao;
	private byte[] file;

}
