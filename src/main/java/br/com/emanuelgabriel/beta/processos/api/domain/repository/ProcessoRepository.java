package br.com.emanuelgabriel.beta.processos.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.Processo;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {

	@Query(value = "SELECT NEXT VALUE FOR TB_PROCESSO.seq_nu_protocolo", nativeQuery = true)
	Long gerarNumeroDoProtocolo();


}
