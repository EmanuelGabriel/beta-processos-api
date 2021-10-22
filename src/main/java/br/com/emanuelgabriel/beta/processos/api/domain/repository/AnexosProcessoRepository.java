package br.com.emanuelgabriel.beta.processos.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.AnexoProcesso;

@Repository
public interface AnexosProcessoRepository extends JpaRepository<AnexoProcesso, Long> {

}
