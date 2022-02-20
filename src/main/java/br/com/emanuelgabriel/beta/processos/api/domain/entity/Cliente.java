package br.com.emanuelgabriel.beta.processos.api.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "sales", name = "customers")
public class Cliente {

    @Id
    @Column(name = "customer_id", nullable = false)
    private Long id;

    @Column(name = "first_name")
    private String primeiroNome;

    @Column(name = "last_name")
    private String ultimoNome;

    @Column(name = "phone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "street")
    private String rua;

    @Column(name = "city")
    private String cidade;

    @Column(name = "state")
    private String estado;

    @Column(name = "zip_code")
    private String codigoPostal;

}
