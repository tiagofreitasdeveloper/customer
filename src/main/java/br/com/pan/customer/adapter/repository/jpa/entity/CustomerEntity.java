package br.com.pan.customer.adapter.repository.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cliente")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cliente_id")
    private Long id;

    @Column(name = "cpf")
    private String cpf;

    @Column(name = "nome")
    private String name;

    @Column(name = "data_nascimento")
    private LocalDate birthDate;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "endereco_id", referencedColumnName = "endereco_id")
    private AddressEntity address;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "contato_id", referencedColumnName = "contato_id")
    private ContactEntity contact;
}
