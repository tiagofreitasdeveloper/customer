package br.com.pan.customer.adapter.controller.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @JsonProperty("nome")
    private String name;

    @JsonProperty("cpf")
    private String cpf;

    @JsonFormat(pattern="dd-MM-yyyy")
    @JsonProperty("data_nascimento")
    private LocalDate birthDate;

    @JsonProperty("telefone")
    private String phone;

    @JsonProperty("endereco")
    private AddressDto address;
}
