package br.com.emanuelgabriel.beta.processos.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {

	@Query(value = "SELECT next value for seq_nu_protocolo", nativeQuery = true)
	Long gerarNumeroDoProtocolo();
	

}
