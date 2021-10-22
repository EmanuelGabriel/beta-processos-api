package br.com.emanuelgabriel.beta.processos.api.domain.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

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
@Table(name = "TB_PROCESSO")
public class Processo implements Serializable {

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_seq_processo")
	private Long id;

	@SequenceGenerator(name = "seq_nu_protocolo", sequenceName = "seq_nu_protocolo", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_nu_protocolo")
	@Column(name = "nu_protocolo")
	private Long protocolo;

	@Column(name = "dt_inicioprocesso")
	@CreationTimestamp
	private LocalDateTime inicioProcesso;

	@Column(name = "dt_atualizacaoprocesso")
	@UpdateTimestamp
	private LocalDateTime atualizacaoProcesso;

	@Column(name = "dt_prazoestimado")
	private LocalDateTime prazoEstimado;

	@ManyToOne
	@JoinColumn(name = "fk_tiposolicitacao", insertable = false, updatable = false)
	private TipoSolicitacao tipoSolicitacao;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "processo", orphanRemoval = true)
	private List<AnexoProcesso> anexosProcesso;

}
