package br.com.emanuelgabriel.beta.processos.api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.ContactType;

@Repository
public interface TipoContatoRepository extends JpaRepository<ContactType, Integer> {

}
