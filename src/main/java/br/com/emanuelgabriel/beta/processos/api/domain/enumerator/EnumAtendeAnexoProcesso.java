package br.com.emanuelgabriel.beta.processos.api.domain.enumerator;

import lombok.Getter;

@Getter
public enum EnumAtendeAnexoProcesso {

	NAO(0, "Não"), 
	SIM(1, "Sim");

	private Integer id;
	private String descricao;

	EnumAtendeAnexoProcesso(Integer id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
}
