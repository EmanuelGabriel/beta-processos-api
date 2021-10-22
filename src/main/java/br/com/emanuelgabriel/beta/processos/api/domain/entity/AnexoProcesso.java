package br.com.emanuelgabriel.beta.processos.api.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.emanuelgabriel.beta.processos.api.domain.enumerator.EnumAtendeAnexoProcesso;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "TB_ANEXO_PROCESSO")
public class AnexoProcesso implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_seq_anexoprocesso")
	private Long id;

	@Column(name = "caminho_arquivo")
	private String caminhoArquivo;

	@Column(name = "situacao_atende")
	private EnumAtendeAnexoProcesso atende;

	@Column(name = "data_triagem")
	private LocalDateTime dataTriagem;

	@Column(name = "observacao")
	private String observacao;

	@ManyToOne
	@JoinColumn(name = "fk_processo")
	private Processo processo;

	@Column(name = "bl_file")
	private byte[] file;

}
