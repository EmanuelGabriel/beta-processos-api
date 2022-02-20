package br.com.emanuelgabriel.beta.processos.api.domain.repository;

import br.com.emanuelgabriel.beta.processos.api.domain.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
