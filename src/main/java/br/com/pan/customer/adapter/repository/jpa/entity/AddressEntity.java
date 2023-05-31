package br.com.pan.customer.adapter.repository.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "endereco")
public class AddressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "endereco_id")
    private Long id;

    @Column(name = "cep")
    private String postalCode;

    @Column(name = "rua")
    private String street;

    @Column(name = "numero")
    private String number;

    @Column(name = "bairro")
    private String district;

    @Column(name = "complemento")
    private String complement;

    @Column(name = "cidade")
    private String city;

    @Column(name = "estado")
    private String state;
}
