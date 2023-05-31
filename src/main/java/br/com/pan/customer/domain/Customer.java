package br.com.pan.customer.domain;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@Builder(toBuilder = true)
public class Customer {

    private String cpf;

    private String name;

    private LocalDate birthDate;

    private Address address;

    private Contact contact;
}
