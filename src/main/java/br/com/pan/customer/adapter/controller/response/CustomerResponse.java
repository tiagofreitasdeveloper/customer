package br.com.pan.customer.adapter.controller.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class CustomerResponse {

    private String name;

    private String cpf;

    private LocalDate birthDate;

    private String phone;

    private AddressResponse address;
}
