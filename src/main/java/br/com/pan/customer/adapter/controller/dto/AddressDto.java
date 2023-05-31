package br.com.pan.customer.adapter.controller.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AddressDto {

    @JsonProperty("cep")
    private String postalCode;

    @JsonProperty("numero")
    private String number;

    @JsonProperty("complemento")
    private String complement;
}
